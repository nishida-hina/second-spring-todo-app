$(function() {
    //  新規追加（フォーム送信）の処理
    $('#todoForm').on("submit", function(e) {
        e.preventDefault(); // 画面リロードを阻止

        const $form = $(this);
        
        $.ajax({
            url: $form.attr("action"),
            type: "POST",
            data: $form.serialize() 
        })
        .done(function(data) {
            addRow(data);
            $form[0].reset();
            $('#todoAdd').modal('hide');
        })
        .fail(function() {
            alert("保存に失敗しました。");
        });
    });


    // ステータス変更（トグル切り替え）の処理
    $(document).on('change', '.status-toggle', function() {
        const todoId = $(this).data('id');  
        const isChecked = $(this).prop('checked'); 
        const newStatus = isChecked ? 1 : 0;      

        $.ajax({
            url: '/todo/updateStatus', 
            type: 'POST',
            data: {
                id: todoId,
                status: newStatus
            }
        })
        .done(function() {
            console.log("Status updated: " + newStatus);
        })
        .fail(function() {
            alert("更新に失敗しました。");
        });
    });

 
    // 行を追加
   function addRow(todo) {
      
        const isChecked = todo.status === 1 ? 'checked' : '';

       
        const html = `
            <tr>
                <td style="width: 70px;">${todo.task_id}</td>
                <td style="width: 20%;">${todo.title}</td>
                <td>${todo.description}</td>
                <td style="width: 200px;">
                    <input type="checkbox" 
                           class="status-toggle"
                           ${isChecked} 
                           data-toggle="toggle" 
                           data-off="未完了" 
                           data-on="完了" 
                           data-onstyle="success" 
                           data-offstyle="secondary"
                           data-id="${todo.task_id}">
                </td>
            </tr>`;

       
        const $newRow = $(html);
        $("table tbody").append($newRow);
        
      
        $newRow.find('.status-toggle').bootstrapToggle();
    }
});