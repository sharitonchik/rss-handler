$(document).ready(function() {
    $(':radio').click(function() {
        var path = "/rss?news=";
        $('#content').attr('src', path + $(this).val());
//        var dataObject = {};
//        dataObject[$(this).attr('name')] = $(this).val();
//        $.ajax({
//                    url:"/rss",
//                    contentType:"text/html",
//                    data:dataObject
//                }).success(function(response) {
//                    $('#content').html(new XMLSerializer().serializeToString(response));
//                });
    });
});