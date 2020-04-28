package Controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Billet;
import Model.Commentaire;
import Model.GestionBillets;

/**
 * Servlet implementation class ControllerBillet
 */
@WebServlet("/ControllerBillet")
public class ControllerBillet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerBillet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		/*PrintWriter out=response.getWriter();

	    out.println("");
	    out.println(session.getAttribute("login"));
	    out.println(request.getParameter("contenu"));
	    out.println(request.getParameter("titre"));
	    out.println(request.getParameter("auteur"));
	    out.println(request.getParameter("commentaire"));
	    out.println("");
	    out.println("");*/
	    
	    if(request.getParameter("commentaire")!=null && !request.getParameter("commentaire").isEmpty()
	    		&& request.getParameter("titrec") !=null && !request.getParameter("titrec").isEmpty()
	    		&& request.getParameter("titre") !=null && !request.getParameter("titre").isEmpty()
	    		&& request.getParameter("contenu") !=null && !request.getParameter("contenu").isEmpty()
	    		&& request.getParameter("auteur") !=null && !request.getParameter("auteur").isEmpty()){//add commentaire
	    	
	    	Billet b = GestionBillets.getBillet(request.getParameter("auteur"),request.getParameter("titre"), request.getParameter("contenu"));
			Commentaire c = new Commentaire(request.getParameter("titrec"),request.getParameter("commentaire"),session.getAttribute("login").toString());
			b.addCommentaire(c);
			request.setAttribute("commentaire", null);
			request.setAttribute("titrec", null);
			request.getRequestDispatcher("billet.jsp").forward(request, response);
	    	
	    }
	    else if(request.getParameter("titre") !=null && !request.getParameter("titre").isEmpty()
	    		&& request.getParameter("contenu") !=null && !request.getParameter("contenu").isEmpty()){//add Billet
	    	
	    	Billet b = new Billet(request.getParameter("titre"),request.getParameter("contenu"),(String) session.getAttribute("login"));
	    	GestionBillets.add(b);
			request.setAttribute("titre", null);
			request.setAttribute("contenu", null);
			request.getRequestDispatcher("billets.jsp").forward(request, response);
	    	
	    }
	    else{
			request.getRequestDispatcher("index.html").forward(request, response);
	    }
	}

}
