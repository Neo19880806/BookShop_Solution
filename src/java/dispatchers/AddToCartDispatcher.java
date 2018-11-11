/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;

/**
 * @author Guojing LIANG
 * AddToCartDispatcher
 */
public class AddToCartDispatcher implements Dispatcher {

    @Override
    public String execute(HttpServletRequest request) {
        String nextPage = nextPage = "/jsp/titles.jsp";
        HttpSession session = request.getSession();
        Map cart = (Map) session.getAttribute("cart");
        String[] selectedBooks = request.getParameterValues("add");
        String[] quantities = request.getParameterValues("quantity");
        //when nothing selected, do nothing
        if (selectedBooks != null) {
            if (cart == null) {
                cart = new HashMap();
                for (String info : selectedBooks) {
                    String[] splits = info.split(",");
                    String isbn = splits[0];
                    int pos = Integer.parseInt(splits[1]);
                    int quantity = Integer.parseInt(quantities[pos - 1]);
                    Book book = this.getBookFromList(isbn, session);
                    CartItem item = new CartItem(book);
                    item.setQuantity(quantity);
                    cart.put(isbn, item);
                } // end for
                session.setAttribute("cart", cart);
            } // end if
            else {
                for (String info : selectedBooks) {
                    String[] splits = info.split(",");
                    String isbn = splits[0];
                    int pos = Integer.parseInt(splits[1]);
                    int quantity = Integer.parseInt(quantities[pos - 1]);
                    if (cart.containsKey(isbn)) {
                        CartItem item = (CartItem) cart.get(isbn);
                        item.setQuantity(quantity);
                    } // end if
                    else {
                        Book book = this.getBookFromList(isbn, session);
                        CartItem item = new CartItem(book);
                        item.setQuantity(quantity);
                        cart.put(isbn, item);
                    } // end else
                } // end for
            } //end else
        }
        return nextPage;
    }

    private Book getBookFromList(String isbn, HttpSession session) {
        List list = (List) session.getAttribute("books");
        Book aBook = null;
        for (int i = 0; i < list.size(); i++) {
            aBook = (Book) list.get(i);
            if (isbn.equals(aBook.getIsbn())) {
                break;
            } // end if
        } // end for
        return aBook;
    } // end getBookFromList
}
