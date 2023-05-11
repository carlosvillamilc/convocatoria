# convocatoria
Producto para gestión de convocatorias.

Las tecnologias usadas para la solución:
* Frontend : Angular 
* Backend : SpringBoot
* DB : MySQL
* Docker

Para la instalación y correr el ambiente en local se deben seguir los siguientes pasos:
1. Clonar el repositorio con el comando `git clone git@github.com:carlosvillamilc/convocatorias.git`
2. En la carpeta se encuentran 2 directorios, Frontend y Backend. Para correr el proyecto de Frontend, ubicarse en el directorio Frontend con el comando `cd Frontend` y ejecutar el comando `npm install`. (Tener previamente instalado el manejador de paquetes npm).
3. Una vez finalice la instalación, ejecute el comando `ng serve` el cual dejara disponible el frontend en la url http://localhost:4200/.
4. Para el correr el proyecto backend, se puede apoyar del IDE IntelliJ y ejecutar el proyecto o desde la consola ubicandose en el directorio Backend con `cd Frontend` y ejecutar el comando `gradlew bootRun`. Importante tener en cuenta que este backend se levanta por defecto en el puerto 8080, por lo tanto no puede haber otro recurso usando este puerto.
5. Para levantar la base de datos, se usa Docker compose. En la raiz del directorio existe un archivo `docker-compose.yml` que simplemente lo que hace es levantar un contener con una BD MySQL. Importante tener instalado previamente Docker y Docker compose en el ambiente local.
6. Una vez realizado los pasos anteriores se pueden empezar a utilizar la aplicación.

Funcionalidades:
* La aplicacion consta de las siguiente funcionalidades:
  * Creacion de convocatorias: A traves de un funcionario sencillo se pueden crear convocatorias las cuales se van a poder visualizar en la pantalla principal. Se puede acceder a traves del boton ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/f3f8d9c3-e26e-4b5c-b459-0d1b58bb8eed) de la pantalla principal
     ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/a401c587-8bc7-4692-be68-9de493692fbb)
  * Listar las convocatorias: En la pantalla principal se encuentran listadas todas las convocatorias registradas previamente en la BD.
    ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/3529ab0a-b0fa-4a34-96ea-98144ccc5b65)
  * Ver detalle de las convocatorias: Desde el boton ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/ee65a535-cfbd-45cc-b56a-b5527363c99e)
de la pantalla principal se puede visualizar el detalle de la convocatoria
![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/cebd95fd-2dc0-4b3f-b17b-6f15c0d449e3)
  * Editar las convocatorias: Desde el boton ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/b950aeb2-222e-44e5-b7fa-31d4f929e89d)
 de la pantalla principal se puede editar la convocatoria seleccionada y actualizar sus parametros
    ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/9892ac3f-d3de-4575-a559-29215d8a70da)
  * Eliminar las convocatorias: Desde el boton ![image](https://github.com/carlosvillamilc/convocatorias/assets/70450979/75223482-8f88-433d-8367-abaa45bee198)
se podra eliminar la convocatoria seleccionada
