package config;

import java.sql.Connection;
import java.sql.DriverManager; //Permite establecer y gestionar conexiones a las BD

public class Conexion{
    //Declarar atributos para la conexión
    private static final String bbdd = "jdbc:mysql://localhost:3306/disquera";
    private static final String usuario = "Paula";
    private static final String clave = "pau15";
    private static Connection con;

    //Declarar método conexión
    public static Connection conectar(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(bbdd, usuario, clave);
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Error de conexión a la base de datos " + e.getMessage().toString());
        }
        return con;
    }

    public static void main(String[] args) {
        Conexion.conectar();
    }
}
