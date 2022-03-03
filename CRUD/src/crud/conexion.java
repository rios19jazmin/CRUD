

package crud;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

        

public class conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    

public  conexion(){
    try{
        Mongo mongo = new Mongo("localhost",27017);
        BaseDatos = mongo.getDB("exercise501");
        coleccion = BaseDatos.getCollection("exercise501");
        System.out.println("Conexion establecida");
        
        
    }
 catch(UnknownHostException ex){
     Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null,ex);
 }
}

public boolean insertar(String accion){
    document.put("accion",accion);
    coleccion.insert(document);
    return true;
}

public void mostrar(){
DBCursor cursor = coleccion.find();
while (cursor.hasNext()){
    System.out.println(cursor.next());
}}
public boolean actualizar(String accionVieja, String accionNueva){
    document.put("accion",accionVieja);
    BasicDBObject documentNuevo = new BasicDBObject();
    documentNuevo.put("accion", accionNueva);
    coleccion.findAndModify(document, documentNuevo);
    return true;
}
public boolean eliminar(String accion){
    document.put("accion",accion);
    coleccion.remove(document);
    return true;
}
}