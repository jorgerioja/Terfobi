import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import baserUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private HttpClient: HttpClient) {}

  public añadirUsuario(user: any){
    return this.HttpClient.post(`${baserUrl}/usuarios/`, user);
  }

}
