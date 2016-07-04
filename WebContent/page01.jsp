<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> Select Table </title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/myStyle.css" rel="stylesheet">

<script>
function retainValue(){
	var radio = sessionStorage.getItem("name");
	if(radio == "undefined") {
		document.getElementById("Student").checked = true;
	} else {
		document.getElementById(radio).checked = true;
	}
}
function setRadioValue(){
	var radio = document.querySelector('input[name="name"]:checked').value;
	sessionStorage.setItem("name", radio);
}
</script>
</head>
<body onload="retainValue()">
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
    
<form action="ManagerC" method="post">
	<input type="hidden" name="action" value="add"/>
	<fieldset>
	<legend> Choose Table : </legend>
	<c:set var="tablelists" value='${requestScope.tablelist}'/> 
	<c:set var="lists" value='${requestScope.lists}'/> 
    <c:set var="colNames" value='${requestScope.colNames}'/> 
	<c:forEach var="table" items="${tablelists}">
		<input type="radio" name="name" id="${table}" value="${table}" onclick="setRadioValue()"> ${table}
	</c:forEach>
	</fieldset>
	<br>
	<div>
		<select name="order" size="5">
		  <c:forEach var="colName" items="${colNames}">
		  	<option value="${colName}"> ${colName} </option>
		  </c:forEach>
		</select>
		<input type="submit"  value="Sort" name="sort" />
	</div><br>
	<input type="submit"  value="Refresh" name="refresh" />
	<input type="submit"  value="Clear"  name="clear"/>
</form>
<br>
<div id="showtable" >
<table>
  <tr>
    <td>
       <div style="width:450px; height:200px; overflow:auto;">
         <table  border="1" >
		 <tr>
		 	<c:forEach var="colName" items="${colNames}">
		 		<th><c:out value="${colName}"/></th>
		 	</c:forEach>
         </tr>
         <c:if test="${empty lists}">
			<tr>
				<td colspan="4" align="center"> Not exist any table's list. </td>
			</tr>
		 </c:if>
		<c:forEach var="datas" items="${lists}">
			<tr>
				<c:forEach var="colName" items="${colNames}" varStatus="status">
					<!-- c:set var="col" value="${fn:toLowerCase(colName)}" /-->
					<td>${datas.get(colName) }</td>
		 		</c:forEach>
			</tr>
		</c:forEach>
         </table>  
       </div>
    </td>
  </tr>
</table>
</div>
  <!-- jQuery Version 1.11.1 -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>
</body>
</html>