import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {


  @Input() description: string;
  @Input() title: string;
  @Input() imagePath: string;
  @Input() orderBtn = 'Order Now!';
  @Input() detailsBtn = 'See More Details';

  isFront = true;

  constructor() { }

  ngOnInit(): void {
  }

}
