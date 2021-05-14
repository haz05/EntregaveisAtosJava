import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteAlbumComponent } from './componente-album.component';

describe('ComponenteAlbumComponent', () => {
  let component: ComponenteAlbumComponent;
  let fixture: ComponentFixture<ComponenteAlbumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteAlbumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteAlbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
