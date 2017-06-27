import { Comentario } from './comentario.model';

export class Articulo {
    id:string;
    nombre:string;
    descripcion:string;
    autor:string;
    comentarios: Comentario[];
}
