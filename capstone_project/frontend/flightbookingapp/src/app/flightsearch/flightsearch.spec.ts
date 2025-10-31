import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Flightsearch } from './flightsearch';

describe('Flightsearch', () => {
  let component: Flightsearch;
  let fixture: ComponentFixture<Flightsearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Flightsearch]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Flightsearch);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
