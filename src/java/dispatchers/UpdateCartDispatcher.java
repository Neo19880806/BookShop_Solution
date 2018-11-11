/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;

/**
 * @author Guojing LIANG UpdateCartDispatcher
 */
public class UpdateCartDispatcher implements Dispatcher {

    @Override
    public String execute(HttpServletRequest request) {
        Map cart = null;
        Book book = null;
        CartItem item = null;
        String isbn = null;
        String nextPage = "/jsp/cart.jsp";
        HttpSession session = request.getSession();
        cart = (Map) session.getAttribute("cart");
        String[] booksToRemove = request.getParameterValues("remove");
        if (booksToRemove != null) {
            for (int i = 0; i < booksToRemove.length; i++) {
                cart.remove(booksToRemove[i]);
            }
        }
        Set entries = cart.entrySet();
        Iterator iter = entries.iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            isbn = (String) entry.getKey();
            item = (CartItem) entry.getValue();
            int quantity = Integer.parseInt((request.getParameter(isbn)));
            if (quantity <= 0) {
                cart.remove(isbn);
            } else {
                item.updateQuantity(quantity);
            }
        }
        return nextPage;
    }
}
