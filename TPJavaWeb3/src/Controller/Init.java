package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Billet;
import Model.GestionBillets;

/**
 * Servlet implementation class Initi
 * 
 * La servlet Init effectue un traitement de la requête : si la requête est envoyée en POST, 
 * elle récupère le pseudo de l'utilisateur en paramètre et le stocke en attribut de session, 
 * et redirige l'utilisateur sur une la JSP qui affiche les billets billets.jsp. 
 * Si la requête est envoye en GET, elle redirige sur la page d'accueil.
 */
@WebServlet("/Init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/TPJavaWeb3/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String log = request.getParameter("login");
		String grp = request.getParameter("groupe");
		//PrintWriter out=response.getWriter();
		//System.out.print("Login reçu : "+log);
		if(log.isEmpty() || log.equals(null) || log.equals("") || grp.isEmpty() || grp.equals("") || grp.equals(null)){
			response.sendRedirect("/TPJavaWeb3/index.html");
		}
		else{
			HttpSession session = request.getSession(true);
	        session.setAttribute("login", log);
	        session.setAttribute("groupe", grp);
	        
	        new GestionBillets();
	        GestionBillets.add(new Billet());
	        GestionBillets.add(new Billet("test1","test2","test3"));

			request.getRequestDispatcher("billets.jsp").forward(request, response);
		}
	}

}
