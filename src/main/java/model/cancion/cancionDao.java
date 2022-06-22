package model.cancion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;

public class cancionDao {
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql = null; //variable para guardar sentencias
    int filas; //cantidad de filas que devuelve una sentencia

    //---------------------------------------------------------------//
    //Registrar
    public int registrar(cancionVo cancion) throws SQLException{
        sql = "INSERT INTO cancion(nombreCancion, fechaGrabacion, duracionCancion, estadoCancion) values(?, ?, ?, ?)"; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1, cancion.getNombreCancion());
            ps.setInt(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.isEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se registró la canción correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro " + e.getMessage().toString());
        }
        finally{
            con.close(); //Cerrando conexión
        }
        return filas; //Retornar numero de filas
    }

    //---------------------------------------------------------------//
    //Listar
    public List<cancionVo> listar() throws SQLException{
        List<cancionVo> cancion = new ArrayList<>();
        sql = "SELECT * FROM cancion"; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                cancionVo filas = new cancionVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdCancion(rs.getInt("idCancion")); //Peticion de id
                filas.setNombreCancion(rs.getString("nombreCancion")); //Peticion de nombre
                filas.setFechaGrabacion(rs.getInt("fechaGrabacion")); //Peticion de la fecha de grabación
                filas.setDuracionCancion(rs.getString("duracionCancion")); //Peticion de duración de la canción
                filas.setEstadoCancion(rs.getBoolean("estadoCancion")); //Peticion de estado
                cancion.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("Consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return cancion; //Retorna array con los datos de la tabla
    }

    //----------------------------------------------------------------//
    //Eliminar
    public void eliminar(int idCancion) throws SQLException{
        sql = "DELETE FROM cancion WHERE idCancion = " + idCancion; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se eliminó correctamente");
            
        }catch(Exception e){
            System.out.println("Error en la eliminación "+e.getMessage().toString());//Error
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //----------------------------------------------------------------//
    //Estado
    public void estado(Boolean estadoCancion, int idCancion) throws SQLException{
        sql = "UPDATE cancion SET estadoCancion = " + estadoCancion + " WHERE idCancion = " + idCancion; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se cambio el estado a " + estadoCancion + " correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString()); //Error
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //---------------------------------------------------------------//
    //Editar
    public List<cancionVo> Listarcancion(int idCancion) throws SQLException{
        List<cancionVo> cancion = new ArrayList<>();
        sql="SELECT * FROM cancion WHERE idCancion = " + idCancion; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                cancionVo filas = new cancionVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdCancion(rs.getInt("idCancion")); //Peticion de id
                filas.setNombreCancion(rs.getString("nombreCancion")); //Peticion de nombre
                filas.setFechaGrabacion(rs.getInt("fechaGrabacion")); //Peticion de la fecha de grabación
                filas.setDuracionCancion(rs.getString("duracionCancion")); //Peticion de duración de la canción
                filas.setEstadoCancion(rs.getBoolean("estadoCancion")); //Peticion de estado
                cancion.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("consulta exitosa a la canción especifica");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return cancion; //Retorna array con los datos de la tabla
    }

    //-------------------------------------------------------------------------//
    //actulizar
    public int actualizar(cancionVo cancion) throws SQLException{
        sql="UPDATE cancion SET nombreCancion = ?, fechaGrabacion = ?, duracionCancion = ?, estadoCancion = ? WHERE idCancion = ?"; //Variable para el sql

        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            //Escribir en el getter cada valor para actualizar 
            ps.setString(1, cancion.getNombreCancion());
            ps.setInt(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.isEstadoCancion());
            ps.setInt(5, cancion.getIdCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se edito la canción correctamente");
            
        }catch(Exception e){
            System.out.println("Error al editar " + e.getMessage().toString());
        }

        finally{
            con.close(); //Cerrando conexión
        }
        return filas; //Retornar numero de filas
    }

}
