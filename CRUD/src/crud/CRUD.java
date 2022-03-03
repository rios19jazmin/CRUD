
package crud;


public class CRUD {

    public static void main(String[] args) {
     
        conexion conec = new conexion();
        conec.mostrar();
        conec.insertar("brincar");
        System.out.println("otra vez el mostrar");
        //conec.eliminar("correr");
        conec.mostrar();
    }
    
}
