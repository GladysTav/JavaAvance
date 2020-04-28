package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exo5
 */
@WebServlet("/Exo5")
public class Exo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exo5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		out.println("<html><body bgcolor=\"white\"><h1>Tests pour l'exercice 5</h1></br><h2><i>DAOAcces.lister()</i></h2></br>");
		
		String[] result = DAO.DAOAcces.lister();
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
		
		out.println("</br><h2><i>DAOAcces.ajouter()</i></h></br></br>");

		out.println("<form enctype=\"application/x-www-form-urlencodeed action=\"ControllerDAO\" method=POST>");
		out.println("Prénom : ");
		out.println("<input type=text size=20 name=prenom></br>");
		out.println("Login : ");
		out.println("<input type=text size=20 name=login></br>");
		out.println("Age : ");
		out.println("<input type=text size=20 name=age></br>");
		out.println("Password : ");
		out.println("<input type=password size=20 name=password></br>");
		out.println("Statut : ");
		out.println("<input type=text size=20 name=statut></br>");
		out.println("<input type=hidden name=type value='ajouter'></br>");
		out.println("<input type=submit value=\"Insérer ce user\"></form>");
		

		out.println("</br><h2><i>DAOAcces.supprimer()</i></h></br></br>");
		
		out.println("<form enctype=\"application/x-www-form-urlencodeed action=\"ControllerDAO\" method=POST>");
		out.println("ID : ");
		out.println("<input type=text size=20 name=id></br>");
		out.println("<input type=hidden name=type value='supprimer'></br>");
		out.println("<input type=submit value=\"Supprimer l'utilisateur associé à cet ID\"></form></body></hmtl>");
		
		
		out.println("</body></hmtl>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.getRequestDispatcher("/ControllerDAO").forward(request, response);
	}

}
