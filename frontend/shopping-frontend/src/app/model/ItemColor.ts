import {ItemSize} from './ItemSize';

export class ItemColor {

  constructor(public id: number,
              public color: string,
              public itemSizes: ItemSize[]) {
  }
}
