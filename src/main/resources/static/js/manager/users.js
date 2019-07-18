/**
 * Created by daixueyun on 2019/7/18 0018.
 */
function edit(e) {
    flag = "edit";
    $("#flag").val(flag);

    var id = $(e).closest(".trUser").find(".id").text();
    console.log(id);

    $.ajax({
        type: 'post',
        url: 'findOneById',
        dataType: 'json',
        data:{
            id: id
        },
        async: false,
        success: function (data) {
            if(data.success){
                $(".editBg").toggle();
                $("#id").val(data.obj.id);
                $("#userName").val(data.obj.userName);
                $("#advantage").val(data.obj.advantage);
            }else{
                alert(data.msg);
            }
        }
    });
}

/**
 * 重置
 */
function resetUser() {
    $("input[type=reset]").trigger("click");
}

function fresh() {
    window.location.href="showUsers";
}

function editSubmit() {
    $.ajax({
        type: 'post',
        url: 'editUser',
        dataType: 'json',
        data: $("#editForm").serialize(),
        async: false,
        success: function (data) {
            if(data.success){
                $(".editBg").toggle();
                resetUser();//清空编辑框
                fresh();//刷新列表
            }
        }
    });
}

function add() {
    flag = "add";
    $("#flag").val(flag);

    $(".editBg").toggle();

}

function del(e) {
    var id = $(e).closest(".trUser").find(".id").text();
    console.log(id);

    $.ajax({
        type: 'post',
        url: 'deleteUser',
        dataType: 'json',
        data:{
            id: id
        },
        async: false,
        success: function (data) {
            if(data.success){
                fresh();
            }
        }
    });
}