<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>漫展详情</title>
</head>
<body>
漫展ID：${animeExpo.getAeId()} <br>
漫展名字：${animeExpo.getAeName()} <br>
漫展地址：${animeExpo.getAeAddress()} <br>
漫展详细地址：${animeExpo.getAeFulladdress()} <br>
<#--漫展开始时间：${animeExpo.getAeStarttime()} <br>
漫展结束时间：${animeExpo.getAeEndtime()} <br>-->
漫展预售价格：${animeExpo.getAeOldfare()} <br>
漫展现场价格：${animeExpo.getAeNewfare()} <br>
漫展交通路线：${animeExpo.getAeTraffic()} <br>
漫展往届：${animeExpo.getAeOld()} <br>
</body>
</html>