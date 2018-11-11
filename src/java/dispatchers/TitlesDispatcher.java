/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utility.AdmitBookStoreDAO;

/**
 * @author Guojing LIANG
 * TitlesDispatcher
 */
public class TitlesDispatcher implements Dispatcher
{
    @Override
    public String execute(HttpServletRequest request) 
    {
        HttpSession session = request.getSession ();
        String ds = (String)session.getAttribute("ds");
        AdmitBookStoreDAO dao = new AdmitBookStoreDAO(ds);
        List books = null;
        String nextPage = "/jsp/error.jsp";
        try{
            //System.out.println("inside try block of ShowHomeAO.exe()");
            books = dao.getAllBooks();
            if(books !=null)
            {
                session.setAttribute ("books", books);
                 nextPage = "/jsp/titles.jsp";
            }
        }catch(Exception ex) {
            request.setAttribute ("result",ex.getMessage());
            nextPage= "/jsp/error.jsp";
        } // end catch{
        return nextPage;
    }
}
