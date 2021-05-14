import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Componente1Component } from './componente1/componente1.component';
import { Componente2Component } from './componente2/componente2.component';
import { Componente3Component } from './componente3/componente3.component';
import { Componente4Component } from './componente4/componente4.component';
import { CommonModule } from '@angular/common';
import { ComponenteServicoComponent } from './componente-servico/componente-servico.component';

import {HttpClient, HttpClientModule} from '@angular/common/http';
import { ComponenteAlbumComponent } from './componente-album/componente-album.component';
import { ComponentephotosComponent } from './componentephotos/componentephotos.component';
import { ComponenteFinalAPIComponent } from './componente-final-api/componente-final-api.component';

import { NgxBootstrapMultiselectModule } from 'ngx-bootstrap-multiselect';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';


@NgModule({
  declarations: [
    AppComponent,
    Componente1Component,
    Componente2Component,
    Componente3Component,
    Componente4Component,
    ComponenteServicoComponent,
    ComponenteAlbumComponent,
    ComponentephotosComponent,
    ComponenteFinalAPIComponent,
    
  ],
  imports: [

    CommonModule,

    BrowserModule,

    AppRoutingModule,

    ReactiveFormsModule,

    HttpClientModule,

    FormsModule,

    NgxBootstrapMultiselectModule,

    NgMultiSelectDropDownModule.forRoot()

  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
