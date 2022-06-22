package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.artista.artistaDao;
import model.artista.artistaVo;;

public class artistaController extends HttpServlet{
    
    artistaVo vo = new artistaVo();
    artistaDao dao = new artistaDao();

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
            List<artistaVo> artistasList = dao.listar();
            req.setAttribute("artistasList", artistasList);
            req.getRequestDispatcher("views/artista/list.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/artista/add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idArtista")!=null){//Verificar que el id no esté nulo
            vo.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));//Cambiar de string a int
        }
        try {
            dao.eliminar(vo.getIdArtista());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idArtista")!=null){
            vo.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        }
        if(req.getParameter("estadoArtista")!=null){
            vo.setEstadoArtista(Boolean.parseBoolean(req.getParameter("estadoArtista")));
        }
        try {
            dao.estado(vo.isEstadoArtista(), vo.getIdArtista());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idArtista")!=null){
            vo.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));//Cambiar de string a int
        }
        try {
            List<artistaVo> artistasList = dao.Listarartistas(vo.getIdArtista());
            req.setAttribute("artistasList", artistasList);
            req.getRequestDispatcher("views/artista/edit.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("noDocumento")!=null){
            vo.setNoDocumento(req.getParameter("noDocumento"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            vo.setTipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("nombreArtista")!=null){
            vo.setNombreArtista(req.getParameter("nombreArtista"));
        }
        if(req.getParameter("apellidoArtista")!=null){
            vo.setApellidoArtista(req.getParameter("apellidoArtista"));
        }
        if(req.getParameter("nombreArtistico")!=null){
            vo.setNombreArtistico(req.getParameter("nombreArtistico"));
        }
        if(req.getParameter("feNacimArtista")!=null){
            vo.setFeNacimArtista(Integer.parseInt(req.getParameter("feNacimArtista")));
        }
        if(req.getParameter("emailArtista")!=null){
            vo.setEmailArtista(req.getParameter("emailArtista"));
        }
        if(req.getParameter("estadoArtista")!=null){
            vo.setEstadoArtista(true);
        }
        else{
            vo.setEstadoArtista(false);
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

        if(req.getParameter("idArtista")!=null){
            vo.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
        }
        if(req.getParameter("noDocumento")!=null){
            vo.setNoDocumento(req.getParameter("noDocumento"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            vo.setTipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("nombreArtista")!=null){
            vo.setNombreArtista(req.getParameter("nombreArtista"));
        }
        if(req.getParameter("apellidoArtista")!=null){
            vo.setApellidoArtista(req.getParameter("apellidoArtista"));
        }
        if(req.getParameter("nombreArtistico")!=null){
            vo.setNombreArtistico(req.getParameter("nombreArtistico"));
        }
        if(req.getParameter("feNacimArtista")!=null){
            vo.setFeNacimArtista(req.getIntHeader("feNacimArtista"));
        }
        if(req.getParameter("emailArtista")!=null){
            vo.setEmailArtista(req.getParameter("emailArtista"));
        }
        if(req.getParameter("estadoArtista")!=null){
            vo.setEstadoArtista(true);
        }
        else{
            vo.setEstadoArtista(false);
        }
        try {
            dao.actualizar(vo);
            System.out.println("Editó el registro del artista");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro " + e.getMessage().toString());
        }
    }
    
}
