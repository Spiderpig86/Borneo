<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> <!--
Allows us to use tag library for spring forms -->
<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4>Product Management</h4>
                </div>
                <div class="panel-body">
                    <!-- FORM ELEMENTS -->
                    <sf:form class="form-horizontal" modelAttribute="product">
                        <!-- Spring form with product as the form's model -->
                        <div class="form-group">
                            <label class="control-label col-md-4"
                                   for="name">Enter Product Name: </label>
                            <div class="col-md-8">
                                <sf:input type="text" path="name" id="name"
                                       placeholder="Product Name"
                                       class="form-control"/> <!-- Set path
                                       to name to refer to name of product -->
                                <em class="help-block">Please enter a product
                                name.</em>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4"
                                   for="name">Enter Brand Name: </label>
                            <div class="col-md-8">
                                <sf:input type="text" path="brand" id="brand"
                                       placeholder="Brand Name"
                                       class="form-control"/>
                                <em class="help-block">Please enter a brand
                                    name.</em>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Description</label>
                            <div class="col-md-8">
                                <sf:textarea path="description" class="form-control"
                                             placeholder="Enter your description here!" />
                                <sf:errors path="description" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Unit Price</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="unitPrice" class="form-control"
                                          placeholder="Enter Unit Price" />
                                <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Quantity</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="quantity" class="form-control"
                                          placeholder="Enter Quantity" />
                                <sf:errors path="quantity" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Category</label>
                            <div class="col-md-8">
                                <sf:select path="categoryId" class="form-control"
                                   items="${categories}"
                                   itemLabel="catName"
                                   itemValue="id"
                                /> <!-- Just display all categories with name
                                 and id -->

                                <div class="text-right">
                                    <br/>
                                    <sf:hidden path="id"/> <!-- Hidden field
                                    so we can set it later in our object -->
                                    <sf:hidden path="code"/>
                                    <sf:hidden path="supplierId"/>
                                    <sf:hidden path="active"/>
                                    <sf:hidden path="views"/>
                                    <sf:hidden path="purchases"/>
                                    <button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myCategoryModal">Add New Category</button>
                                </div>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="col-md-8 col-md-offset-4">
                                <input type="submit" name="submit" id="submit"
                                       value="Submit"
                                       class="btn btn-primary">
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>