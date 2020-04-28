package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerDAO
 */
@WebServlet("/ControllerDAO")
public class ControllerDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type=request.getParameter("type");
		//System.out.println("Dans doPost de ControllerDAO : "+type);

		
		if(type.equals("ajouter")){
			//System.out.println("Dans type=ajouter de ControllerDAO");
			if(request.getParameter("prenom").isEmpty() || request.getParameter("login").isEmpty() || request.getParameter("age").isEmpty() || request.getParameter("password").isEmpty() || request.getParameter("statut").isEmpty() || !request.getParameter("age").matches("-?\\d+")){

				//System.out.println("Dans if erreurs de ControllerDAO");
				response.sendRedirect("/TPJavaWeb2/Exo5");
			}
			else{
				//System.out.println("Dans else erreurs de ControllerDAO");
				DAO.DAOAcces.ajouter(request.getParameter("prenom"), request.getParameter("login"), request.getParameter("age"), request.getParameter("password"), request.getParameter("statut"));
				response.sendRedirect("/TPJavaWeb2/Exo5");
			}
			
			
		}
		
		else if(type.equals("supprimer")){
			//System.out.println("Dans type=ajouter de ControllerDAO");
			if(request.getParameter("id").isEmpty() || !request.getParameter("id").matches("-?\\d+")){

				response.sendRedirect("/TPJavaWeb2/Exo5");
			}
			else{
				DAO.DAOAcces.supprimer(request.getParameter("id"));
				response.sendRedirect("/TPJavaWeb2/Exo5");
			}
			
			
		}
		
		else{
			//System.out.println("Dans else type de ControllerDAO");
			response.sendRedirect("/TPJavaWeb2/Exo5");
		}
	}

}
