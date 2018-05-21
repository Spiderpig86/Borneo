<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: slim1
  Date: 5/15/2018
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> <!--
Allows us to use spring URL elements for our paths -->
<spring:url var="js" value="/resources/js" />
<html>
    <body>
        <div class="container">
            <div class="row">
                
                <!-- Display the sidebar -->
                <div class="col-md-3">
                    <%@include file="shared/sidebar.jsp" %>
                </div>
                
                <!-- Display the products -->
                <div class="col-md-9">

                    <!-- Breadcrumb component -->
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- Show breadcrumb for all products page -->
                            <c:if test="${userClickAllProducts == true}">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="${contextRoot}/home">
                                        Home</a></li>
                                    <li class="breadcrumb-item active">All
                                        Products</li>
                                </ol>
                            </c:if>

                            <!-- Show breadcrumb for category specific page -->
                            <c:if test="${userClickCategoryProducts == true}">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="${contextRoot}/home">
                                        Home</a></li>
                                    <li class="breadcrumb-item active">
                                        Category</li>
                                    <li class="breadcrumb-item
                                    active">${category.catName}</li>
                                </ol>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            window.selectedPage = '${title}'; // Title from page controller
        </script>
        <script async src="${js}/app.js"></script>
    </body>
</html>
