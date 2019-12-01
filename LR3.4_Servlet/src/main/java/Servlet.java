import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {

    private static BusDAO bdao;

    static {
        bdao = new BusDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("buses", bdao.getAsList());
//        RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
//        rd.forward(request, response);

        RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
        rd.forward(request, response);
    }
}
