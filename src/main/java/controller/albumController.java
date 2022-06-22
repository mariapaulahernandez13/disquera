package controller;

import javax.servlet.http.HttpServlet;

import model.album.albumDao;
import model.album.albumVo;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class albumController extends HttpServlet{
    

    albumVo vo = new albumVo();
    albumDao dao = new albumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Estás en el DoGet");
        String a = req.getParameter("accion");

        switch(a){
            case "registrar":
                registrar(req,resp);
            break;
            case "visualizar":
                visualizar(req,resp);
            break;
            case "eliminar":
                eliminar(req,resp);
            break;
            case "estado":
                estado(req,resp);
            break;
            case "editar":
                editar(req,resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a = req.getParameter("accion");

        switch(a){
            case "Registrar":
                add(req,resp);
            break;
            case "Editar":
                edit(req,resp);
            break;
        }
    }

    //----------------------------------------------//
    //Visualizar
    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<albumVo> albumesList = dao.listar();
            req.setAttribute("albumesList", albumesList);
            req.getRequestDispatcher("views/album/list.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/album/add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){//Verificar que el id no esté nulo
            vo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        try {
            dao.eliminar(vo.getIdAlbum());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            vo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        if(req.getParameter("estadoAlbum")!=null){
            vo.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));
        }
        try {
            dao.estado(vo.isEstadoAlbum(), vo.getIdAlbum());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            vo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        try {
            List<albumVo> albumesList = dao.Listaralbum(vo.getIdAlbum());
            req.setAttribute("albumesList", albumesList);
            req.getRequestDispatcher("views/album/edit.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreAlbum")!=null){
            vo.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            vo.setAnioPublicacion(Integer.parseInt(req.getParameter("anioPublicacion")));
        }
        if(req.getParameter("estadoAlbum")!=null){
            vo.setEstadoAlbum(true);
        }
        else{
            vo.setEstadoAlbum(false);
        }
        try {
            dao.registrar(vo);
            System.out.println("Registro insertado correctamente");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    //-------------------------------------------------------------------------------------------//
    private void  edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreAlbum")!=null){
            vo.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            vo.setAnioPublicacion(Integer.parseInt(req.getParameter("anioPublicacion")));
        }
        try {
            dao.actualizar(vo);
            System.out.println("Editó el registro del álbum");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro " + e.getMessage().toString());
        }
    }

}
