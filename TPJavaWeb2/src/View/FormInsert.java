package View;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/FormInsert")
public class FormInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormInsert() {
        super();
        // TODO Auto-generated constructor stub
        BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("main.html"));
			bw.write("<html><head><title>New Page</title></head><body><p>This is Body</p></body></html>");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body bgcolor=\"white\">");
		out.println("<h1>Bienvenue !</h1>");
		out.println("<form enctype=\"application/x-www-form-urlencodeed action=\"Resultat\" method=POST>");
		out.println("Nom : ");
		out.println("<input type=text size=20 name=nom></br>");
		out.println("Login : ");
		out.println("<input type=text size=20 name=log></br>");
		out.println("Age : ");
		out.println("<input type=text size=20 name=age></br>");
		out.println("<input type=submit value=\"Insérer ce user\"></form></body></hmtl>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//request.getRequestDispatcher("/Controller1").forward(request, response);
		request.getRequestDispatcher("/Controller3").forward(request, response);
		
	}

}
