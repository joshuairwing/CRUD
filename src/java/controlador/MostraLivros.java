package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Livro;
import repositorio.RepositorioLivro;

/**
 *
 * @author Irwin
 */
@WebServlet(name = "MostraLivros", urlPatterns = {"/MostraLivros"})
public class MostraLivros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            Livro l = RepositorioLivro.ler(id);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostraLivros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dados do livro " + l.getNome() + ":</h1>");
            out.print("Nome: " +l.getNome()+ "<br>");
            out.print("Autor: " +l.getAutor()+ "<br>");
            out.print("Edição: " +l.getEdicao() +"<br>");
            out.print("Editora: " +l.getEditora() +"<br>");
            out.print("<a href=\"MostraTodosLivros\">Voltar</a><br>");
            out.print("<a href=\"index.html\">Home Page</a><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
