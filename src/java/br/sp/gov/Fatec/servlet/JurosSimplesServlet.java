/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.sp.gov.Fatec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernanda
 */

@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Simples</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cálculo de juros simples</h1>");

            try {
                double vp = Double.parseDouble(request.getParameter("vp"));
                double j = Double.parseDouble(request.getParameter("j"));
                int n = Integer.parseInt(request.getParameter("n"));
                double vf = vp * (1 + (j / 100) * n);
                
                                
                DecimalFormat df = new DecimalFormat("#,###.00");
                String fm = df.format(vp);

                out.println("<div>Valor Presente: R$" + fm + "</div><br>");
                out.println("<div>Juros: " + j + "%</div><br>");
                out.println("<div>Quantidade de meses: " + n + "</div><br>");

                String sub = df.format(vf);

                out.println("<div>Valor total: R$" + sub + "</b></div><br>");

            } catch (Exception ex) {
                out.println("<div>Erro ao ler parâmetros</div>");
            }
            out.println("<a href='index.html'>Voltar</a>");
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
