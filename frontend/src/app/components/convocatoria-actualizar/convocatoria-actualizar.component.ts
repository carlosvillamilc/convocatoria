import { Component, OnInit } from '@angular/core';
import { Convocatoria } from '../../models/convocatoria';
import { ConvocatoriaService } from '../../services/convocatoria.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-convocatoria-actualizar',
  templateUrl: './convocatoria-actualizar.component.html',
  styleUrls: ['./convocatoria-actualizar.component.scss']
})
export class ConvocatoriaActualizarComponent implements OnInit {

  convocatoria: Convocatoria;

  nombre = ''
  fechaPublicacion: Date
  descripcion = ''
  estadoConvocatoria: boolean = true

  minDate: Date;

  perfil : 'Emprendedor' | 'Empresario' | 'Proveedor' | 'Otros';

  perfilList: string[] = ['Emprendedor', 'Empresario', 'Proveedor', 'Otros'];

  constructor(private convocatoriaService: ConvocatoriaService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.minDate = new Date();
  }

  ngOnInit(): void {
    //Obtenemos el id de la URL
    const id = this.activatedRoute.snapshot.params.id;
    this.convocatoriaService.convocatoriaById(id).subscribe(
      res =>{
        this.convocatoria = res;
      },
      err =>{
        Swal.fire({
          title: 'Error',
          text: `Error: ${err.error.mensaje}`,
          icon: 'error',
          confirmButtonText: 'ok'
        });
        this.router.navigate(['/']);
      }
    );
  }

  actualizarConvocatoria(): void{
    const id = this.activatedRoute.snapshot.params.id;
    console.log('nombre',this.convocatoria.nombre)
    console.log('fechaPublicacion',this.convocatoria.fechaPublicacion)
    console.log('descripcion',this.convocatoria.descripcion)
    console.log('estado',this.convocatoria.estado)
    console.log('perfil',this.convocatoria.perfil)

    let date_string = this.date_TO_String(new Date(this.convocatoria.fechaPublicacion));
    console.log("The date string is " + date_string);
    console.log('perfil form',this.perfil)
    if(this.perfil == undefined){
      Swal.fire({
        title: 'Error',
        text: `Error: Por favor seleccione un perfil`,
        icon: 'error',
        confirmButtonText: 'ok'
      });
      return
    }
    this.convocatoria.fechaPublicacion = date_string;
    this.convocatoria.perfil = this.perfil.toUpperCase();

    console.log(this.convocatoria)


    this.convocatoriaService.actualizarConvocatoria(id, this.convocatoria).subscribe(
      res =>{
        Swal.fire({
          title: 'Exito!',
          text: 'La convocatoria se actualizo',
          icon: 'success',
          confirmButtonText: 'ok'
        });
        this.router.navigate(['/']);
      },
      err =>{
        Swal.fire({
          title: 'Error',
          text: `Error: ${err.error.mensaje}`,
          icon: 'error',
          confirmButtonText: 'ok'
        });
        this.router.navigate(['/']);
      }
    );
  }
  date_TO_String(date_Object: Date): string {
    // get the year, month, date, hours, and minutes seprately and append to the string.
    let day =(date_Object.getDate() < 10 ? '0' : '') + date_Object.getDate();
    let month = ((date_Object.getMonth() + 1) < 10 ? '0' : '') + (date_Object.getMonth() + 1);
    let hours = (date_Object.getHours() < 10 ? '0' : '') + date_Object.getHours();
    let minutes = (date_Object.getMinutes() < 10 ? '0' : '') + date_Object.getMinutes();
    let seconds = (date_Object.getSeconds() < 10 ? '0' : '') + date_Object.getSeconds();
    let date_String: string = `${day}/${month}/${date_Object.getFullYear()} ${hours}:${minutes}:${seconds}`

    return date_String;
  }

}
