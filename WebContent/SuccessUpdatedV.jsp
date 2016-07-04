<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> Success </title>

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
    
	<h1>Success to update the data into the table</h1><br>
	<c:url value="./pagescontrol.jsp" var="pages0">
	   <c:param name="command" value="page00"></c:param>
	</c:url>
	<a href = "${pages0}"> Assignment3 Home </a><br/>
  	<!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>