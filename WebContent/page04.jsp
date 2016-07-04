<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> About Me </title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/myStyle.css" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 <c:url value="./pagescontrol.jsp" var="pages0">
                	<c:param name="command" value="page00"></c:param>
                </c:url>
                <a class="navbar-brand" href="${pages0}">JJ_Assignment</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                     <li>
                	    <c:url value="./pagescontrol.jsp" var="pages1">
              			  	<c:param name="command" value="page01"></c:param>
               			 </c:url>
                        <a href="${pages1}">Show Tables</a>
                    </li>
                    <li>
                    	<c:url value="./pagescontrol.jsp" var="pages2">
              			  	<c:param name="command" value="page02"></c:param>
               			 </c:url>
                        <a href="${pages2}">Update Tables</a>
                    </li>
                    <li>
                    	<c:url value="./pagescontrol.jsp" var="pages3">
              			  	<c:param name="command" value="page03"></c:param>
               			 </c:url>
                        <a href="${pages3}">Create Tables</a>
                    </li>
                    <li>
                   		 <c:url value="./pagescontrol.jsp" var="pages4">
              			  	<c:param name="command" value="page04"></c:param>
               			 </c:url>
                        <a href="${pages4}">About</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
   <div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-2">
        	<h1> About Me </h1>
        	<ul>
        		<li>My name is Hyeonjin Lee.</li>
        		<li>I am studying on System Analyst course in Sheridan College</li>
        		<li>It is third semester now.</li>
        	</ul>
        	<h4> Version of This Enterprise </h4>
        	<p> <strong> Jin 1.0.0  on Oct 31, 2015</strong> </p>
        	<br>
            <p>Contact us using the form below </p>
            <p>Tell us what you think of the site, or just say hello ~ ^^ </p>
            <form class="form" method="post" action="PageManagerC">
            <input type="hidden" id="hidden" name="command" value="thankyou" />
                <div class="form-group">
                    <label for="name" class="col-lg-2 control-label">Name</label>
                    <div class="col-lg-3">
                        <input type="text" class="form-control" id="username" name="username" placeholder="First & Last Name" value="">
                       
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-3">
                        <input type="email" class="form-control" id="email" name="email" placeholder="example@domain.com" value="">
                        
                    </div>
                </div>
                <div class="form-group">
                    <label for="message" class="col-lg-2 control-label">Message</label>
                    <div class="col-lg-3">
                        <textarea class="form-control" rows="4" name="message"></textarea>
                        
                    </div>
                </div>
                <div class="form-group">
                    <label for="human" class="col-lg-2 control-label">2 + 3 = ?</label>
                    <div class="col-lg-3">
                        <input type="text" class="form-control" id="human" name="human" placeholder="Your Answer">
                        
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-3 col-lg-offset-2">
                        <input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-3 col-lg-offset-2">
                       	
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
    
  <!-- jQuery Version 1.11.1 -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>
  
</body>
</html>