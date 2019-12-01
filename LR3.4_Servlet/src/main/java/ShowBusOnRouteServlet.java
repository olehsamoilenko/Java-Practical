import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowBusOnRouteServlet extends HttpServlet {

    private static BusOnRouteDAO bdao;

    static {
        bdao = new BusOnRouteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("buses", bdao.getAsList());
        RequestDispatcher rd = req.getRequestDispatcher("showBusOnRoute.jsp");
        rd.forward(req, resp);
    }
}
