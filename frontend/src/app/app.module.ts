import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ConvocatoriaComponent } from './components/convocatoria/convocatoria.component';
import { ConvocatoriaDetalleComponent } from './components/convocatoria-detalle/convocatoria-detalle.component';
import { ConvocatoriaCrearComponent } from './components/convocatoria-crear/convocatoria-crear.component';
import { ConvocatoriaActualizarComponent } from './components/convocatoria-actualizar/convocatoria-actualizar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';

@NgModule({
  declarations: [
    AppComponent,
    ConvocatoriaComponent,
    ConvocatoriaDetalleComponent,
    ConvocatoriaCrearComponent,
    ConvocatoriaActualizarComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatSlideToggleModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
