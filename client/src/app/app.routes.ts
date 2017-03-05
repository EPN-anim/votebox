import {RouterModule, Routes} from "@angular/router";
import {VoteComponent} from "./vote.component";
import {AppComponent} from "./app.component";



export const routes: Routes = [
    {path: '', component: AppComponent},
    {path: ':/voteId', component: VoteComponent}
];

export const routing = RouterModule.forRoot(routes,{ useHash: true });
