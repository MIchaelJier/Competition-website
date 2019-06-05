$(function() {
    var pageW = parseInt($('.playContent').width());
    var pageH = parseInt($('.playContent').height());
    var s_w = parseInt($('.string').width());
    var boxDom = $(".playContent");
    console.log(pageW + ' ' + pageH);
    var btnDom = $(".barrage button");
    var Top, Right;
    var width;
    width = pageW;
    var colorArr = ["#cfaf12", "#12af01", "#981234", "#adefsa", "#db6be4", "#f5264c", "#d34a74"];
    btnDom.bind("click", auto);
    document.onkeydown = function(e) {
        if (e.keyCode == 13) {
            auto();
        }
    };
    function auto() {
        var creSpan = $("<span class='string'></span>");
        var text = $("#text").val();
        creSpan.text(text);
        $("#text").val("");
        Top = parseInt(pageH * (Math.random()));
        var num = parseInt(colorArr.length * (Math.random()));
        if(Top < 48){Top = 48}
        if (Top > pageH/2) {
            Top = pageH/2;
        }
        creSpan.css({
            "top": Top,
            "right": -pageW/3, //-pageW/4
            "color": getRandomColor()
        });
        boxDom.append(creSpan);
        var spanDom = $(".playContent>span:last-child");
        spanDom.stop().animate({
            "right": pageW //pageW/1.36
        }, 10000, "linear", function() {
            $(this).remove();
        });
    }
    function getRandomColor() {
        return '#' + (function(h) {
            return new Array(7 - h.length).join("0") + h
        })((Math.random() * 0x1000000 << 0).toString(16));
    }
});
