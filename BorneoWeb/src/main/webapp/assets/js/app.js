/**
 * JavasScript file for Borneo
 */

/* Update navbar with selected page in the UI */
$(function() {
    /* Switch the selected page name */
    console.log(selectedPage);
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
            $('#home').addClass('active');
            $('#products').addClass('active');
            $('$a_' + menu).addClass('active');
            break;
    }
});