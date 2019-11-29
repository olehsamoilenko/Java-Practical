import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// TODO: url pattern
@WebServlet("/")
public class Servlet extends HttpServlet {

    private static BusDAO bdao;

    static {
        bdao = new BusDAO();
    }

    // TODO: try remove web.iml

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<String> lst = new ArrayList<>();
//        lst.add("hi");
//        request.setAttribute("list", lst);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }
}
