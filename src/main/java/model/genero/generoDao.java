package model.genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;

public class generoDao{

    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //Objeto de conexión
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto para almacenar consultas
    String sql = null; //Variable para guardar sentencias
    int filas; //Cantidad de filas que devuelve una sentencia

    //---------------------------------------------------------------//
    //Registrar
    public int registrar(generoVo genero) throws SQLException{
        sql = "INSERT INTO genero(nombreGenero, estadoGenero) values(?, ?)";//Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.isEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se registró el genero correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro " + e.getMessage().toString());
        }
        finally{
            con.close();//Cerrando conexión
        }
        return filas;//Retornar numero de filas
    }

    //---------------------------------------------------------------//
    //Listar
    public List<generoVo> listar() throws SQLException{
        List<generoVo> genero = new ArrayList<>();
        sql = "SELECT * FROM genero"; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                generoVo filas = new generoVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdGenero(rs.getInt("idGenero")); //Peticion de id
                filas.setNombreGenero(rs.getString("nombreGenero")); //Peticion de nombre
                filas.setEstadoGenero(rs.getBoolean("estadoGenero")); //Peticion de estado
                genero.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return genero; //Retorna array con los datos de la tabla
    }

    //----------------------------------------------------------------//
    //Eliminar
    public void eliminar(int idGenero) throws SQLException{
        sql = "DELETE FROM genero WHERE idGenero = " + idGenero; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se elimino correctamente");
            
        }catch(Exception e){
            System.out.println("Error en la eliminación "+e.getMessage().toString());
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //----------------------------------------------------------------//
    //Estado
    public void estado(Boolean estadoGenero, int idGenero) throws SQLException{
        sql = "UPDATE genero SET estadoGenero = " + estadoGenero + " WHERE idGenero = " + idGenero; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se cambio el estado a " + estadoGenero + " correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString()); //Error
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //---------------------------------------------------------------//
    //Editar
    public List<generoVo> Listargenero(int idGenero) throws SQLException{
        List<generoVo> genero = new ArrayList<>();
        sql="SELECT * FROM genero WHERE idGenero = " + idGenero; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                generoVo filas = new generoVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdGenero(rs.getInt("idGenero")); //Peticion de id
                filas.setNombreGenero(rs.getString("nombreGenero")); //Peticion de nombre
                filas.setEstadoGenero(rs.getBoolean("estadoGenero")); //Peticion de estado
                genero.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("consulta exitosa a genero especifico");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return genero; //Retorna array con los datos de la tabla
    }

    //-------------------------------------------------------------------------//
    //actulizar
    public int actualizar(generoVo genero) throws SQLException{
        sql="UPDATE genero SET nombreGenero = ? WHERE idGenero = ?"; //Variable para el sql

        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            //Escribir en el getter cada valor para actualizar 
            ps.setString(1, genero.getNombreGenero());
            ps.setInt(2, genero.getIdGenero());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se edito el genero correctamente");
            
        }catch(Exception e){
            System.out.println("Error al editar " + e.getMessage().toString());
        }

        finally{
            con.close(); //Cerrando conexión
        }
        return filas; //Retornar numero de filas
    }
    
}