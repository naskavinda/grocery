import {Injectable} from '@angular/core';
import {Item} from '../model/Item';
import {SizeChart} from '../model/SizeChart';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() {
  }

  public getItemList(): Item[] {
    return [
      new Item('t shirt',
      'this is test description for the item',
      './assert/img/s001.jpg',
        [new SizeChart('sad', 'dsa', 'dsa')])];
  }
}
