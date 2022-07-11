/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "MostraTodosLivros", urlPatterns = {"/MostraTodosLivros"})
public class MostraTodosLivros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Livro> livros = repositorio.RepositorioLivro.lerTudo();
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Livros Cadastrados</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Livros Cadastrados</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>id</th><th>Nome</th><th>Autor</th><th>Edicao</th><th>Editora</th><th>Operações</th></tr>");
            
            for(Livro l: livros){
                
                out.println("<tr><td>"+l.getId()+"</td><td>"+l.getNome()+"</td>"
                    + "<td>"+l.getAutor()+"</td><td>"+l.getEdicao()+"</td>"+"<td>"+l.getEditora()+"</td>"
                            + "<td><a href='MostraLivros?id="+l.getId()+"'>Visualizar</a>"
                                    + "<a href='MostraAlteraLivro?id="+l.getId()+"'> Modificar</a>"
                                    + "<a href='DeletaLivros?id="+l.getId()+"'> Deletar</a></td></tr>");
            }
            
            out.println("<a href=\"index.html\">Home Page</a>");
            
            out.println("</table>");
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
