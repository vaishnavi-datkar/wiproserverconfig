import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Listcomp } from './listcomp';

describe('Listcomp', () => {
  let component: Listcomp;
  let fixture: ComponentFixture<Listcomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Listcomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Listcomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
