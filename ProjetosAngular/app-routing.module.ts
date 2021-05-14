import { ComponentephotosComponent } from './componentephotos/componentephotos.component';
import { ComponenteAlbumComponent } from './componente-album/componente-album.component';
import { ComponenteServicoComponent } from './componente-servico/componente-servico.component';
import { Componente4Component } from './componente4/componente4.component';
import { Componente3Component } from './componente3/componente3.component';
import { Componente1Component } from './componente1/componente1.component';
import { Componente2Component } from './componente2/componente2.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponenteFinalAPIComponent } from './componente-final-api/componente-final-api.component';

const routes: Routes = [
  {path:'componente1',component:Componente1Component},
  {path:'componente2',component:Componente2Component},
  {path:'componente3',component:Componente3Component},
  {path:'componente4',component:Componente4Component},
  {path:'componenteServico',component:ComponenteServicoComponent},
  {path:'componenteAlbum',component:ComponenteAlbumComponent},
  {path:'componentephotos',component:ComponentephotosComponent},
  {path:'componenteFinalAPI',component:ComponenteFinalAPIComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
