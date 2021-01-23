import {ItemColor} from './ItemColor';

export class Item {

  constructor(public id: number,
              public name: string,
              public imagePath: string,
              public rating: number,
              public numberOfRating: number,
              public itemColors: ItemColor[]) {
  }
}
