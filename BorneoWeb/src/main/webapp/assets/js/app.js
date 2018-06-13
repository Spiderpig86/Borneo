/**
 * JavasScript file for Borneo
 */

/* Update navbar with selected page in the UI */
$(function() {
    /* Switch the selected page name */
    switch (selectedPage) {
        case 'About':
            $('#about').addClass('active');
            break;
        case 'Contact Us':
            $("#contact").addClass('active');
            break;
        case 'All Products':
            $('#products').addClass('active');
            break;
        case 'Manage Products':
            $('#manage').addClass('active');
            break;
        default:
            if (selectedPage === "Home") break;
            $('#products').addClass('active');
            // $('$a_' + selectedPage).addClass('active');
            break;
    }

    var table = $('#productListTable'); // Get table from page

    // Execute only if the table exists and has elements
    if (table.length) {

        // Set the url source for table to pull from
        var jsonUrl = '';
        if (window.categoryId === '')
            jsonUrl = window.contextRoot + '/json/data/all/products';
        else
            jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products'; // Dynamic id

        console.log(jsonUrl);

        // Construct our data table
        table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 Items', '5 Items', '10 Items', 'All Items']], // Configure options for display
            pageLength: 5, // Show 5 entries by default
            ajax: { // Object for data to query
                url: jsonUrl,
                dataSrc: '', // The main object has no name since it is an
                // array of objects
            },
            columns: [ // Setup table columns
                {
                    data: 'code', // Code for image url
                    mRender: function(data, type, row) {
                        return '<img class="dataTableImg" src="' + window.contextRoot + '/resources/img/' + data + '.jpg" />';
                    }
                },
                {
                    data: 'name', // Name of column
                },
                {
                    data: 'brand' // These names match the object properties
                    // from the requests
                },
                {
                    data: 'unitPrice',
                    mRender: function(data, type, row) {
                        return '$ ' + data; // Return the data as string
                        // prefixed with '$'
                    }
                },
                {
                    data: 'quantity',
                    mRender: function(data, type, row) {
                        // Show out of stock if less than 1
                        if (data < 1)
                            return '<span style="color:red">Out of stock!</span>'

                        return data; // Otherwise return regularly
                    }
                },
                {
                    data: 'id',
                    bSortable: false, // Hide sort button for column
                    mRender: function(data, type, row) { // Render the new
                        // buttons for viewing item and adding to cart
                        // data is id, row is informatoon on entire record
                        // or item
                        var str = '';
                        str += '<a class="btn btn-primary" href="' + window.contextRoot + '/show/' + data + '/product"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'

                        if (row.quantity < 1) {
                            str += '<a class="btn btn-success disabled"' +
                                ' href="javascript:void(0)"><span' +
                                ' class="glyphicon glyphicon-shopping-cart"></span></a>'
                        } else {
                            str += '<a class="btn btn-success" href="' + window.contextRoot + '/cart/add/' + data + '/product"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
                        }

                        return str; // Render these buttons
                    }
                }
            ]
        });
    }
});