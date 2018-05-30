<%--
  Created by IntelliJ IDEA.
  User: slim1
  Date: 3/14/2018
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- TAGLIBS - for importing other JSP modules -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Allows
us to use Java tags in our JSP -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> <!--
Allows us to use spring URL elements for our paths -->

<!-- SPRING URL OBJECTS -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="img" value="/resources/img" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" /> <!--
Store the path in a variable called contextRoot for the base directory -->


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Stanley Lim">

        <title>Borneo - ${title}</title>

        <!-- Bootstrap core CSS -->
        <link href="${css}/bootstrap.min.css" rel="stylesheet">

        <!-- Pulse Bootstrap Theme -->
        <link href="${css}/pulse.min.css" rel="stylesheet" />

        <!-- Datatables CSS -->
        <link href="${css}/dataTables.bootstrap.min.css" rel="stylesheet" />

        <!-- Glyphicons -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css" rel="stylesheet">

        <!-- Cirrus -->
        <link href="${css}/cirrus.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="${css}/borneo.css" rel="stylesheet">

    </head>

    <body>

        <div class="wrapper">

            <!-- Navigation -->
            <%@include file="./shared/navbar.jsp"%>

            <!-- Page Content -->
            <div class="content">

                <!-- Load the home page content only when the user clicks home (variable
                stored in controller) -->
                <c:if test="${ userClickHome == true }">
                    <%@include file="home.jsp"%> <!-- Render homepage content
                </c:if>

                <!-- Load only when the user clicks the about page -->
                <c:if test="${ userClickAbout == true }">
                    <%@include file="about.jsp"%> <!-- Render about content
                </c:if>

                <!-- Load only when the user clicks the contact page -->
                <c:if test="${ userClickContact == true }">
                    <%@include file="contact.jsp"%> <!-- Render contact content -->
                </c:if>

                <!-- Load only when the user clicks the contact page -->
                <c:if test="${ userClickAllProducts == true or userClickCategoryProducts == true }">
                    <%@include file="listproducts.jsp"%> <!-- Render contact
                    content -->
                </c:if>

                <!-- Load only when the user clicks button to show single
                product -->
                <c:if test="${ userClickShowProduct == true }">
                    <%@include file="singleproduct.jsp"%> <!-- Render contact
                    content -->
                </c:if>
            </div>

            <!-- Footer -->
            <%@include file="./shared/footer.jsp"%>

            <!-- /.container -->
        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="${js}/jquery.min.js"></script>
        <script src="${js}/bootstrap.bundle.min.js"></script>

        <!-- Datatable Plugin -->
        <script src="${js}/jquery.dataTables.min.js"></script>

        <!-- Datatable Theme -->
        <script src="${js}/dataTables.bootstrap4.min.js"></script>

        <!-- Script to store active menu -->
        <script>
            window.selectedPage = '${title}'; // Title from page controller
            window.contextRoot = '${contextRoot}'; // Expose context root to DOm
        </script>
        <script async src="${js}/app.js"></script>

    </body>

</html>
