package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html><html class=\"Sommaire\"><head>");
		out.println("<title>Exos Java Web</title> <meta content=\"text/html;charset=utf-8\"/>");
		out.println("<link type='text/css' rel=\"stylesheet\" href=\"/CSS/Style.css\"> <!-- Feuille de style des sommaires --></head>");
		out.println("<body><h1>Bienvenue sur mon site</h1><br>");
		out.println("<ul>");
		out.println("<li><a href=\"FormInsert\">Ins�rer un user dans la DB</a></li>");
		out.println("<li><a href=\"DeleteId\">Supprimer un user dans la DB</a></li>");
		out.println("<li><a href=\"ChangeStatut\">Changer le statut d'un user dans la DB</a></li>");
		out.println("<li><a href=\"Select\">Liste des users</a></li>");
		out.println("<li><a href=\"Exo5\">Exercice 5 - DAO</a></li>");
		out.println("</ul>");
		
		out.println("</form></body></hmtl>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
