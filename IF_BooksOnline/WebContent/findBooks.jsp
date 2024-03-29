<%@ page session="true" language="java" import="java.util.*, facade.*"
	pageEncoding="ISO-8859-1"%>
<%
	Object cliinf = session.getAttribute("clientinfo");
	Object livres = session.getAttribute("LesLivres");
	Books[] LesLivres = new Books[3];
	String[] clientInfo = new String[3];
	int size = 0;
	if(cliinf != null)
		clientInfo = (String[])cliinf;
	if(livres != null){
		LesLivres = (Books[])livres;
		size = LesLivres.length;
	}
	
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
	              <li><b>Bienvenue <%=clientInfo[2] %>,</b> &nbsp;&nbsp;&nbsp;<a href="logout.jsp"><u>D�connexion</u></a></li>
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
              Title: <input name="title" type="text" value="" class="text" style="width:100px" /> &nbsp;
              Author: <input name="author" type="text" value="" class="text" style="width:100px" /> &nbsp;
              <input type="submit" value="Go" class="submit" />
              <input type="hidden" id="action" name="action" value="1" />
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
					<font color="blue"><b>R�sultats de la recherche dans la cat�gorie</b>&nbsp;&nbsp; GESTION</font>
			   </h2>
			   <hr />
             <table cellspacing="4" cellpadding="0">
                  <tr>
                      <td><a href="">Crise financi�re et balses III</a>    de <b>Steven</b></td><td></td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b>Description:</b>  Ce livre a �t� fait pour aidertous les financier;</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Nonbre disponibles:</u></b>  3</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Prix:</u></b>  15.5 euro
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      		<form id="panierAdd" name="panierAdd" action="controller" method="post" style="float:right">
                      			<input type="button" id="panier_add" name="panier_add" 
                      			value="Ajouter au panier" style="width:120px; size:2px"/>
                      			<input type="text" id="nbre" name="nbre" 
                      			style="width:20px; size:2px"/>
                      			<input type="hidden" value="id di livre" id="idLivre" name="idLivre" />
                      		</form>
                      </td>
                      
                  </tr>
                  
                  <tr>
                      <td>&nbsp;&nbsp;<hr/></td>
                  </tr>
                  
                  <tr>
                      <td><a href="">Finances de march�s</a>    de <b>Steven</b></td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b>Description:</b>  Ce livre a �t� fait pour les �tudiants principalement;</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Nonbre disponibles:</u></b>  3</td>
                  </tr>
                  <tr>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Prix:</u></b>  25 euro
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      		<form id="panierAdd" name="panierAdd" action="controller" method="post" style="float:right">
                      			<input type="button" id="panier_add" name="panier_add" 
                      			value="Ajouter au panier" style="width:120px; size:2px"/>
                      			<input type="text" id="nbre" name="nbre" 
                      			style="width:20px; size:2px"/>
                      			<input type="hidden" value="id di livre" id="idLivre" name="idLivre" />
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
