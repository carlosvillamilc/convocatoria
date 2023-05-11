import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Convocatoria } from '../models/convocatoria';

@Injectable({
  providedIn: 'root'
})
export class ConvocatoriaService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  public listaConvocatoria(): Observable<Convocatoria[]>{
    return this.http.get<Convocatoria[]>(`${this.baseUrl}/lista`);
  }

  public convocatoriaById(idConvocatoria: number): Observable<Convocatoria>{
    return this.http.get<Convocatoria>(`${this.baseUrl}/Id/${idConvocatoria}`);
  }

  public crearConvocatoria(convocatoria: Convocatoria): Observable<any>{
    return this.http.post(`${this.baseUrl}/crear`, convocatoria);
  }

  public actualizarConvocatoria(id: number, convocatoria: Convocatoria): Observable<any>{
      return this.http.put<any>(`${this.baseUrl}/actualizar/${id}`, convocatoria);
  }

  public borrarConvocatoria(idConvocatoria: number): Observable<any>{
    return this.http.delete<any>(`${this.baseUrl}/borrar/${idConvocatoria}`);
  }

}
