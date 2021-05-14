import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ServicoAPIService } from './../services/servico-api.service';
import { Produto } from './../models/Produto.model';
import { FormControl } from '@angular/forms';

import { IMultiSelectOption } from 'ngx-bootstrap-multiselect';;
import { IDropdownSettings } from 'ng-multiselect-dropdown';
@Component({
  selector: 'app-componente-final-api',
  templateUrl: './componente-final-api.component.html',
  styleUrls: ['./componente-final-api.component.css']

})
export class ComponenteFinalAPIComponent implements OnInit {

  produtos: Array<any>;
  consulta: Array<any>;
  erro: any;
  produtoNovo: any;
  produtoid: number;
  soma: number;
  dropdownList: Array<any>;
  selectedItems = [];
  dropdownSettings: IDropdownSettings;
  array: Array<any>;

  constructor(private produtoServico: ServicoAPIService) {

  }

  ngOnInit(): void {
    this.getter();
    this.produtoNovo = {};

    this.dropdownList = this.produtos;
    this.selectedItems = [

    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'denominacao',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

  }
  getter() {
    this.produtoServico.getProduto().subscribe(
      dados => this.produtos = dados
      /*
      (data: Produto) => {
        this.produtos = data;
        console.log('o que retornou em data:', data);
        console.log('Variavel produto:', this.produtos);
      }, (error: any) => {
        this.erro = error;
        console.error('ERRO:', this.erro);
      }
      */
    );

  }
  postProduto(frm: FormGroup) {
    this.produtoServico.postProduto(this.produtoNovo).subscribe(
      dados => {
        this.produtos.push(dados);
        frm.reset();
        /*
        (data: Produto) => {
          this.produtos.
          console.log('o que retornou em data:', data);
          console.log('Variavel produto:', this.produtos);
          frm.reset();
        }, (error: any) => {
          this.erro = error;
          console.error('ERRO:', this.erro);
        }
        */

      });
  }
  editarProduto(p) {
    this.produtoNovo.id = p.id;
    this.produtoNovo.codigo = p.codigo;
    this.produtoNovo.denominacao = p.denominacao;
    this.produtoNovo.preco = p.preco;
    this.getter();


  }

  putProduto(frm: FormGroup) {
    this.produtoServico.putProduto(this.produtoNovo, this.produtoNovo.id).subscribe(
      dados => {
        this.produtos.push(dados);
        frm.reset();
        this.getter();
      });
  }
  saveProduto(frm: FormGroup) {
    if (this.produtoNovo.id) {
      this.putProduto(frm);
      console.log('tem id:');

    } else {
      this.postProduto(frm);
      console.log('NAO tem id:');
      console.log(this.produtoNovo.preco);
    }

  }
  deleteProduto(p) {
    this.produtoServico.deleteProduto(p.id).subscribe(
      dados => {
        this.getter();
      }
    );
  }
  orcamentoProduto(frmorcam: FormGroup) {
    this.produtoServico.getIdProduto(5).subscribe(
      dados => this.consulta = dados
      
    );
    this.array = frmorcam.value;
    console.log(this.array);
    this.soma = 0;

    function* entries(obj) {
      for (let key of Object.keys(obj)) {
        yield [key, obj[key]];
      }
    }
    
    for (let [key, value] of entries(this.array)) {
      console.log(key);
      console.log(value);
      const a= value;
      for (let [key, value] of entries(a)) {
        console.log(key);
        console.log(value.id);
        for(let p of this.produtos){
          if(p.id == value.id){
            console.log(this.produtos);
            this.soma += p.preco ;
          }

        }
        /*  //não sei pq nao retornoava pela api 
        this.produtoServico.getIdProduto(value.id).subscribe(
          dados => this.consulta = dados
        
        );
        */
        console.log('-----');
        console.log(this.soma);
      }
    }
    this.produtoNovo.soma = this.soma;
    frmorcam.reset();
    
    //this.produtoServico.getIdProduto(id).subscribe()

    //this.soma += preco;


    //console.log(this.soma);
    //this.produtoNovo.soma = this.soma;
    //frmorcam.reset();

  }
  limparForm(frm: FormGroup) {
    frm.reset();

  }

  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
}
