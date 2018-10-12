# Conexion_Apache-Fuseki_con_Java
Código para conexión de Apache-Fuseki con Java, y algunas consultas para comprobar la conexión correcta.

El presente repositorio cuenta con dos carpetas:
- OWL: Con el modelo ontológico utilizado para el ejemplo del código.
- Conexion_con_Fuseki: El proyecto en Java.

Para el correcto funcionamiento, los requisitos necesarios previos a la ejecución del repositorio son los siguientes:
- Descargar e instalar las librerías correspondientes de Apache Jena dentro del framework.
  
  *La librería Jena se carga al proyecto una vez se haya descargado el código.
- Descargar e instalar el servidor fuseki.
- Lanzar el servidor
  
  *La instrucción para lanzar el servidor desde la terminal es la siguiente:
    java -Xmx1024M -jar fuseki-server.jar --update --loc=Data /myData
  
  *Se recomienda desde linux hacer un demonio para el lanzamiento de éste.
-Subir el archivo .owl correspondiente al modelo ontológico, éste se puede encontrar en la carpeta "OWL".





-->Las descargas correspondientes a Apache Jena y Apache Jena Fuseki pueden ser descargados desde su página oficial:
--- https://jena.apache.org/download/index.cgi
