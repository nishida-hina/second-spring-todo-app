$(function() {
    // ==========================================
    // 新規追加（フォーム送信）の処理
    // ==========================================
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

    // ==========================================
    // 削除ボタン
    // ==========================================
	$(document).on('click', '.delete-btn', function() {
	    const todo_id = $(this).data('id');
	    const $row = $(this).closest('tr');

	    // モーダル内の削除実行ボタンに「ID」と「行オブジェクト」を両方保存
	    $('#deleteBtn').data('todo-id', todo_id);
	    $('#deleteBtn').data('row', $row); 

	    $("#todoDelete").modal('show');
	});

    //	削除ボタン処理
	$('#todoDeleteForm').on("submit", function(e) {
	    e.preventDefault();

	    const $Deleteform = $(this);
	    // 保存しておいたIDを取得
	    const todoId = $('#deleteBtn').data('todo-id');

	    $.ajax({
	        url: $Deleteform.attr("action"),
	        type: "GET",
	        data: {
	            todo_id: todoId
	        }
	    })
	    .done(function() {
	        // 保存しておいた「行」を取り出して削除
	        const $targetRow = $('#deleteBtn').data('row');
	        if ($targetRow) {
	            $targetRow.remove();
	        }
	        $('#todoDelete').modal('hide');
	    })
	    .fail(function() {
	        alert("削除に失敗しました。");
	        $('#todoDelete').modal('hide');
	    });
	});

    // ==========================================
    // ステータス変更（トグル切り替え）の処理
    // ==========================================
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


    // ==========================================
    // 行を追加する関数
    // ==========================================
    function addRow(todo) {
        const isChecked = todo.status === 1 ? 'checked' : '';
        const deleteBtn = (todo.deleteFlg === 0) ? `` : '';
        const html = `
	        <tr>
	            <td style="width: 70px;">${todo.taskId}</td>
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
	                       data-id="${todo.taskId}">
	            </td>
				<td class="text-center align-middle">
				            ${deleteBtn}
					<button
							class="btn btn-danger delete-btn"
							data-id="${todo.taskId}">
							削除
					</button>
				 </td>
	        </tr>`;


        const $newRow = $(html);
        $("table tbody").append($newRow);


        $newRow.find('.status-toggle').bootstrapToggle();
    }
});