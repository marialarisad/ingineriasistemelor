package ro.ulbs.ingprog.lab3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = {"/CounterServlet"})
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession sesiune = req.getSession();


        Object valGet = sesiune.getAttribute("CounterGetName");
        int contorGet = (valGet != null) ? (Integer) valGet : 0;


        String valInc = req.getParameter("inc");
        String valDec = req.getParameter("dec");

        if (valInc != null && !valInc.trim().isEmpty()) {
            try {
                contorGet += Integer.parseInt(valInc);
            } catch (NumberFormatException e) {

            }
        }

        if (valDec != null && !valDec.trim().isEmpty()) {
            try {
                contorGet -= Integer.parseInt(valDec);
            } catch (NumberFormatException e) {

            }
        }


        sesiune.setAttribute("CounterGetName", contorGet);


        if (contorGet == 0) {
            sesiune.setAttribute("WarningGet", true);
        } else {
            sesiune.removeAttribute("WarningGet");
        }

        afiseazaPagina(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession sesiune = req.getSession();


        Object valPost = sesiune.getAttribute("CounterPostName");
        int contorPost = (valPost != null) ? (Integer) valPost : 0;


        String valInc = req.getParameter("inc");
        String decStr = req.getParameter("dec");

        if (valInc != null && !valInc.trim().isEmpty()) {
            try {
                contorPost += Integer.parseInt(valInc);
            } catch (NumberFormatException e) {

            }
        }

        if (decStr != null && !decStr.trim().isEmpty()) {
            try {
                contorPost -= Integer.parseInt(decStr);
            } catch (NumberFormatException e) {

            }
        }

        sesiune.setAttribute("CounterPostName", contorPost);
        
        if (contorPost == 0) {
            sesiune.setAttribute("WarningPost", true);
        } else {
            sesiune.removeAttribute("WarningPost");
        }

        afiseazaPagina(req, resp);
    }

    private void afiseazaPagina(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        HttpSession s = req.getSession();

        pw.println("<html><body>");
        pw.println("<h2>Welcome to Counter Servlet</h2>");

        Integer gVal = (Integer) s.getAttribute("CounterGetName");
        pw.println("<p>Counter for GET: " + gVal);
        if (Boolean.TRUE.equals(s.getAttribute("WarningGet"))) {
            pw.println(" <span style='color:red; font-weight:bold;'>WARNING GET</span>");
        }
        pw.println("</p>");

        Integer pVal = (Integer) s.getAttribute("CounterPostName");
        pw.println("<p>Counter for POST: " + pVal);
        if (Boolean.TRUE.equals(s.getAttribute("WarningPost"))) {
            pw.println(" <span style='color:red; font-weight:bold;'>WARNING POST</span>");
        }
        pw.println("</p>");

        pw.println("<br><a href='index.jsp'>Inapoi la index</a>");
        pw.println("</body></html>");
    }
}