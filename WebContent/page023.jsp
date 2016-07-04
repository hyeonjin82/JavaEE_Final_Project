<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> Update Table </title>

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
    
      <div>
    	<h1> Welcome to update FoodService Table </h1>	
    	<h4> Enter foodservice information here</h4>
		<form action="ManagerC" method="post">
		<input type="hidden" name="action" value="update"/>
		<input type="hidden" name="table" value="foodservice"/>
	    <div>
		<label>Name:</label>
		<input type="text" name="name"/>
		</div>
		<div>
		<label>Category:</label>
		<input type="text" name="category"/>
		</div>
		<div>
		<label>Rate:</label>
		<input type="text" name="rate"/>
		</div>
		<br>
	    <div>
			<input type="submit"  value="insert" name="addButton" />
			<input type="submit"  value="update" name="updateButton" />
			<input type="submit"  value="delete" name="deleteButton" />
			<input type="reset"  value="reset"  />
		</div>
		</form>
    </div>
    
  <!-- jQuery Version 1.11.1 -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>
</body>
</html>