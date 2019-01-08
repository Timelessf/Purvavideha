<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发帖展示表</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.90so.net/layui/2.4.5/css/layui.css">
    <script src="https://cdn.bootcss.com/vue/2.5.21/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.90so.net/layui/2.4.5/layui.js" media="all"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
    <link href="https://cdn.bootcss.com/layer/2.3/skin/layer.css" rel="stylesheet">
    <style>
        input.error{
            border: 1px solid #E6594E;
        }
    </style>
</head>
<body>
<div id="app" class="container">
    <form class="form-inline bg-danger" role="form">
        查询条件
        <div class="form-group">
            <label class="sr-only" for="userName">帖子名称</label>
            <input type="text" class="form-control" id="userName" placeholder="用户名称">
        </div>
        <#--
        <div class="form-group">
            <label class="sr-only" for="userAge">用户年龄</label>
            <input type="text" class="form-control" id="userAge" placeholder="用户年龄">
        </div>
        -->
        <button type="button" id="findUser" class="btn btn-success">查询帖子</button>
        <button type="button" id="addUserBtn" class="btn btn-danger">我要发布</button>
    </form>

    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr class="success">
                <td>编号</td>
                <td>发帖类型</td>
                <td>发帖标题</td>
                <td>发帖内容</td>
                <td>发帖标签</td>
                <td>发帖时间</td>
            </tr>
            </thead>
            <tbody>
            <tr class="active" v-for="(item,index) in result">
                <td>{{index+1}}</td>
                <td>{{item.postType}}</td>
                <td>{{item.postTitle}}</td>
                <td>{{item.postContent}}</td>
                <td>{{item.postLabel}}</td>
                <td>{{item.postTime}}</td>
                <td><a href="#" @click="delEvent(item.postId)">删除</a></td>
            </tr>
            </tbody>
            <tr>
                <td colspan="3">
                    <div id="pagenav"></div>
                </td>
            </tr>
        </table>

    </div>
</div>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            result: []
        }
    });
    //查询用户数据
    var getUserPageList = function (curr) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/getPostedPage",
            data: {
                pageCurrent: curr || 1,
                pageSize: 5,
            },
            success: function (msg) {
                console.log(msg.totalPage);
                app.result = msg.page;
                layui.use(['laypage', 'layer'], function () {
                    var laypage = layui.laypage,
                        layer = layui.layer;
                    laypage.render({
                        elem: 'pagenav', //容器仅支持原生dom对象jquery对象   id名
                        count: msg.totalPage, //总页数
                        first: '首页',
                        last: '尾页',
                        limit: 5,
                        skip: true,
                        curr: curr || 1, //当前页

                        jump: function (obj, first) { //触发分页后的回调

                            if (!first) { //点击跳页触发函数本身，并传递当前页obj.curr

                                getUserPageList(obj.curr);
                            }
                        }
                    });

                })

            }
        });
    }

    getUserPageList();

    //查询用户事件

    $('#findUser').on('click', function () {
        getUserPageList();
    });

    //增加发帖事件

    $('#addUserBtn').on('click', function () {
        layer.open({
            type: 2,
            title: '新增用户',
            fix: false,
            maxmin: true,
            shadeClose: true,
            area: ['300px', '350px'],
            content: '/addPosted',
            end: function (msg) {
                getUserPageList();
                layer.msg('新增成功!!!' + msg, {icon: 6});
            }
        });

    });

    //删除帖子事件
    var delEvent = function(postId) {
        //询问框
        layer.confirm('刀下留人!!!', {
            btn : ['你求我啊!!!']
            //按钮
        }, function() {
            //是
            $.ajax({
                type : "GET",
                dataType : "json",
                url : "/deletePosted",
                data : {
                    postId:postId
                },
                success : function(msg) {
                    getUserPageList();
                    layer.msg('删除成功!!!' + postId,{icon:5});
                }
            });

        }, function() {
            //否

        });
    }



</script>


</body>
</body>
</html>