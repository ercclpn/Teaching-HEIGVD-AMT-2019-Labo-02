package ch.heigvd.amt.mvcsimple.presentation;

import ch.heigvd.amt.mvcsimple.business.QuoteGenerator;
import ch.heigvd.amt.mvcsimple.business.local.CounterLocal;
import ch.heigvd.amt.mvcsimple.model.Quote;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * The QuoteServlet is the Controller in the pattern. It receives HTTP requests, decides that the
 * QuoteGenerator service can provide the model (a list of Quote objects). After invoking the
 * service and obtaining the model, it attaches the model to the request (as a parameter named 'quotes').
 * Finally, it finds the view capable of rendering the model (view.jsp) and delegates the end of the work
 * to this component (by calling forwarding the request).
 */
@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private CounterLocal counter;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        if("reset".equals(command)){
            counter.resetCounter();
        }else{
            counter.incrementCounter();

        }

        response.getWriter().println("This page has been accessed " + counter.getCounterValue() + " time(s).");
    }
}
