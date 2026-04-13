$(function() {
    $('.modal-footer .btn-success').on("click", function() {
        $('#todoForm').submit(); 
    });

    $('#todoForm').on("submit", function(e) {
        e.preventDefault();

        const $form = $(this);
        
        $.ajax({
            url: $form.attr("action"),
            type: "POST",
            data: {
                title: $form.find('input[name="title"]').val(),
                description: $form.find('input[name="description"]').val()
            }
        })
        .done(function(data){
            // テーブルの tbody に新しい行を追加（dataはサーバーから返ってきたHTML断片を想定）
            $("table tbody").append(data);
            
            // 入力欄をリセットしてモーダルを閉じる
            $form[0].reset();
            $('#todoAdd').modal('hide');
        })
        .fail(function(){
            alert("エラーが発生しました。");
        });
    });
});

