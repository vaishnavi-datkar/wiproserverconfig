import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Logincom } from './logincom';

describe('Logincom', () => {
  let component: Logincom;
  let fixture: ComponentFixture<Logincom>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Logincom]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Logincom);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
