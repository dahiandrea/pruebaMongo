import { Component, OnInit } from '@angular/core';
import { NameListService } from '../shared/name-list/name-list.service';
import { Usuario } from '../home/usuario.model';
import { Comentario } from '../home/comentario.model';
import { Articulo } from '../home/articulo.model';


/**
 * This class represents the lazy loaded AboutComponent.
 */
@Component({
  moduleId: module.id,
  selector: 'sd-about',
  templateUrl: 'about.component.html',
  styleUrls: ['about.component.css']
})
export class AboutComponent implements OnInit {

  usuarios: Usuario[];
  errorMessage: string;
  comentarios : Comentario[];
  articulos: Articulo[];
  contenido: boolean = true;
  usuario : Usuario;

  constructor(public nameListService: NameListService) {}

ngOnInit() {
    this.getUsuarios();
  }

getUsuarios() {
    this.nameListService.get()
      .subscribe(
        usuarios => this.usuarios = usuarios,
        error => this.errorMessage = <any>error
      );
  }

  getComentarios(usuario: Usuario) {
    this.usuario = usuario;
    this.contenido = false;
    this.nameListService.getComentarios(usuario.id).subscribe(
        articulos => this.articulos = articulos,
        error => this.errorMessage = <any>error
      );

    this.nameListService.getPositivos(usuario.id).subscribe(
        positivos => this.usuario.totalPositivos = positivos,
        error => this.errorMessage = <any>error
    );

      this.nameListService.getNegativos(usuario.id).subscribe(
        negativos => this.usuario.totalNegativos = negativos,
        error => this.errorMessage = <any>error
    );
  }

}
