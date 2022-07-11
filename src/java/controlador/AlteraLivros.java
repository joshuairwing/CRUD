package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Livro;

/**
 *
 * @author Irwin
 */
@WebServlet(name = "AlteraLivros", urlPatterns = {"/AlteraLivros"})
public class AlteraLivros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String autor = request.getParameter("autor");
            String edicao = request.getParameter("edicao");
            String editora = request.getParameter("editora");

            Livro l = new Livro(nome, autor, edicao, editora);

//            l.setId(id);
//
//            repositorio.RepositorioLivro.alterar(l);
            l.setId(id);

            repositorio.RepositorioLivro.alterar(l);

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlteraLivros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastro alterado</h1>");
            out.println("<a href='MostraTodosLivros'>Voltar</a><br>");
            out.println("<a href='index.html'>Home Page</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
