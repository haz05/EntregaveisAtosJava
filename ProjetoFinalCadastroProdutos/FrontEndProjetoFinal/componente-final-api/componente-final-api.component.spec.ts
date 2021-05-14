import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteFinalAPIComponent } from './componente-final-api.component';

describe('ComponenteFinalAPIComponent', () => {
  let component: ComponenteFinalAPIComponent;
  let fixture: ComponentFixture<ComponenteFinalAPIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteFinalAPIComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteFinalAPIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
