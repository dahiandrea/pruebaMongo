import { Component, OnInit } from '@angular/core';
import { NameListService } from '../shared/name-list/name-list.service';
import { Articulo } from './articulo.model';
import { Usuario } from './usuario.model';
import { Comentario } from './comentario.model';
/**
 * This class represents the lazy loaded HomeComponent.
 */
@Component({
  moduleId: module.id,
  selector: 'sd-home',
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.css'],
})
export class HomeComponent implements OnInit {

  nuevoComentario: Comentario = new Comentario;
  errorMessage: string;
  usuarios: Usuario[] = [];
  articulos: Articulo[] = [];
  contenido: boolean = true;
  articulo: Articulo;
  usuario: Usuario;
  tipoPositivo: boolean;
  tipoNegativo: boolean;


  /**
   * Creates an instance of the HomeComponent with the injected
   * NameListService.
   *
   * @param {NameListService} nameListService - The injected NameListService.
   */
  constructor(public nameListService: NameListService) {}

  /**
   * Get the names OnInit
   */
  ngOnInit() {
    this.getUsuarios();
    this.getArticulos();
  }

  /**
   * Handle the nameListService observable
   */
  getUsuarios() {
    this.nameListService.get()
      .subscribe(
        usuarios => this.usuarios = usuarios,
        error => this.errorMessage = <any>error
      );
  }


  getArticulos() {
    this.nameListService.getArticulos().subscribe(
      articulos => this.articulos = articulos,
      error => this.errorMessage = <any>error
    );
  }

  verContenido(articulo:Articulo) {
   this.contenido = false;
   this.articulo = articulo;
  }


  /**
   * Pushes a new name onto the names array
   * @return {boolean} false to prevent default form submit behavior to refresh the page.
   */
  addComentario(): boolean {
    this.nuevoComentario.fecha =  new Date().toISOString().split('T')[0];
   this.articulo.comentarios.push(this.nuevoComentario);
   this.nameListService.addComentario(this.articulo).subscribe(
      articulo => this.articulo = articulo,
      error => this.errorMessage = <any>error
    );
    return true;
  }
}
