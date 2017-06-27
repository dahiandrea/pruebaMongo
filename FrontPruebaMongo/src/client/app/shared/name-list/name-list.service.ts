import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Articulo } from '../../home/articulo.model';
import { Usuario } from '../../home/usuario.model';
import { Comentario } from '../../home/comentario.model';
// import 'rxjs/add/operator/do';  // for debugging

/**
 * This class provides the NameList service with methods to read names and add names.
 */
@Injectable()
export class NameListService {

  /**
   * Creates a new NameListService with the injected Http.
   * @param {Http} http - The injected Http.
   * @constructor
   */
  constructor(private http: Http) {}

  /**
   * Returns an Observable for the HTTP GET request for the JSON resource.
   * @return {string[]} The Observable for the HTTP request.
   */
  get(): Observable<Usuario[]> {
    return this.http.get('/pruebaMongo/listarUsuarios')
                    .map((res: Response) => res.json())
    //              .do(data => console.log('server data:', data))  // debug
                    .catch(this.handleError);
  }

  getArticulos(): Observable<Articulo[]> {
    return this.http.get('/pruebaMongo/listarArticulos').
                    map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  addComentario(articulo: Articulo): Observable<Articulo> {
    return this.http.post('/pruebaMongo/crearComentario', articulo).map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  getComentarios(idUsuario: string) : Observable<Articulo[]> {
    return this.http.get('/pruebaMongo/comentariosPorUsuario/' + idUsuario).
                    map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  getPositivos(idUsuario: string): Observable<string> {
    return this.http.get('/pruebaMongo/totalPositivos/' + idUsuario).
                    map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  getNegativos(idUsuario: string): Observable<string> {
    return this.http.get('/pruebaMongo/totalNegativos/' + idUsuario).
                    map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  /**
    * Handle HTTP error
    */
  private handleError (error: any) {
    // In a real world app, we might use a remote logging infrastructure
    // We'd also dig deeper into the error to get a better message
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }
}

