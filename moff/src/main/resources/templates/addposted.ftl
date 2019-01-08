<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发布帖子</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.90so.net/layui/2.4.5/css/layui.css">
    <script src="https://cdn.bootcss.com/vue/2.5.21/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.90so.net/layui/2.4.5/layui.js" media="all"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
    <link href="https://cdn.bootcss.com/layer/2.3/skin/layer.css" rel="stylesheet">
    <style>
        input.error {
            border: 1px solid #E6594E;
        }
    </style>
</head>
<body>
<div class="container">

    <form id="addUserForm">
        <h3>发布普通帖子</h3>
        <br/>
        <div class="form-group">
            <input type="text" class="form-control" id="postTitle" name="postTitle" placeholder="请输入标题">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="postContent" name="postContent" placeholder="请输入正文">
        </div>
        <br/>
        <div class="form-group">
            <button type="button" id="saveBtn" class="btn btn-success">提交</button>
            <button type="button" id="cancelBtn" class="btn btn-default">取消</button>
        </div>
    </form>
</div>

<script>
    var addUser = function () {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "addpuposted",
            data: $("#addUserForm").serialize(),
            /* {
                "postTitle": $("#postTitle").val(),
                "postContent": $("#postContent").val()
            },*/
            success: function (msg) {
                $('#cancelBtn').click();

            }
        });
    }

    $('#saveBtn').on('click', function () {
        addUser();
    });
    $('#cancelBtn').on('click', function () {
        var index = parent.layer.getFrameIndex(window.name);
        parent.getUserPageList();
        parent.layer.close(index);
    });

</script>
</body>
</html>