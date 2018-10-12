package conexion_con_fuseki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.RDFNode;

public class Conexion_con_Fuseki {

    //Método para realizar la consulta
    public static void ejecutarConsulta(String URI, String consulta) {
        //Crea la variable "c" con los parametros correspondientes para la consulta
        QueryExecution c = QueryExecutionFactory.sparqlService(URI,
                consulta);
        //Recuper los resultados de la consulta en la variable "results"
        ResultSet resultados = c.execSelect();
        //Cambia el formato de "resultados" a formato salida
        ResultSetFormatter.out(System.out, resultados);

        //Ciclo para leer los distintos datos arrojados por la consulta
        while (resultados.hasNext()) {
            //Obtiene el dato que se esta leyendo y lo guarda en "lecN"
            QuerySolution lecN = resultados.nextSolution();
            //Convierte el dato anterior en un nodo RDF
            RDFNode x = lecN.get("x");
            System.out.println(x);
        }
    }
    
    //Método para leer el archivo XML desde el servidor Fuseki
    //(Para ver estructura del modelo ontológico)
    public static void leerXML(String fuseki) throws IOException {
        //Crea una variable tipo dirección del servidor fuseki
        URL url = new URL(fuseki);
        //Crea la conexión con el servidor Fuseki
        URLConnection conexion = url.openConnection();
        conexion.connect();
        //Lee el archivo XML del servidor y lo guarda en la variable "is"
        InputStream is = conexion.getInputStream();
        //Hace la lectura del fichero XML
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        
        //Código de lectura específica del fichero
        

    }

    public static void main(String[] args) {
        //Se almacena en una variable String el nombre de la clase cuyas 
        //instancias se desea consultar.
        String clase = "CheeseyPizza";
        //Se crea la variable "fuseki" con la dirección de la base del 
        //servidor Fuseki
        String fuseki = "http://localhost:3030/Prueba";
        //Se manda llamar el método de consulta
        ejecutarConsulta(
                //Se establece 1er parámetro
                fuseki,
                //Como 2do parámetro se manda la consulta SPARQL como string
                //La consulta maneja las URIs propias del modelo ontológico,
                //además de Prfijos generales como rdf y rdfs.
                "PREFIX onto: <http://www.co-ode.org/ontologies/pizza/2005/10/18/pizza.owl#> "
                + "PREFIX ins: <http://www.co-ode.org/ontologies/pizza/2005/10/18/pizza.owl#>  "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                + "select ?x where{?x rdf:type onto:" + clase + "}");
    }
}
