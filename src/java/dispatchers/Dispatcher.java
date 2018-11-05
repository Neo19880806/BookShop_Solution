
package dispatchers;

import javax.servlet.http.HttpServletRequest;

public interface Dispatcher {
    public String execute(HttpServletRequest request);
}
