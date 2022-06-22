package model.album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;

public class albumDao {
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql = null; //variable para guardar sentencias
    int filas; //cantidad de filas que devuelve una sentencia

    public int registrar(albumVo album) throws SQLException{
        sql = "INSERT INTO album (nombreAlbum, anioPublicacion, estadoAlbum) VALUES(?, ?, ?)"; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1, album.getNombreAlbum());
            ps.setInt(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.isEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se registró el álbum correctamente");
        }catch(Exception e){
            System.out.println("Error en el registro" + e.getMessage().toString());
        }
        finally{
            con.close(); //Cerrando la conexión
        }
        return filas; //Retornar número de filas
    }

    //---------------------------------------------------------------//
    //Listar
    public List<albumVo> listar() throws SQLException{
        List<albumVo> album = new ArrayList<>();
        sql = "SELECT * FROM album"; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                albumVo filas = new albumVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdAlbum(rs.getInt("idAlbum")); //Peticion de id
                filas.setNombreAlbum(rs.getString("nombreAlbum")); //Peticion de nombre
                filas.setAnioPublicacion(rs.getInt("anioPublicacion")); //Peticion del año de grabación
                filas.setEstadoAlbum(rs.getBoolean("estadoAlbum")); //Peticion de estado
                album.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("Consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return album; //Retorna array con los datos de la tabla
    }

    //----------------------------------------------------------------//
    //Eliminar
    public void eliminar(int idAlbum) throws SQLException{
        sql = "DELETE FROM album WHERE idAlbum = " + idAlbum; //Variable para el sql
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
    public void estado(Boolean estadoAlbum, int idAlbum) throws SQLException{
        sql = "UPDATE album SET estadoAlbum = " + estadoAlbum + " WHERE idAlbum = " + idAlbum; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se cambio el estado a " + estadoAlbum + " correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString()); //Error
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //---------------------------------------------------------------//
    //Editar
    public List<albumVo> Listaralbum(int idAlbum) throws SQLException{
        List<albumVo> album = new ArrayList<>();
        sql="SELECT * FROM album WHERE idAlbum = " + idAlbum; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                albumVo filas = new albumVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdAlbum(rs.getInt("idAlbum")); //Peticion de id
                filas.setNombreAlbum(rs.getString("nombreAlbum")); //Peticion de nombre
                filas.setAnioPublicacion(rs.getInt("anioPublicacion")); //Peticion del año de publicación
                album.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("Consulta exitosa del álbum especifico para editar");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return album; //Retorna array con los datos de la tabla
    }

    //-------------------------------------------------------------------------//
    //actulizar
    public int actualizar(albumVo album) throws SQLException{
        sql="UPDATE album SET nombreAlbum = ?, anioPublicacion = ? WHERE idAlbum = ?"; //Variable para el sql

        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            //Escribir en el getter cada valor para actualizar 
            ps.setString(1, album.getNombreAlbum());
            ps.setInt(2, album.getAnioPublicacion());
            ps.setInt(3, album.getIdAlbum());
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
