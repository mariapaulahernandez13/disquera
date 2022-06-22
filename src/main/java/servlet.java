import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String direccionar = req.getParameter("direccionar");
        System.out.println(direccionar);

        switch(direccionar)
        {

            case "inicio":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            break;

            case "album":
                    req.getRequestDispatcher("views/album/list.jsp").forward(req, resp);
            break;

            case "cancion":
                    req.getRequestDispatcher("views/cancion/list.jsp").forward(req, resp);
            break;

            case "artista":
                    req.getRequestDispatcher("views/artista/list.jsp").forward(req, resp);
            break;

            case "genero":
                    req.getRequestDispatcher("views/genero/list.jsp").forward(req, resp);
            break;

            case "estilo":
                    req.getRequestDispatcher("assets/css/estilo.css").forward(req, resp);
            break;

            case "addGenero":
                    req.getRequestDispatcher("views/genero/add.jsp").forward(req, resp);
            break;

            case "editGenero":
                    req.getRequestDispatcher("views/genero/edit.jsp").forward(req, resp);
            break;

            case "addAlbum":
                    req.getRequestDispatcher("views/album/add.jsp").forward(req, resp);
            break;

            case "editAlbum":
                    req.getRequestDispatcher("views/album/edit.jsp").forward(req, resp);
            break;

            case "addArtista":
                    req.getRequestDispatcher("views/artista/add.jsp").forward(req, resp);
            break;

            case "editArtista":
                    req.getRequestDispatcher("views/artista/edit.jsp").forward(req, resp);
            break;

            case "addCancion":
                    req.getRequestDispatcher("views/cancion/add.jsp").forward(req, resp);
            break;

            case "editCancion":
                    req.getRequestDispatcher("views/cancion/edit.jsp").forward(req, resp);
            break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
