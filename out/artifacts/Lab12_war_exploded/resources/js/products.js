$(function () {
    //$("#btn-add-to-cart").click = addToCart;

    function addToCart() {
        $.ajax({
            type: "post",
            url: "/path",
            data: "email=" + $('#email').val(),
            success: function(msg){

            }
        });
    }
})();