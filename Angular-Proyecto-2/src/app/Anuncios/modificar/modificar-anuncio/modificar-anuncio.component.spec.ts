import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarAnuncioComponent } from './modificar-anuncio.component';

describe('ModificarAnuncioComponent', () => {
  let component: ModificarAnuncioComponent;
  let fixture: ComponentFixture<ModificarAnuncioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModificarAnuncioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModificarAnuncioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
