import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex5Product } from './ex5-product';

describe('Ex5Product', () => {
  let component: Ex5Product;
  let fixture: ComponentFixture<Ex5Product>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex5Product]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex5Product);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
