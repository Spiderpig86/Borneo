<h1 class="my-4">Shop Name</h1>
<div class="list-group">

    <!-- Iterate over all the categories that we have -->
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/show/category/${category.id}/products"
           class="list-group-item">${category.catName}</a>
    </c:forEach>
</div>