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
@WebServlet(name = "CadastroLivro", urlPatterns = {"/CadastroLivro"})
public class CadastroLivro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String nome = request.getParameter("nome");
        String autor = request.getParameter("autor");
        String edicao = request.getParameter("edicao");
        String editora = request.getParameter("editora");
        
        Livro l = new Livro (nome, autor, edicao, editora);
        
        RepositorioLivro.inserir(l);  
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroLivro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O livro " + l.getNome()+ " foi cadastrado!</h1>");
            out.println("<a href=\"cadastrolivro.html\">Cadastrar outro livro</a><br>");
            out.println("<a href=\"MostraTodosLivros\">Ver cadastros</a><br>");
            out.println("<a href=\"index.html\">Home Page</a><br>");
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
