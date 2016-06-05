$(".navbar-fixed-top").each(function () {

    var $window = $(window),
        $header = $(this),
        headerOffsetTop = $header.offset().top;
    
    $window.on("scroll", function () {
        if ($window.scrollTop() > headerOffsetTop) {
            $header.addClass("sticky");
            $(".navbar-fixed-top a").css("color", "black");
        } else {
            $header.removeClass("sticky");
            $(".navbar-fixed-top a").css("color", "white");
        }
    });

    $window.trigger("scroll");
});

$("#typo").typoShadow();