import { Component, OnInit } from '@angular/core';
import { Convocatoria, Perfil } from '../../models/convocatoria';
import { ConvocatoriaService } from '../../services/convocatoria.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-convocatoria',
  templateUrl: './convocatoria.component.html',
  styleUrls: ['./convocatoria.component.scss']
})
export class ConvocatoriaComponent implements OnInit {

  convocatorias: Convocatoria[] = [];

  constructor(private convocatoriaService: ConvocatoriaService) { }

  ngOnInit(): void {
    this.listarConvocatorias();
  }

  listarConvocatorias(): void {
    this.convocatoriaService.listaConvocatoria().subscribe(res => {
      this.convocatorias = res;
      console.log(this.convocatorias);
    },
      err => {
        console.log(err);
      }
    );
  }

  eliminarConvocatoria(idConvocatoria: number){
    this.convocatoriaService.borrarConvocatoria(idConvocatoria).subscribe(
      res =>{
        Swal.fire({
          title: 'Eliminada!',
          text: 'Se borro la convocatoria correctamente',
          icon: 'success',
          confirmButtonText: 'ok'
        });
        this.listarConvocatorias();
      },
      err =>{
        Swal.fire({
          title: 'Error',
          text: `Error: ${err.error.mensaje}`,
          icon: 'error',
          confirmButtonText: 'ok'
        });
      }
    )
  }

}
