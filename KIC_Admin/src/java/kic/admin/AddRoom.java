/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kic.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mahlet
 */
public class AddRoom extends HttpServlet {

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
        //response.sendRedirect("AddRoom.html");

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
                    + "            <form  action=\"add_room.action\"  method=\"get\">\n"
                    + "                <table>\n"
                    + "                    <tr>\n"
                    + "                    <tb>Room ID:</tb> \n"
                    + "                    <tb> <input type=\"text\"  maxlength=\"2\" required name=\"room_id\" ></tb>\n"
                    + "                    </tr>\n"
                    + "                    <br>\n"
                    + "                    <tr>\n"
                    + "                    <tb>Room Capacity</tb>\n"
                    + "                    <tb><input type=\"number\"   value=\"0\" maxlength=\"50\" required name=\"room_capacity\" ></tb>\n"
                    + "                \n"
                    + "                </tr>\n"
                    + "                 <br>   \n"
                    + "                    <tr>\n"
                    + "                    <tb><input type=\"submit\" value=\"Submit\"></tb>\n"
                    + "                    <tb></tb>\n"
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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String roomid = request.getParameter("room_id");
            String roomCapacityString = request.getParameter("room_capacity");
          
            int roomcapacity = Integer.parseInt(roomCapacityString);
            System.out.print("Room ID :" + roomid);
            System.out.print("Room Capacity :" + roomCapacityString);
            doGet(request, response);
            /*response.sendRedirect("AddRoom.html");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddRoom</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddRoom at " + request.getContextPath() + "</h1>");
            out.println("<h4>Room ID  " + roomid + "</h4>");
            out.println("<h4>Room Capacity " + roomcapacity + "</h4>");
            out.println("</body>");
            out.println("</html>");*/
        }
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
