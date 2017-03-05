import {RouterModule, Routes} from "@angular/router";
import {VoteComponent} from "./vote.component";
import {AppComponent} from "./app.component";

export const routes: Routes = [
  {path: '', redirectTo: '/votusOperandi',pathMatch: 'full'},
  {path: 'votusOperandi', component: AppComponent},
  {path: 'votusOperandi/:voteId', component: VoteComponent}
];

export const routing = RouterModule.forRoot(routes,{ useHash: true });
