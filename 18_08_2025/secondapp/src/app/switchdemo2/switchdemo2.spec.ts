import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Switchdemo2 } from './switchdemo2';

describe('Switchdemo2', () => {
  let component: Switchdemo2;
  let fixture: ComponentFixture<Switchdemo2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Switchdemo2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Switchdemo2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
