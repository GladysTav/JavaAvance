package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String[] result = Model.Select.main();
		if(result == null){
			out.println("<b>Aucune ligne trouvée</b>");
		}
		else{
			out.println("<table border=2>");
			out.println("<tr><td>Prénom</td><td>Login</td><td>Statut</td><td>Âge</td></tr>");
			for(Integer i=0; i+3<result.length; i+=4){
				out.println("<tr><td>"+result[i]+"</td>");
				out.println("<td>"+result[i+1]+"</td>");
				out.println("<td>"+result[i+2]+"</td>");
				out.println("<td>"+result[i+3]+"</td></tr>");
			}
			out.println("</table>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
