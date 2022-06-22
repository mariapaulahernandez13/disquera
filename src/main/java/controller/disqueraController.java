package controller;

import javax.servlet.http.HttpServlet;

import model.disquera.disqueraDao;
import model.disquera.disqueraVo;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class disqueraController extends HttpServlet{

    disqueraVo vo = new disqueraVo();
    disqueraDao dao = new disqueraDao();

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
            List<disqueraVo> disquerasList = dao.listar();
            req.setAttribute("disquerasList", disquerasList);
            req.getRequestDispatcher("views/disquera/list.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/disquera/add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idDisquera")!=null){//Verificar que el id no esté nulo
            vo.setIdDisquera(Integer.parseInt(req.getParameter("idDisquera")));//Cambiar de string a int
        }
        try {
            dao.eliminar(vo.getIdDisquera());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idDisquera")!=null){
            vo.setIdDisquera(Integer.parseInt(req.getParameter("idDisquera")));
        }
        if(req.getParameter("estadoDisquera")!=null){
            vo.setEstadoDisquera(Boolean.parseBoolean(req.getParameter("estadoDisquera")));
        }
        try {
            dao.estado(vo.isEstadoDisquera(), vo.getIdDisquera());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idDisquera")!=null){
            vo.setIdDisquera(Integer.parseInt(req.getParameter("idDisquera")));//Cambiar de string a int
        }
        try {
            List<disqueraVo> disquerasList = dao.Listardisquera(vo.getIdDisquera());
            req.setAttribute("disquerasList", disquerasList);
            req.getRequestDispatcher("views/disquera/edit.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nitDisquera")!=null){
            vo.setNitDisquera(req.getParameter("nitDisquera"));
        }
        if(req.getParameter("nombreDisquera")!=null){
            vo.setNombreDisquera(req.getParameter("nombreDisquera"));
        }
        if(req.getParameter("telefonoDisquera")!=null){
            vo.setTelefonoDisquera(req.getParameter("telefonoDisquera"));
        }
        if(req.getParameter("direccionDisquera")!=null){
            vo.setDireccionDisquera(req.getParameter("direccionDisquera"));
        }
        if(req.getParameter("estadoDisquera")!=null){
            vo.setEstadoDisquera(true);
        }
        else{
            vo.setEstadoDisquera(false);
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
        if(req.getParameter("nitDisquera")!=null){
            vo.setNitDisquera(req.getParameter("nitDisquera"));
        }
        if(req.getParameter("nombreDisquera")!=null){
            vo.setNombreDisquera(req.getParameter("nombreDisquera"));
        }
        if(req.getParameter("telefonoDisquera")!=null){
            vo.setTelefonoDisquera(req.getParameter("telefonoDisquera"));
        }
        if(req.getParameter("direccionDisquera")!=null){
            vo.setDireccionDisquera(req.getParameter("direccionDisquera"));
        }
        try {
            dao.actualizar(vo);
            System.out.println("Editó el registro de la disquera");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro " + e.getMessage().toString());
        }
    }

}
