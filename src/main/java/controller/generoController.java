package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.genero.generoDao;
import model.genero.generoVo;

public class generoController extends HttpServlet{
    
    generoVo vo = new generoVo();
    generoDao dao = new generoDao();

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
            List<generoVo> generosList = dao.listar();
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/genero/list.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/genero/add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){//Verificar que el id no esté nulo
            vo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        try {
            dao.eliminar(vo.getIdGenero());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            vo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("estadoGenero")!=null){
            vo.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }
        try {
            dao.estado(vo.isEstadoGenero(), vo.getIdGenero());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            vo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        try {
            List<generoVo> generosList = dao.Listargenero(vo.getIdGenero());
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/genero/edit.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
            
        if(req.getParameter("nombreGenero")!=null){
            vo.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            vo.setEstadoGenero(true);
        }
        else{
            vo.setEstadoGenero(false);
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
        if(req.getParameter("nombreGenero")!=null){
            vo.setNombreGenero(req.getParameter("nombreGenero"));
        }
        try {
            dao.actualizar(vo);
            System.out.println("Editó el registro de genero");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro " + e.getMessage().toString());
        }
    }
    
}