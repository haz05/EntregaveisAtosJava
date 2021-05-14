import {HttpClient} from '@angular/common/http';
import { Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Servico1Service {

  constructor(private http:HttpClient)
   {

    }
    public getPhotos():Observable<any>
    {
      return this.http.get('https://jsonplaceholder.typicode.com/photos');
    }

}
