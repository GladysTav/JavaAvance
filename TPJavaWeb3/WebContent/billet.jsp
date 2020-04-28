<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Billet"
import="Model.GestionBillets" %>
<%! private Billet billet = new Billet(); %>
<%
    billet.setContenu((String) request.getParameter("contenu"));
    billet.setTitre((String) request.getParameter("titre"));
    billet.setAuteur((String) request.getParameter("auteur"));
 %>
<!doctype html>
<html>
<head>
<link type='text/css' rel="stylesheet" href="Style.css">
    <title>Billet</title>
</head>
<body>
<h2>Hello <%= session.getAttribute("login")%> !</h2>
<p>Ceci est un billet de <u><%= billet.getAuteur() %></u> dont le titre est <u><%= billet.getTitre() %></u></p>
<div class="contenu"><i><%= billet.getContenu()%></i></div>
<hr>
<h2>Commentaires :</h2><hr>
	<% 
	try{
		if(billet.getAuteur()==null || billet.getAuteur().isEmpty()
				|| billet.getTitre()==null || billet.getTitre().isEmpty()
				|| billet.getContenu()==null || billet.getContenu().isEmpty()){
			out.println("<i>Erreur, valeur null ou vide</i><hr>");
		}
		else if(GestionBillets.getBillet(billet.getAuteur(),billet.getTitre(),billet.getContenu())==null){
			out.println("<i>Erreur, billet null</i><hr>");
		}
		else if(GestionBillets.getBillet(billet.getAuteur(),billet.getTitre(),billet.getContenu()).getNbCommentaires()>0){
			billet = GestionBillets.getBillet(billet.getAuteur(),billet.getTitre(),billet.getContenu());
			for(int i=0; i<billet.getNbCommentaires();i++){ %>
				<p><h2>Auteur : <% out.println(billet.getCommentaire(i).getAuteur()); %></h2></h2></p>
				<p><h3>Titre : <% out.println(billet.getCommentaire(i).getTitre()); %></h3></h3></p>
				<p>Contenu : <% out.println(billet.getCommentaire(i).getContenu()); %></p>
				<br><hr>
			<% }
		}
		else{
			out.println("<u>Aucun commentaire</u><hr>");
		}
	}
	catch(Exception e){ out.println("<i>Erreur - "+e.toString()+"</i><hr>"); } %>
<br>
<br>
<form method="post" action="ControllerBillet">
    <p>
        Ajouter un commentaire :<br>
        Titre : <input type="text" name="titrec">
        Commentaire : <textarea name="commentaire"></textarea>
        
        <input type="hidden" name="titre" value="<%= billet.getTitre() %>">
        <input type="hidden" name="auteur" value="<%= billet.getAuteur() %>">
        <input type="hidden" name="contenu" value="<%= billet.getContenu() %>">
        <input type="submit" value="Envoyer">
    </p>
</form>
<p><a href="saisie.html">Saisir un nouveau billet</a></p>
<p><a href="billets.jsp">Retour à la liste des billets</a></p>
<p><a href="Deco">Se déconnecter</a></p>

</body>
</html>