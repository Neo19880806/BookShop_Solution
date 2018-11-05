/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import utility.AdmitBookStoreDAO;

/**
 *
 * @author Administrator
 */
public class HomeDispatcher implements Dispatcher {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
        String nextPage = "";
        try {
            System.out.println("inside try block of ShowHomeAO.exe()");
            List<Book> books = dao.getAllBooks();
            session.setAttribute("books", books);
            nextPage = "/jsp/titles.jsp";
        } catch (Exception ex) {
            request.setAttribute("result", ex.getMessage());
            nextPage = "/jsp/error.jsp";
        }
        return nextPage;
    }
}
