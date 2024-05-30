import { TlsCollectionComponent } from './tls-collection/tls-collection.component';
import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {TlsRecoverDetailComponent} from "./tls-recover/tls-recover-detail.component";




const routes: Routes = [
  {
    path: 'tls-recover-detail',
    component: TlsRecoverDetailComponent,
    data: {
      title: 'Trade License Recover In details'
    }
  },
  {
    path: 'tls-demand',
    component: TlsCollectionComponent,
    data: {
      title: 'Trade License Demand'
    }
  },
  {
    path: 'tls-collection',
    component: TlsCollectionComponent,
    data: {
      title: 'Trade License Collection'
    }
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReportTlsRoutingModule {

}
