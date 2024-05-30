package com.dmss.spring.login.controllers;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.Role;
import com.dmss.spring.login.models.User;
import com.dmss.spring.login.payload.request.LoginRequest;
import com.dmss.spring.login.payload.request.SignupRequest;
import com.dmss.spring.login.payload.response.JwtResponse;
import com.dmss.spring.login.payload.response.MessageResponse;
import com.dmss.spring.login.repository.RoleRepository;
import com.dmss.spring.login.repository.UserRepository;
import com.dmss.spring.login.security.jwt.JwtUtils;
import com.dmss.spring.login.security.services.UserDetailsImpl;
import com.dmss.spring.login.services.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (userDetails.getMunicipalityId() != null && userDetails.getMunicipalityId() > 0) {
            Municipality municipality = municipalityService.getMunicipalityById(userDetails.getMunicipalityId());
            userDetails.setMunicipalityName(municipality.getName());
        }

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getName(), userDetails.getEmail(), userDetails.getMunicipalityId(), userDetails.getMunicipalityName(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()), Integer.parseInt(signUpRequest.getMunicipalityId()), signUpRequest.getName());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles != null) {
            for (String strRole : strRoles) {
                Role adminRole = roleRepository.findByName(strRole).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(adminRole);
            }
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
