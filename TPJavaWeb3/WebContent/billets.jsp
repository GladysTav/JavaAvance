<%@ page import="Model.GestionBillets"
		import="Model.Billet"
		import="java.util.ArrayList"
		import="java.util.List"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    session="true" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="
		background-image:url('Photos/D.jpg'); 
	 	background-size: cover; 
	 	background-repeat: no-repeat;">
<head>
<!-- 
La page billet.jsp permet d'afficher les billets. Actuellement, elle n'en affiche qu'un et ne prend pas en compte les commentaires. 
À vous de mettre en place ces fonctionnalités :
1.	Rajoutez à la classe Billet la possibilité de gérer des commentaires
2.	Mettez en place l'affichage des commentaires en-dessous du contenu du billet
3.	Mettez en place une variable globale de type GestionBillets
4.	Mettez en place un mode d'appel de la page billet.jsp pour que l'utilisateur puisse choisir quel billet afficher
5.	Ajoutez à la page un header HTTP Refresh pour que la page soit rafraîchie toutes les 5 secondes et qu'on puisse voir les commentaires 
ajoutés par un autre utilisateur




Faites en sorte que les utilisateurs aient accès à la liste des billets publiés, à l'aide d'un menu affiché sur billet.jsp. 
Chacun des éléments de cette liste possèdera un lien qui renverra vers l'affichage du billet correspondant.
Placez ce menu dans une JSP séparée, que vous incluerez dans billet.jsp à l'aide de la directive appropriée.

 -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="
	width: 80%; 
	border: 2px solid purple; 
	border-radius: 15px; 
	padding: 5px;  
	background-color: #F7A3F4; 
	text-align: center;
	margin-top: 60%
	padding-bottom: 15px;
	position: absolute; /* postulat de dÃ©part */
	left: 50%; /* Ã  50%/50% du parent rÃ©fÃ©rent */
	transform: translate(-50%, 0); /* dÃ©calage de 50% de sa propre taille */
	">
<h1>Bienvenue sur billets.jsp <%=session.getAttribute("login") %> !</h1><br>
<h3>Dernier billet :</h3>
Titre : <%=GestionBillets.getLastBillet().getTitre()%><br>
Auteur : <%=GestionBillets.getLastBillet().getAuteur()%><br>
Contenu : <%=GestionBillets.getLastBillet().getContenu()%><br>

<br>
<h3>Consulter un billet</h3>

	<% for(int i=0; i<GestionBillets.getNbBillets(); i++){%>
		<form method=POST action="billet.jsp">
		<input type=hidden value="<%=GestionBillets.getBillet(i).getTitre() %>" name="titre" >
		<input type=hidden value="<%=GestionBillets.getBillet(i).getAuteur() %>" name="auteur" >
		<input type=hidden value="<%=GestionBillets.getBillet(i).getContenu() %>" name="contenu" >
		<input type="submit" value="<%=GestionBillets.getBillet(i).getTitre() %>">
		</form><br>
		<% } %>


<br>
<a href="Deco"><u>Se déconnecter</u></a>
</body>
</html>