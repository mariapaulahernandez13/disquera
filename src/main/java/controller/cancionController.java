package controller;

import javax.servlet.http.HttpServlet;

import model.cancion.cancionDao;
import model.cancion.cancionVo;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cancionController extends HttpServlet{

    cancionVo vo = new cancionVo();
    cancionDao dao = new cancionDao();

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
            List<cancionVo> cancionesList = dao.listar();
            req.setAttribute("cancionesList", cancionesList);
            req.getRequestDispatcher("views/cancion/list.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/cancion/add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){//Verificar que el id no esté nulo
            vo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        try {
            dao.eliminar(vo.getIdCancion());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            vo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("estadoCancion")!=null){
            vo.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
        }
        try {
            dao.estado(vo.isEstadoCancion(), vo.getIdCancion());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            vo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        try {
            List<cancionVo> cancionesList = dao.Listarcancion(vo.getIdCancion());
            req.setAttribute("cancionesList", cancionesList);
            req.getRequestDispatcher("views/cancion/edit.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreCancion")!=null){
            vo.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            vo.setFechaGrabacion(Integer.parseInt(req.getParameter("fechaGrabacion")));
        }
        if(req.getParameter("duracionCancion")!=null){
            vo.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            vo.setEstadoCancion(true);
        }
        else{
            vo.setEstadoCancion(false);
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
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreCancion")!=null){
            vo.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            vo.setFechaGrabacion(Integer.parseInt(req.getParameter("fechaGrabacion")));
        }
        if(req.getParameter("duracionCancion")!=null){
            vo.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        try {
            dao.actualizar(vo);
            System.out.println("Editó el registro de la canción");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro " + e.getMessage().toString());
        }
    }

}
