import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("hello")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setStatus(200);
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Witaj Swiecie!");

        if(req.getParameter("average") != null){

            String parameter = req.getParameter("average");
            String[] tab = parameter.split(",");

            double sum = 0.0;
            for(int i = 0; i < tab.length; i++){
                sum = sum + Double.parseDouble(tab[i]);
            }
            double result = sum/tab.length;
            respWriter.println("Average= " + result);
        }
    }
}
