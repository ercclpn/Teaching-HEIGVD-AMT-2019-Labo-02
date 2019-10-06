package ch.heigvd.amt.mvcsimple.presentation;

import com.sun.mail.imap.protocol.INTERNALDATE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CounterSessionServlet", urlPatterns = "/counter_session")
public class CounterSessionServlet extends javax.servlet.http.HttpServlet{

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String attributeSession = "array";
        HttpSession session = request.getSession();
        if(session.getAttribute(attributeSession) == null){
            session.setAttribute(attributeSession, new ArrayList<Integer>());
        }

        String command = request.getParameter("command");
        ArrayList<Integer> arrayVal = (ArrayList<Integer>) session.getAttribute(attributeSession);
        if("reset".equals(command)){
            arrayVal.clear();
        }else{
            arrayVal.add(arrayVal.size());
        }

        response.getWriter().println("Array has " + arrayVal.size() + " element(s).");
    }

}
