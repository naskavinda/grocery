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

  constructor(private itemService: ItemService) {
  }

  ngOnInit(): void {
    this.clickMe();
  }

  clickMe() {
    this.itemService.getItems().subscribe(x => this.items = x);
  }
}
