/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kic.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mahlet
 */
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>KIC Admin</title>\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/styles.css\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <div class=\"header\">\n"
                    + "            <h1>KIC Admin</h1>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"row\">\n"
                    + "           \n"
                    + "            <form  action=\"login.action\"  method=\"post\">\n"
                    + "                <table>\n"
                    + "                    <tr>\n"
                    + "                    <td>User Name:</td> \n"
                    + "                    <td> <input type=\"text\"  required name=\"userName\" ></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                    <td>Secret</td>\n"
                    + "                    <td><input type=\"password\"    required name=\"password\" ></td>\n"
                    + "                \n"
                    + "                </tr>\n"
                    + "                    <tr>\n"
                    + "                    <td><input type=\"submit\" value=\"Submit\"></td>\n"
                    + "                    </tr>\n"
                    + "\n"
                    + "                </table>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"footer\">\n"
                    + "            <p>KIC Admin has been developed with Web Application Development Course</p>\n"
                    + "        </div>\n"
                    + "\n"
                    + "    </body>\n"
                    + "</html>");

        }

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
        //try (PrintWriter out = response.getWriter()) {
        String userName = request.getParameter("userName");
        String Secret = request.getParameter("password");
        if ((userName).equalsIgnoreCase("mahlet") ||  (userName).equalsIgnoreCase("thisme") &&  "password".equals(Secret)) {
            HttpSession session = request.getSession();
            ServletContext appliction = this.getServletContext();
            ArrayList<String> users = (ArrayList<String>) appliction.getAttribute("userList");
            users.add(userName);
            session.setAttribute("UserName", userName);
            response.sendRedirect("dashboard.action");
            //response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            // response.setHeader("Location", "dashboard.action");
            //request.getRequestDispatcher("dashboard.action").forward(request, response);
        } else {

            response.sendRedirect("login.action");
        }

        //}
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("creation of userlist");
        ArrayList<String> users = new ArrayList<>(10);
        this.getServletContext().setAttribute("userList", users);

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
