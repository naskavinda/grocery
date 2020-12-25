import {SizeChart} from './SizeChart';

export class Item {

  constructor(public itemName: string,
              public description: string,
              public imagePath: string,
              public sizeChart: SizeChart[]) {
  }
}
