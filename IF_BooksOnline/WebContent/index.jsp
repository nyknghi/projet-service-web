<%@ page session="true" language="java" import="java.util.*, facade.*"
	pageEncoding="ISO-8859-1"%>
<%
	Object cliinf = session.getAttribute("clientinfo");
	String[] clientInfo = new String[3];
	if(cliinf != null)
		clientInfo = (String[])cliinf;
	
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
              <%if(cliinf != null && clientInfo != null){ 
              		if(clientInfo[1].toString().equals("AUTEUR")){%>
              <li><a href="ajouterlivreTemp.jsp">magazines</a></li>
              <% }} %>
          </ul>
          <%if(cliinf == null){ %>
              <br />
          <% } %>
          <br /><br />
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
	          <%if(cliinf != null){ %>
	              <li><b>Bienvenue <%=clientInfo[2] %>,</b> &nbsp;&nbsp;&nbsp;<a href="logout.jsp"><u>Déconnexion</u></a></li>
                  <li>&nbsp;&nbsp;</li>
                  <li>&nbsp;&nbsp;</li>
	          <% } %>
              
          </ul>
          <a href="passerCommande.jsp?panier='tr'" ><img src="images/panier.jpg" alt="mon panier" /></a>
          <h2><img src="images/title_explore.gif" width="185" height="20" alt="explore your knowledge" /></h2>
          <div id="books"></div>
          <div id="girl"></div>
      </div>
      <div class="divider"></div>
      <div id="searchbar">
          <form action="controller" method="post">
              Title: <input name="title" id="title" type="text" value="" class="text" style="width:100px" /> &nbsp;
              Author: <input name="author" id="author" type="text" value="" class="text" style="width:100px" /> &nbsp;
              <input type="hidden" id="action" name="action" value="1" />
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
          
          <div class="col">
              <div id="authormonth">
              	<% if (cliinf != null){ %>
                  <h2>
					<font color="blue"><b>Auteur du mois</b></font>
				  </h2>
                  <p>
                  	L'auteur <b>Steven</b> a été élu auteur du mois.
                  </p>
                  <img src="images/picture_1.jpg" width="71" height="133" alt="Woman reading a book" class="left" />
                  <% } else{ %>
                  <form id="forLogin" name="forLogin" method="post" action="controller">
					<table>
						<tr>
							<td> User ID</td>
							<td><input id="login" name="login" type="text" maxlength="15" style="width:100px" /></td>
						</tr>
						<tr>
							<td> Password</td>
							<td><input id="pwd" name="pwd" type="password" maxlength="15" style="width:100px" /></td>
						</tr>
					</table>
					<center><input type="submit" name="login_form_ok" id="login_form_ok" aria-disabled="false" role="button"
							 class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" value="Connexion"/></center>
					<input type="hidden" id="action" name="action" value="0"/>
				</form>
				<%} %>
              </div>
              <div id="bookmonth">
                  <h2>
					<font color="blue"><b>Livre du mois</b></font>
				  </h2>
                  <img src="images/picture_3.jpg" width="57" height="85" alt="dog books" class="left" />
                	<p>Le livre <a href="">Programmation C++   </a>de <b> Georges </b> a été élu livre du mois. Il a également été le plus vendu sur ce site.</p>
              </div>
          </div>
          <div id="whitey"></div>
          <div class="clear"><div class="fix"></div></div>
      </div><!-- end orangerow -->
      
      <div id="greenrow">
          
          <div class="nav">
              <h2 id="discounts">Auteurs</h2>
              <ul>
                  <li><a href="findBooks.jsp?auteur='georges'">Georges</a></li>
                  <li><a href="findBooks.jsp?auteur='steven'">Steven</a></li>
              </ul>
          </div>
          
          <div class="col">
               <h2>
					<font color="blue"><b>Livre à venir</b></font>
			   </h2>
              <table summary="book list" class="books" cellspacing="4" cellpadding="0">
                  <tr>
                      <td><a href="">Programmation C#</a>    de <b>Georges</b></td>
                  </tr>
                  <tr>
                      <td><a href="">Finances de marchés</a>    de <b>Steven</b></td>
                  </tr>
              </table>
             <p>Si vous voulez des livres plus professionnels et adapté à vos besoins veuillez visitez dans 2 jours.
             Les livres a venir sont alléchant.</p>
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
