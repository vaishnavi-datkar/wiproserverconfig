import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EX5Home } from './ex5-home';

describe('EX5Home', () => {
  let component: EX5Home;
  let fixture: ComponentFixture<EX5Home>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EX5Home]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EX5Home);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
