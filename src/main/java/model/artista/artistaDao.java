package model.artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;

public class artistaDao {

    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //Objeto de conexión
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto para almacenar consultas
    String sql = null; //Variable para guardar sentencias
    int filas; //Cantidad de filas que devuelve una sentencia

    public int registrar(artistaVo artista) throws SQLException{
        sql = "INSERT INTO artista(noDocumento, tipoDocumento, nombreArtista,  apellidoArtista, nombreArtistico, feNacimArtista, emailArtista, estadoArtista) values(?, ?, ?, ?, ?, ?, ?, ?)"; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1, artista.getNoDocumento());
            ps.setString(2, artista.getTipoDocumento());
            ps.setString(3, artista.getNombreArtista());
            ps.setString(4, artista.getApellidoArtista());
            ps.setString(5, artista.getNombreArtistico());
            ps.setInt(6, artista.getFeNacimArtista());
            ps.setString(7, artista.getEmailArtista());
            ps.setBoolean(8, artista.isEstadoArtista());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se registró el artista correctamente");
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
    public List<artistaVo> listar() throws SQLException{
        List<artistaVo> artista = new ArrayList<>();
        sql = "SELECT * FROM artista"; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                artistaVo filas = new artistaVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdArtista(rs.getInt("idArtista")); //Peticion de id
                filas.setNoDocumento(rs.getString("noDocumento")); //Peticion del número de documento
                filas.setTipoDocumento(rs.getString("tipoDocumento")); //Peticion del tipo de documento
                filas.setNombreArtista(rs.getString("nombreArtista")); //Peticion de nombre
                filas.setApellidoArtista(rs.getString("apellidoArtista")); //Peticion del apeliido
                filas.setNombreArtistico(rs.getString("nombreArtistico")); //Peticion del nombre artistico
                filas.setFeNacimArtista(rs.getInt("feNacimArtista")); //Peticion de la fecha de nacimiento
                filas.setEmailArtista(rs.getString("emailArtista")); //Peticion del email
                filas.setEstadoArtista(rs.getBoolean("estadoArtista")); //Peticion de estado
                artista.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return artista; //Retorna array con los datos de la tabla
    }

    //----------------------------------------------------------------//
    //Eliminar
    public void eliminar(int idArtista) throws SQLException{
        sql = "DELETE FROM artista WHERE idArtista = " + idArtista; //Variable para el sql
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
    public void estado(Boolean estadoArtista, int idArtista) throws SQLException{
        sql = "UPDATE artista SET estadoArtista = " + estadoArtista + " WHERE idArtista = " + idArtista; //Variable para el sql
        try{
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se cambio el estado a " + estadoArtista + " correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString()); //Error
        }

        finally{
            con.close(); //Cerrando conexión
        }
    }

    //---------------------------------------------------------------//
    //Editar
    public List<artistaVo> Listarartistas(int idArtista) throws SQLException{
        List<artistaVo> artista = new ArrayList<>();
        sql="SELECT * FROM artista WHERE idArtista = " + idArtista; //Variable para la BD
        try {
            con = Conexion.conectar(); //Abrir conexión
            ps = con.prepareStatement(sql); //Preparar sentencia
            rs = ps.executeQuery(sql); //Ejecutar sentencia
            while(rs.next()){
                artistaVo filas = new artistaVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdArtista(rs.getInt("idArtista")); //Peticion de id
                filas.setNoDocumento(rs.getString("noDocumento")); //Peticion del número de documento
                filas.setTipoDocumento(rs.getString("tipoDocumento")); //Peticion del tipo de documento
                filas.setNombreArtista(rs.getString("nombreArtista")); //Peticion de nombre
                filas.setApellidoArtista(rs.getString("apellidoArtista")); //Peticion del apeliido
                filas.setNombreArtistico(rs.getString("nombreArtistico")); //Peticion del nombre artistico
                filas.setFeNacimArtista(rs.getInt("feNacimArtista")); //Peticion de la fecha de nacimiento
                filas.setEmailArtista(rs.getString("emailArtista")); //Peticion del email
                filas.setEstadoArtista(rs.getBoolean("estadoArtista")); //Peticion de estado
                artista.add(filas);
            }
            ps.close(); //Cerrar sentencia
            System.out.println("consulta exitosa al artista especifico");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString()); //Error
        }
        finally{
            con.close(); //Cerrando conexión
        }

        return artista; //Retorna array con los datos de la tabla
    }

    //-------------------------------------------------------------------------//
    //actulizar
    public int actualizar(artistaVo artista) throws SQLException{
        sql="UPDATE artista SET nombreArtista = ?, estadoArtista = ? WHERE idArtista = ?"; //Variable para el sql

        try{
            con = Conexion.conectar(); //Abrir conexión
            ps=con.prepareStatement(sql); //Preparar sentencia
            System.out.println(ps);
            //Escribir en el getter cada valor para actualizar
            ps.setString(1, artista.getNoDocumento());
            ps.setString(2, artista.getTipoDocumento());
            ps.setString(3, artista.getNombreArtista());
            ps.setString(4, artista.getApellidoArtista());
            ps.setString(5, artista.getNombreArtistico());
            ps.setInt(6, artista.getFeNacimArtista());
            ps.setString(7, artista.getEmailArtista());
            ps.setBoolean(2, artista.isEstadoArtista());
            ps.setInt(3, artista.getIdArtista());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //Cerrar sentencia
            System.out.println("Se edito el artista correctamente");
            
        }catch(Exception e){
            System.out.println("Error al editar " + e.getMessage().toString());
        }

        finally{
            con.close(); //Cerrando conexión
        }
        return filas; //Retornar numero de filas
    }
    
}
