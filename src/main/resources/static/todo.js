$('#todoForm').submit(function(e){
    e.preventDefault(); 

    $.ajax({
        url: $(this).attr("action"),
        type: "POST",
        data: {
            title: $("#title").val()
        },
        success: function(todo){
            $("#todoList").append(`<li>${todo}</li>`)
        },
        error: function(){
            console.log("エラー");
        }
    });
});