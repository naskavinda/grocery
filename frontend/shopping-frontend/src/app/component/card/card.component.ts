import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input() description: string;
  @Input() title: string;
  @Input() imagePath: string;
  @Input() orderBtn = 'Order Now!';
  @Input() detailsBtn = 'See More Details';

  isFront = true;

  constructor() {}

  ngOnInit(): void {
  }

}
