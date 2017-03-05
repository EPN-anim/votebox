import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {DropdownModule} from 'primeng/primeng';

import {routing} from "./app.routes";
import {VoteComponent} from "./vote.component";
import {WelcomeComponent} from "./welcome.component";

@NgModule({
  declarations: [
    WelcomeComponent,
    AppComponent,
    VoteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DropdownModule,
    routing
  ],
  providers: [],
  bootstrap: [WelcomeComponent]
})
export class AppModule { }
