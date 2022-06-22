package model.disquera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;

public class disqueraDao {
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql = null; //variable para guardar sentencias
    int filas; //cantidad de filas que devuelve una sentencia

    //---------------------------------------------------------------//
    //Registrar
    public int registrar(disqueraVo disquera) throws SQLException{
        sql = "INSERT INTO disquera(nitDisquera, nombreDisquera, telefonoDisquera, direccionDisquera, estadoDisquera) values(?, ?, ?, ?, ?)"; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1, disquera.getNitDisquera());
            ps.setString(2, disquera.getNombreDisquera());
            ps.setString(3, disquera.getTelefonoDisquera());
            ps.setString(4, disquera.getDireccionDisquera());
            ps.setBoolean(5, disquera.isEstadoDisquera());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se registró la disquera correctamente");
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
    public List<disqueraVo> listar() throws SQLException{
        List<disqueraVo> disquera = new ArrayList<>();
        sql = "SELECT * FROM disquera"; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                disqueraVo filas = new disqueraVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdDisquera(rs.getInt("idDisquera")); //Peticion de id                
                filas.setNitDisquera(rs.getString("nitDisquera")); //Peticion de nit
                filas.setNombreDisquera(rs.getString("nombreDisquera")); //Peticion de nombre
                filas.setTelefonoDisquera(rs.getString("telefonoDisquera")); //Peticion del telefono
                filas.setDireccionDisquera(rs.getString("direccionDisquera")); //Peticion de la direccion
                filas.setEstadoDisquera(rs.getBoolean("estadoDisquera")); //Peticion de estado
                disquera.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("Consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return disquera; //Retorna array con los datos de la tabla
    }

    //----------------------------------------------------------------//
    //Eliminar
    public void eliminar(int idDisquera) throws SQLException{
        sql = "DELETE FROM disquera WHERE idDisquera = " + idDisquera; //Variable para el sql
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
    public void estado(Boolean estadoDisquera, int idDisquera) throws SQLException{
        sql = "UPDATE disquera SET estadoDisquera = " + estadoDisquera + " WHERE idDisquera = " + idDisquera; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se cambio el estado a " + estadoDisquera + " correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString()); //Error
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //---------------------------------------------------------------//
    //Editar
    public List<disqueraVo> Listardisquera(int idDisquera) throws SQLException{
        List<disqueraVo> disquera = new ArrayList<>();
        sql="SELECT * FROM disquera WHERE idDisquera = " + idDisquera; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                disqueraVo filas = new disqueraVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdDisquera(rs.getInt("idDisquera")); //Peticion de id                
                filas.setNitDisquera(rs.getString("nitDisquera")); //Peticion de nit
                filas.setNombreDisquera(rs.getString("nombreDisquera")); //Peticion de nombre
                filas.setTelefonoDisquera(rs.getString("telefonoDisquera")); //Peticion del telefono
                filas.setDireccionDisquera(rs.getString("direccionDisquera")); //Peticion de la direccion
                filas.setEstadoDisquera(rs.getBoolean("estadoDisquera")); //Peticion de estado
                disquera.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("consulta exitosa a la disquera especifica");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return disquera; //Retorna array con los datos de la tabla
    }

    //-------------------------------------------------------------------------//
    //actulizar
    public int actualizar(disqueraVo disquera) throws SQLException{
        sql="UPDATE disquera SET nitDisquera = ?, nombreDisquera = ?, telefonoDisquera = ?, direccionDisquera = ?, estadoDisquera = ? WHERE idDisquera = ?"; //Variable para el sql

        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            //Escribir en el getter cada valor para actualizar 
            ps.setString(1, disquera.getNitDisquera());
            ps.setString(2, disquera.getNombreDisquera());
            ps.setString(3, disquera.getTelefonoDisquera());
            ps.setString(4, disquera.getDireccionDisquera());
            ps.setBoolean(5, disquera.isEstadoDisquera());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se edito la disquera correctamente");
            
        }catch(Exception e){
            System.out.println("Error al editar " + e.getMessage().toString());
        }

        finally{
            con.close(); //Cerrando conexión
        }
        return filas; //Retornar numero de filas
    }

}
