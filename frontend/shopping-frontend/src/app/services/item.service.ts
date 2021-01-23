import {Injectable} from '@angular/core';
import {Item} from '../model/Item';
import {ItemSize} from '../model/ItemSize';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) {
  }

  public getItems(): Observable<Item[]> {
    // const headers = new HttpHeaders({'Authorization': this.token, 'Content-Type': 'application/json'});
    const url = 'http://localhost:9091/api/items';
    return this.http.get<Item[]>(url);
  }
}
