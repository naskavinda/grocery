import {Component, OnInit} from '@angular/core';
import {ItemService} from '../services/item.service';
import {Item} from '../model/Item';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items: Item[];
  showingItemList: Item[];
  start = 0;
  end = 6;

  constructor(private itemService: ItemService) {
  }

  ngOnInit(): void {
    this.clickMe();
  }

  private clickMe() {
    this.itemService.getItems().subscribe(x => {
      this.items = x;
      this.showingItemList = this.items.slice(this.start, this.end);
    });
  }

  public changeShowList(count: number): void {
    if (this.showPrevious(count) && this.showNext(count)) {
      this.start += count;
      this.end += count;
    }
    this.showingItemList = this.items.slice(this.start, this.end);
  }

  public showNext(count: number): boolean {
    if (this.items) {
      return (this.end + count) <= this.items.length;
    }
    return false;
  }

  public showPrevious(count: number): boolean {
    return (this.start + count) >= 0;
  }
}
