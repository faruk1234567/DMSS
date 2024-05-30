import { HtOfflineCollectionComponent } from './ht-offline-collection/ht-offline-collection.component';
import { HtOnlineCollectionComponent } from './ht-online-collection/ht-online-collection.component';
import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HtDemandComponent} from "./ht-demand/ht-demand.component";





const routes: Routes = [
  {
    path: 'ht-demand',
    component: HtDemandComponent,
    data: {
      title: 'Holding Tax Demand'
    }
  },
  {
    path: 'ht-online-collection',
    component: HtOnlineCollectionComponent,
    data: {
      title: 'Holding Tax Online Collection'
    }
  },
  {
    path: 'ht-offline-collection',
    component: HtOfflineCollectionComponent,
    data: {
      title: 'Holding Tax Offline Collection'
    }
  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReportHtRoutingModule {

}
