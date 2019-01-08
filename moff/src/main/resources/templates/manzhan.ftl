<!--/**
*@BelongsProject: moff
*@BelongsPackage: templates
*@Author: 朱喜亮
*@CreateTime: 2019-01-04 09:45
*@Description:
*@Version: 1.0
*/-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>漫展时间表</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.90so.net/layui/2.4.5/css/layui.css">
    <script src="https://cdn.bootcss.com/vue/2.5.21/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.90so.net/layui/2.4.5/layui.js" media="all"></script>
</head>
<body>
<div id="app">

    <select id="aeEndtime">
        <option value="">未开始漫展</option>
        <option value="now()">已结束漫展</option>
    </select>

    <select id="aetId">
        <option value="0">更多筛选</option>
    </select>

    <select id="aeAddress">
        <option value="">全部地区</option>
        <option value="北京市">北京市</option>
        <option value="天津市">天津市</option>
        <option value="河北省">河北省</option>
        <option value="山西省">山西省</option>
        <option value="内蒙古">内蒙古</option>
        <option value="辽宁省">辽宁省</option>
        <option value="吉林省">吉林省</option>
        <option value="黑龙江省">黑龙江省</option>
        <option value="上海市">上海市</option>
        <option value="江苏省">江苏省</option>
        <option value="浙江省">浙江省</option>
        <option value="安徽省">安徽省</option>
        <option value="福建省">福建省</option>
        <option value="江西省">江西省</option>
        <option value="山东省">山东省</option>
        <option value="河南省">河南省</option>
        <option value="湖北省">湖北省</option>
        <option value="湖南省">湖南省</option>
        <option value="广东省">广东省</option>
        <option value="广西省">广西省</option>
        <option value="海南省">海南省</option>
        <option value="重庆市">重庆市</option>
        <option value="四川省">四川省</option>
        <option value="贵州省">贵州省</option>
        <option value="云南省">云南省</option>
        <option value="西藏">西藏</option>
        <option value="陕西省">陕西省</option>
        <option value="甘肃省">甘肃省</option>
        <option value="青海省">青海省</option>
        <option value="宁夏">宁夏</option>
        <option value="香港">香港</option>
        <option value="澳门">澳门</option>
        <option value="台湾省">台湾省</option>
        <option value="海外">海外</option>
    </select>

    <select id="aeStarttime">
        <option value="">全部时间</option>
        <option value="1">1月</option>
        <option value="2">2月</option>
        <option value="3">3月</option>
        <option value="4">4月</option>
        <option value="5">5月</option>
        <option value="6">6月</option>
        <option value="7">7月</option>
        <option value="8">8月</option>
        <option value="9">9月</option>
        <option value="10">10月</option>
        <option value="11">11月</option>
        <option value="12">12月</option>
    </select>

    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr class="success">
                <td>名字</td>
                <td>logo</td>
                <td>漫展类型</td>
                <td>地区</td>
                <td>地址</td>
                <td>开始时间</td>
                <td>结束时间</td>
            </tr>
            </thead>
            <tbody>
            <tr class="active" v-for="(item,index) in result">
                <td>{{item.aeName}}</td>
                <td>{{item.aeLogo}}</td>
                <td>{{item.aetName}}</td>
                <td>{{item.aeAddress}}</td>
                <td>{{item.aeFulladdress}}</td>
                <td>{{item.aeStarttime}}</td>
                <td>{{item.aeEndtime}}</td>
            </tr>
            </tbody>
            <tr>
                <td colspan="6">
                    <div id="pagenav"></div>
                </td>
            </tr>
        </table>

    </div>
</div>
</body>
<script>
    //获取漫展类型
    var getAetList = function () {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/getAetList',
            success: function (msg) {
                var obj = document.getElementById('aetId');
                for (var i = 0; i < msg.aetList.length; i++) {
                    obj.add(new Option(msg.aetList[i].aetName, msg.aetList[i].aetId));
                }
            }
        })
    };
    getAetList();

    var app = new Vue({
        el: "#app",
        data: {
            result: []
        }
    });

    //获取漫展列表
    var getAeList = function (curr) {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/getAePageList',
            data: {
                pageCurrent: curr || 1,
                pageSize: 8,
                /*aeEndtime: $("#aeEndtime option:selected").val(),*/
                aetId: $("#aetId option:selected").val(),
                aeAddress: $("#aeAddress option:selected").val()
                /*aeStarttime: $("#aeStarttime option:selected").val()*/
            },
            success: function (msg) {
                app.result = msg.page, msg.animeExpoTypelist;
                layui.use(['laypage', 'layer'], function () {
                    var laypage = layui.laypage,
                        layer = layui.layer;
                    laypage.render({
                        elem: 'pagenav', //容器
                        count: msg.totalPage,
                        limit: 8,
                        first: '首页',
                        last: '尾页',
                        groups: 5,
                        curr: curr || 1,
                        layout: ['count', 'prev', 'page', 'next', 'skip'],
                        jump: function (obj, first) {
                            if (!first) {
                                getAeList(obj.curr);
                            }
                        }
                    });
                });
            }
        })
    };

    getAeList();

    //类型查漫展
    $("#aetId").on('change', function () {
        getAeList();
    });

    //地区查漫展
    $("#aeAddress").on('change', function () {
        getAeList();
    });

    //时间查漫展
    $("#aeStarttime").on('change', function () {
        getAeList();
    });

    //结束或开始查漫展
    $("#aeEndtime").on('change', function () {
        getAeList();
    });

</script>
</html>