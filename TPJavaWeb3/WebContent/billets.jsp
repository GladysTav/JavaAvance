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
� vous de mettre en place ces fonctionnalit�s :
1.	Rajoutez � la classe Billet la possibilit� de g�rer des commentaires
2.	Mettez en place l'affichage des commentaires en-dessous du contenu du billet
3.	Mettez en place une variable globale de type GestionBillets
4.	Mettez en place un mode d'appel de la page billet.jsp pour que l'utilisateur puisse choisir quel billet afficher
5.	Ajoutez � la page un header HTTP Refresh pour que la page soit rafra�chie toutes les 5 secondes et qu'on puisse voir les commentaires 
ajout�s par un autre utilisateur




Faites en sorte que les utilisateurs aient acc�s � la liste des billets publi�s, � l'aide d'un menu affich� sur billet.jsp. 
Chacun des �l�ments de cette liste poss�dera un lien qui renverra vers l'affichage du billet correspondant.
Placez ce menu dans une JSP s�par�e, que vous incluerez dans billet.jsp � l'aide de la directive appropri�e.

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
	position: absolute; /* postulat de départ */
	left: 50%; /* à 50%/50% du parent référent */
	transform: translate(-50%, 0); /* décalage de 50% de sa propre taille */
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
<a href="Deco"><u>Se d�connecter</u></a>
</body>
</html>