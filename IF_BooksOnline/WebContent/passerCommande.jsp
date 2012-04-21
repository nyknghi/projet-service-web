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
					<font color="blue"><b>MON  PANIER</b></font>
			   </h2>
			   <hr />
             <table cellspacing="4" cellpadding="0">
                  <tr>
                      <td><a href="">Crise financière et balses III</a>    de <b>Steven</b></td><td></td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b>Description:</b>  Ce livre a été fait pour aidertous les financier;</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Quantité:</u></b>  1</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Prix:</u></b>  15.5 euro
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      		<form id="panierSupp" name="panierAdd" action="controller" method="post" style="float:right">
                      			<input type="button" id="panier_supp" name="panier_supp" 
                      			value="Enlever du panier" style="width:120px; size:2px"/>
                      			<input type="hidden" value="id di livre" id="idLivre" name="idLivre" />
                      		</form>
                      </td>
                      
                  </tr>
                  
                  <tr>
                      <td>&nbsp;&nbsp;<hr/></td>
                  </tr>
                  
                  <tr>
                      <td><a href="">Finances de marchés</a>    de <b>Steven</b></td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b>Description:</b>  Ce livre a été fait pour les étudiants principalement;</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Quantité:</u></b>  3</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Prix:</u></b>  25 euro
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      		<form id="panierSupp" name="panierAdd" action="controller" method="post" style="float:right">
                      			<input type="button" id="panier_supp" name="panier_supp" 
                      			value="Enlever du panier" style="width:120px; size:2px"/>
                      			<input type="hidden" value="id di livre" id="idLivre" name="idLivre" />
                      		</form>
                      </td>
                      
                  </tr>
              </table>
              <hr />
              <table>
              	<tr>
              		<td>
              			<b><u>Total:</u> 90.5 euro</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              			<form id="panierTake" name="panierTake" action="controller" method="post" style="float:right">
                      			<input type="button" id="panier_vide" name="panier_vide" 
                      			value="Vider panier" style="width:120px; size:2px"/>
                      			<input type="button" id="passerCommande" name="passerComamnde" 
                      			value="Passer commande" style="width:120px; size:2px"/>
                      	</form>
              		</td>
              	</tr>
              </table>
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
