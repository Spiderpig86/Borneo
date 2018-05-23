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
        default:
            if (selectedPage === "Home") break;
            $('#products').addClass('active');
            $('$a_' + selectedPage).addClass('active');
            break;
    }

    /* Fill in dummy data for data table */
    var products = [
        ['1', 'ABC'],
        ['2', 'CYX'],
        ['3', 'PQR'],
        ['4', 'MNO'],
        ['5', 'WVB'],
        ['6', 'CFG'],
        ['7', 'HIK'],
        ['8', 'LMP']
    ];

    var table = $('#productListTable'); // Get table from page

    // Execute only if the table exists and has elements
    if (table.length) {
        // Construct our data table
        table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 Items', '5 Items', '10 Items', 'All Items']], // Configure options for display
            pageLength: 5, // Show 5 entries by default
            data: products, // The data set to get
        });
    }
});