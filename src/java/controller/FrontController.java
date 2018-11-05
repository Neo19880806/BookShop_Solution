package controller;

import dispatchers.AddToCartDispatcher;
import dispatchers.CheckoutDispatcher;
import dispatchers.ContinueDispatcher;
import dispatchers.Dispatcher;
import dispatchers.HomeDispatcher;
import dispatchers.TitlesDispatcher;
import dispatchers.UpdateCartDispatcher;
import dispatchers.ViewCartDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class FrontController extends HttpServlet {

    private final HashMap<String, Dispatcher> actions = new HashMap<String, Dispatcher>();

    //Initialize global variables
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        actions.put("titles", new TitlesDispatcher());
        actions.put("add_to_cart", new AddToCartDispatcher());
        actions.put("checkout", new CheckoutDispatcher());
        actions.put("continue", new ContinueDispatcher());
        actions.put("home", new HomeDispatcher());
        actions.put("update_cart", new UpdateCartDispatcher());
        actions.put("view_cart", new ViewCartDispatcher());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("doGet()");
        doPost(request, response);
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String requestedAction = request.getParameter("action");
        String ds = this.getInitParameter("url");
        HttpSession session = request.getSession();
        session.setAttribute("ds", ds);
        requestedAction = requestedAction==null?"titles":requestedAction;
        
        String nextPage = actions.get(requestedAction).execute(request);
        this.dispatch(request, response, nextPage);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
    
    //Get Servlet information
    public String getServletInfo() {
        return "controller.FrontController Information";
    }
}
