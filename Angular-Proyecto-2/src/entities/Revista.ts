
export interface Revista {


    numeroRevista: string,
    estadoSuscripcion: boolean;
    estadoComentarios: boolean;
    estadoMeGustas: boolean;
    descripcion: string,
    archivoRevista: string,
    nombreAutor: string,
    tags: string,
    tagsString: any;
    tagsArreglo: string[],
    costoSuscripcion: number,
    meGustas: number,
    comentario: string,
    usuarioQueComento: string,
    usuarioQueSuscribio: string,
    fechaProceso: Date,
    usuarioSuscrito: boolean,
    usuarioYaMeGusta: boolean,
    comentarios: string,
    occurrences: number,
    categoria: string
}