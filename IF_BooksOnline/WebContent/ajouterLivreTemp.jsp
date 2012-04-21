<%@ page session="true" language="java" import="java.util.*, facade.*"
	pageEncoding="ISO-8859-1"%>
<%
	Object le_user = session.getAttribute("user");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Vente de livres en ligne</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
  <div id="wrapper">
      <div id="menu">
          <h1><a href="index.jsp"><img src="images/logo.gif" width="121" height="22" alt="Books Online" /></a></h1>
          <ul id="navblue">
              <li><a href="findBooks.jsp?categorie='bestsellers'">bestsellers</a></li>
              <li><a href="findBooks.jsp?categorie='magazines'">magazines</a></li>
          </ul>
          <br /><br /><br />
          <br /><br />
      </div><!-- end menu -->
      <div id="header">
      <form style="float:right">
      		<select id="devise" onchange="deviseEncours(this.value)">
      			<option value="EUR" >EUR</option>
      			<option value="GBP" >GBP</option>
      			<option value="JPY" >JPY</option>
      			<option value="USD" >USD</option>
      		</select>
      	</form>
          <ul id="navtop">
              <li><b>Bienvenue Nghi,</b> &nbsp;&nbsp;&nbsp;<a href="logout.jsp"><u>Déconnexion</u></a></li>
          </ul>
          <a href="passerCommande.jsp?panier='tr'" ><img src="images/panier.jpg" alt="mon panier" /></a>
          <h2><img src="images/title_explore.gif" width="185" height="20" alt="explore your knowledge" /></h2>
          <div id="books"></div>
          <div id="girl"></div>
      </div>
      <div class="divider"></div>
      <div id="searchbar">
          <form action="/" method="get">
              Title: <input name="title" type="text" value="" class="text" /> &nbsp;
              Author: <input name="author" type="text" value="" class="text" /> &nbsp;
              <input type="submit" value="Go" class="submit" />
          </form>
      </div><!-- end searchbar -->
      
      <div id="orangerow">
          
          <div class="nav">
              <h2 id="categories">Categories</h2>
              <ul>
                  <li><a href="findBooks.jsp?categorie='gestion'">Gestion</a></li>
                  <li><a href="findBooks.jsp?categorie='informatique'">Informatique</a></li>
              </ul>
          </div><!-- end .nav -->
          
          <div class="col2">
               <h2>
					<font color="blue"><b>Ajouter un livre</b></font>
			   </h2>
			   <hr />
			   <form action="controller" method="post" name="addLivre" id = "adLivre" >
             	<table cellspacing="4" cellpadding="0">
                  <tr>
                      <td> Titre: </td><td><input type="text" name="titre" id="titre" style="border: 1px solid #000"/></td>
                  </tr>
                 <tr>
                      <td> Description: </td><td><textarea rows="3" cols="15" name="description" id="description" style="border: 1px solid #000"></textarea></td>
                  </tr>
                  <tr>
                      <td> Nombre de disponible: </td><td><input type="text" name="nbDispo" id="nbDispo" style="border: 1px solid #000" />&nbsp; // la devise utilisé sera celle en cours mais elle sera convertit en euro</td>
                  </tr>
                  <tr>
                      <td> Prix: </td><td><input type="text" name="prix" id="prix" style="border: 1px solid #000" /></td>
                  </tr>
                  <tr>
                      <td colspan="2">
                      	<center ><input type="submit" id="add_livre" name="add_livre" 
                      			value="Ajouter" style="width:120px; size:2px"/></center>
                      </td>
                  </tr>
              </table>
             </form>
          </div>
          <div id="whitey"></div>
          <div class="clear"><div class="fix"></div></div>
      </div>
      
      <div id="greenrow">
          
          <div class="nav">
              <h2 id="discounts">Auteurs</h2>
              <ul>
                  <li><a href="findBooks.jsp?auteur='georges'">Georges</a></li>
                  <li><a href="findBooks.jsp?auteur='steven'">Steven</a></li>
              </ul>
              <br /><br />
          </div>
          
          
          <div class="clear"></div>
      </div>
      
      <div class="footer">
		    <div id="footeri">
		      <p class="lf">&copy; Copyright 2011. &nbsp; &nbsp; R&eacute;alis&eacute; par <a href="index.jsp"> BOOKS CORPORATION</a></p>
		      <div style="clear:both;"></div>
		    </div>
		  </div>
  </div>
</body>
</html>
