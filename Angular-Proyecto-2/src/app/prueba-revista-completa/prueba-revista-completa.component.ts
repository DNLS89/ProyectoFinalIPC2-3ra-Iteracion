import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PerfilAutorService } from '../../services/Servicios Cuenta/perfil-autor-service';
import { Revista } from '../../entities/Revista';
import { Usuario } from '../../entities/Usuario';

@Component({
  selector: 'app-prueba-revista-completa',
  standalone: true,
  imports: [],
  templateUrl: './prueba-revista-completa.component.html',
  styleUrl: './prueba-revista-completa.component.css'
})
export class PruebaRevistaCompletaComponent implements OnInit{

  revista!: Revista;
  numeroRevista!: number;
  autor!: Usuario;
  mostrarPerfilAutor: boolean = false;

  constructor(private perfilAutorService: PerfilAutorService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.numeroRevista = this.route.snapshot.params['numero'];
    console.log(this.numeroRevista);
    //Primero extraer revista y ya con eso se puede tener el nombre del autor en lo de abajo

    this.perfilAutorService
    .extraerPerfilAutor(this.revista.nombreAutor)
    .subscribe({
      next: (usuario: Usuario) => {
        console.log("Todo fue bien, procesando response...");
        this.autor = usuario;
        
      },
    });
  }

  booleanMostrarPerfil(): void {
    if (this.mostrarPerfilAutor == true) {
      this.mostrarPerfilAutor = false;
    } else {
      this.mostrarPerfilAutor = true;
    }
  }

}
