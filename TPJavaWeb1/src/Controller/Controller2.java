package Controller;

import Model.Matiere;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller2() {
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
		String nom=request.getParameter("nom");
		String nbh=request.getParameter("nbh");
		if(nom.isEmpty() || nbh.isEmpty()){
			response.sendRedirect("/TPJavaWeb1/Form");
		}
		else{
			Matiere m = new Matiere(nom, Integer.parseInt(nbh));
			//PrintWriter wr = response.getWriter();
			//String rep=m.toString();
			//wr.println(rep);
			
			
			HttpSession session = request.getSession();
			
            session.setAttribute("Matiere", m.getNom());
            
            request.getRequestDispatcher("/View3").forward(request, response);
		}
	}

}
