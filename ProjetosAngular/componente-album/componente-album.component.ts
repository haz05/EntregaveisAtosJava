import { Servico2Service } from './../services/servico2.service';
import { Album } from './../models/Album.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-album',
  templateUrl: './componente-album.component.html',
  styleUrls: ['./componente-album.component.css']
})
export class ComponenteAlbumComponent implements OnInit {

  album:Album;
  erro:any;
  selecionado = null;
  redirecionar(album){
    this.selecionado = album;
  }
  buscar(album){

    //<a routerLink="/componente4" >componente 4</a>

  }

  constructor(private albumservico:Servico2Service) {
    this.getter();
   }

  ngOnInit(): void {
  }
  getter()
  {
    this.albumservico.getAlbum().subscribe(
      (data:Album) =>{
        this.album = data;
        console.log('o que retornou em data:',data);
        console.log('Variavel album:',this.album);
      },(error:any)=>{
        this.erro = error;
        console.error('ERRO:', this.erro);
      }

    );

  }

}
