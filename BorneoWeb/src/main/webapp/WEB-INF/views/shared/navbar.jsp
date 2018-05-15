<%--
  Created by IntelliJ IDEA.
  User: slim1
  Date: 3/16/2018
  Time: 2:53 PM
  This is the navbar of the store. Will be included in a bunch of other pages.
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Borneo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id="home" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li id="products" class="nav-item">
                    <a class="nav-link"
                       href="${contextRoot}/show/all/products">View Products
                    </a>
                </li>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/contact">Contact
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
