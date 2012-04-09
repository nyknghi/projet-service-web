<%@ page session="true" language="java" import="java.util.*, facade.*"
	pageEncoding="ISO-8859-1"%>
<%
	Object le_user = session.getAttribute("user");
	
	if (le_user == null) {
%>
<jsp:forward page="login.jsp" />
<%
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
              <li><a href="findBooks.jsp?categorie='scolaires'">scolaires</a></li>
              <li><a href="contact.jsp">contact</a></li>
          </ul>
      </div><!-- end menu -->
      <div id="header">
          <ul id="navtop">
              <li><a href="findBooks.jsp?categorie='kids'">Livres enfants</a></li>
              <li><a href="findBooks.jsp?categorie='adults'">Adultes</a></li>
              <li><a href="findBooks.jsp?categorie='science'">Science</a></li>
              <li><a href="findBooks.jsp?categorie='commerce'">Commerce</a></li>
              <li><a href="findBooks.jsp?categorie='litterature'">Litt&eacute;rature</a></li>
          </ul>
          <h2><img src="images/title_explore.gif" width="185" height="20" alt="explore your knowledge" /></h2>
		  <div class="exploretext">
			  <ul id="explore">
				  <li><a href="http://www.freewebsitetemplates.com">get online tutorials</a></li>
				  <li><a href="http://www.freewebsitetemplates.com">books for all age</a></li>
				  <li><a href="http://www.freewebsitetemplates.com">grab the  encyclopedia</a></li>
			  </ul>
		  </div>
          <div id="books"></div>
          <div id="girl"></div>
      </div><!-- end header -->
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
                  <li><a href="http://www.freewebsitetemplates.com">Biography</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Children's</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Crime &amp; Thrillers</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Food &amp; Drink</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">General Fiction</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Health</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">History</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Home &amp; Garden</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Science</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Romantic Fiction</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">SF &amp; Fantasy</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Sport</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Entertainment</a></li>
              </ul>
          </div><!-- end .nav -->
          
          <div class="col">
              <div id="authormonth">
                  <h2><img src="images/title_author_of_the_month.gif" width="137" height="15" alt="author of the month" /></h2>
                  <p>Don't forgot to check <a href="http://www.freewebsitetemplates.com">free website templates</a> every day, because we add at least one free website template daily.</p>
				
			
                  <img src="images/picture_1.jpg" width="71" height="133" alt="Woman reading a book" class="left" />
                 	<p>This is a template designed by free website templates for you for free you can replace all the text by your own 
				text. This is just a place holder so you can see how the site would look like.</p> 
				
			
                  <p class="readmore"><a href="http://www.freewebsitetemplates.com">read more</a></p>
              </div><!-- end authormonth -->
              <div id="bookmonth">
                  <h2><img src="images/title_book_of_the_month.gif" width="125" height="15" alt="book of the month" /></h2>
                  <img src="images/picture_3.jpg" width="57" height="85" alt="dog books" class="left" />
                	<p>You can remove any link to our websites from this template you're  free to use the template without linking 
				back to us. Don't want your boss to know you used a free website template ;) .</p>
				
				<p>If you're having problems editing the template please don't hesitate to ask for help on the <a href="http://www.freewebsitetemplates.com/forum/">forum</a>.</p>
				
				
                  <p class="readmore"><a href="http://www.freewebsitetemplates.com">read more</a></p>
              </div><!-- end bookmonth -->
          </div><!-- end .col -->
          <div id="whitey"></div>
          <div class="clear"><div class="fix"></div></div>
      </div><!-- end orangerow -->
      
      <div id="greenrow">
          
          <div class="nav">
              <h2 id="discounts">Discounts On</h2>
              <ul>
                  <li><a href="http://www.freewebsitetemplates.com">Arts and Crafts</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Biography</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Books on TV</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Business</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Children</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Computer Books</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Cookery</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Crime</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Dictionaries</a></li>
                  <li><a href="http://www.freewebsitetemplates.com">Languages</a></li>
              </ul>
          </div><!-- end .nav -->
          
          <div class="col">
              <h2><img src="images/title_book_review.gif" width="94" height="18" alt="book review" /></h2>
              <img src="images/picture_2.jpg" width="79" height="83" alt="Psycho book cover" class="left" />
            <p>If you're looking for beautiful and professionally made templates you can find them at <a href="http://www.templatebeauty.com">Template Beauty</a>.</p>
				<p>To find great hosting providers visit <a href="http://www.webhostingzoom.com">Web Hosting Zoom</a></p>
              <p class="readmore"><a href="http://www.freewebsitetemplates.com">read more</a></p>
                    
              <div class="divider2"></div>
          
              <h2><img src="images/title_books_to_come.gif" width="101" height="14" alt="books to come" /></h2>
              <table summary="book list" class="books" cellspacing="4" cellpadding="0">
                  <tr>
                      <td><a href="http://www.freewebsitetemplates.com">Ghosts of darkness</a></td>
                      <td><a href="http://www.freewebsitetemplates.com">Fifteen</a></td>
                  </tr>
                  <tr>
                      <td><a href="http://www.freewebsitetemplates.com">New age</a></td>   
                      <td><a href="http://www.freewebsitetemplates.com">Quick fox</a></td>
                  </tr>
                  <tr>
                      <td><a href="http://www.freewebsitetemplates.com">Disgrace</a></td>
                      <td><a href="http://www.freewebsitetemplates.com">Unveil</a></td>
                  </tr>
              </table>
             <p>If you're looking for beautiful and professionally made templates you can find them at <a href="http://www.templatebeauty.com">Template Beauty</a>.</p>
          </div>
          <div class="clear"></div>
      </div><!-- end greenrow -->
      
      <div class="footer">
		    <div id="footeri">
		      <p class="lf">&copy; Copyright 2011. &nbsp; &nbsp; R&eacute;alis&eacute; par <a href="index.jsp"> IF_BOOKS CORPORATION</a></p>
		      <div style="clear:both;"></div>
		    </div>
		  </div><!-- end footer -->
  </div><!-- end wrapper -->
</body>
</html>
