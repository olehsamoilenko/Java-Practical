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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("buses", bdao.getAsList());
        RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* came from add.jsp */
        String userId = request.getParameter("userId");
        if (userId.length() == 8
            && Character.isLetter(userId.charAt(0))
            && Character.isLetter(userId.charAt(1))
            && Character.isDigit(userId.charAt(2))
            && Character.isDigit(userId.charAt(3))
            && Character.isDigit(userId.charAt(4))
            && Character.isDigit(userId.charAt(5))
            && Character.isLetter(userId.charAt(6))
            && Character.isLetter(userId.charAt(7))
        ) {
            bdao.add(new Bus(userId));
        }

        request.setAttribute("buses", bdao.getAsList());
        RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
        rd.forward(request, response);
    }
}
