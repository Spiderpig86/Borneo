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
});