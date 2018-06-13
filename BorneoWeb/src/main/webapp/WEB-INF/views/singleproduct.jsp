<%--
  Created by IntelliJ IDEA.
  User: slim1
  Date: 5/29/2018
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <!-- Breadcrumb -->
    <div class="row">
        <div class="col-xs-12">
            <ol class="breadcrumb">

                <li><a href="${contextRoot}/home">Home</a></li>
                <li><a href="${contextRoot}/show/all/products">Products</a></li>
                <li class="active">${product.name}</li>

            </ol>
        </div>
    </div>

    <!-- Display the product -->
    <div class="row">

        <!-- Product image -->
        <div class="col-xs-12 col-sm-4">
            <div class="thumbnail">
                <img src="${img}/${product.code}.jpg"
                     class="img img-responsive" />
            </div>
        </div>

        <!-- Display description -->
        <div class="col-xs-12 col-sm-8">
            <h3>${product.name}</h3>
            <hr />

            <p>${product.description}</p>
            <hr />

            <h4>Price: $<strong>${product.unitPrice}</strong></h4>
            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <!-- When the quantity is less than 1, display out of
                    stock -->
                    <h6>Qty. Available:
                        <span style="color: red">Out of stock!</span></h6>

                    <a href="#"
                       class="btn btn-success disabled"><strike>
                        <span class="glyphicon glyphicon-shopping-cart"></strike></span>
                        Add to Card
                    </a>
                </c:when>
                <c:otherwise>
                    <!-- There are products available -->
                    <h6>Qty. Available: ${product.quantity}</h6>

                    <!-- Add to card button -->
                    <a href="${contextRoot}/card/add/${product.id}/product"
                       class="btn btn-success">
                        <span class="glyphicon glyphicon-shopping-cart"></span>
                        Add to Card
                    </a>
                </c:otherwise>
            </c:choose>
            <a href="${contextRoot}/card/add/${product.id}/product"
               class="btn btn-success">
                Back
            </a>
        </div>

    </div>

</div>
