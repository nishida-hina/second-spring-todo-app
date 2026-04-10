$(function() {
    $('#todoForm').on("submit", function(e) {
        e.preventDefault();

        $.ajax({
            url: $(this).attr("action"),
            type: "POST",
            data: {
                title: $("#title").val()
            }
        })
		.done(function(data){
			$(".todos").append(`<div>${data}</div>`);
			$("#title").val("");
		})
		.fail(function(){
			alert("error!");
		})
    });
})
