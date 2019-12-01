import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowRoutesServlet extends HttpServlet {

    private static RouteDAO rdao;

    static {
        rdao = new RouteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("routes", rdao.getAsList());
        RequestDispatcher rd = req.getRequestDispatcher("showRoutes.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* came from addRoutes.jsp */
        String startCity = request.getParameter("startCity");
        String endCity = request.getParameter("endCity");
        int distance = new Integer(request.getParameter("distance"));

        rdao.add(new Route(startCity, endCity, distance));

        request.setAttribute("routes", rdao.getAsList());
        RequestDispatcher rd = request.getRequestDispatcher("showRoutes.jsp");
        rd.forward(request, response);
    }
}
