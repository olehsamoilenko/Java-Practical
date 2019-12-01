import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowServlet extends HttpServlet {

    private static BusDAO bdao;

    static {
        bdao = new BusDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");

        request.setAttribute("buses", bdao.getAsList());
//        response.sendRedirect("show.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
        rd.forward(request, response);
    }
}
