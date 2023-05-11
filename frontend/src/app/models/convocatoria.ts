export enum Perfil {
  EMPRENDEDOR, EMPRESARIO, PROVEEDOR, OTROS
}

export class Convocatoria {
    //? No es obligatorio
    id : number;
    nombre: string;
    fechaPublicacion: string;
    descripcion: String;
    estado: boolean;
    perfil: string;

    constructor(nombre: string,fechaPublicacion:string,descripcion:String,estado:boolean,perfil:string){
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.perfil = perfil;
    }

}
