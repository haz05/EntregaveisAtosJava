import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicoAPIService {

  constructor(private http: HttpClient) {

  }
  public getProduto(): Observable<any> {
    return this.http.get('http://localhost:8080/produtos/cadastrar');
  }
  public postProduto(produtoNovo:any):  Observable<any> {
    return this.http.post('http://localhost:8080/produtos/cadastrar',produtoNovo);
  }
  
  public putProduto(produtoNovo:any,produtoid:number):  Observable<any> {
    return this.http.put('http://localhost:8080/produtos/'+ produtoid , produtoNovo);
  }

  public deleteProduto(produtoid:number): Observable<any> {
    return this.http.delete('http://localhost:8080/produtos/' + produtoid);
  }
  public getIdProduto(produtoid:number): Observable<any> {
    return this.http.get('http://localhost:8080/produtos/' + produtoid);
  }
}
