import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UserComponent} from "./user/user.component";


const routes: Routes = [
  {
    path: 'user',
    component: UserComponent,
    data: {
      title: 'User'
    }
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule {

}
