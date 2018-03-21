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
        default:
            $('#home').addClass('active');
    }
});