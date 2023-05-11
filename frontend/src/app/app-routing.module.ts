import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConvocatoriaComponent } from './components/convocatoria/convocatoria.component';
import { ConvocatoriaDetalleComponent } from './components/convocatoria-detalle/convocatoria-detalle.component';
import { ConvocatoriaCrearComponent } from './components/convocatoria-crear/convocatoria-crear.component';
import { ConvocatoriaActualizarComponent } from './components/convocatoria-actualizar/convocatoria-actualizar.component';


const routes: Routes = [
  {path: '', component: ConvocatoriaComponent},
  {path: 'detalleConvocatoria/:id', component: ConvocatoriaDetalleComponent},
  {path: 'nuevaConvocatoria', component: ConvocatoriaCrearComponent},
  {path: 'editarConvocatoria/:id', component: ConvocatoriaActualizarComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
