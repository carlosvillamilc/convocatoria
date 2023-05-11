import { Component, OnInit } from '@angular/core';
import { ConvocatoriaService } from '../../services/convocatoria.service';
import { Convocatoria} from '../../models/convocatoria';
import { PERFIL, PERFILLIST } from '../../shared';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import {MatDatepickerModule} from '@angular/material/datepicker';

@Component({
  selector: 'app-convocatoria-crear',
  templateUrl: './convocatoria-crear.component.html',
  styleUrls: ['./convocatoria-crear.component.scss']
})

export class ConvocatoriaCrearComponent implements OnInit {

  nombre = ''
  fechaPublicacion: Date
  descripcion = ''
  estadoConvocatoria: boolean = true

  perfil : 'Emprendedor' | 'Empresario' | 'Proveedor' | 'Otros';

  perfilList: string[] = ['Emprendedor', 'Empresario', 'Proveedor', 'Otros'];

  minDate: Date;

  constructor(private convocatoriaService: ConvocatoriaService, private router: Router) {
    this.minDate = new Date();
   }

  ngOnInit(): void {
  }

  crearConvocatoria(): void {
    // calling the date_TO_String function
    let date_string = this.date_TO_String(this.fechaPublicacion);
    console.log("The date string is " + date_string);

    const convocatoria = new Convocatoria(this.nombre,
      date_string,
      this.descripcion,
      this.estadoConvocatoria,
      this.perfil.toUpperCase()
      );
    this.convocatoriaService.crearConvocatoria(convocatoria).subscribe(
    res =>{
      Swal.fire({
        title: 'Exito!',
        text: 'Se creo la convocatoria correctamente',
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
