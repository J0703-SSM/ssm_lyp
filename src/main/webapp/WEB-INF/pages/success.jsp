<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
        #allmap{width:100%;height:500px;}
        p{margin-left:5px; font-size:14px;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=uKCz9TnknH21xhVaIqaOdzdxPB493LvS"></script>
    <title>显示全景控件</title>
</head>
<body>
<div id="allmap"></div>
<%--<p>在地图上添加全景控件，点击全景控件进入全景图</p>--%>
</body>
</html>
<script type="text/javascript">
    var map = new BMap.Map('allmap');
    map.centerAndZoom(new BMap.Point(120.305456, 31.570037), 12);
    map.enableScrollWheelZoom(true);
    // 覆盖区域图层测试
    map.addTileLayer(new BMap.PanoramaCoverageLayer());

    var stCtrl = new BMap.PanoramaControl(); //构造全景控件
    stCtrl.setOffset(new BMap.Size(20, 20));
    map.addControl(stCtrl);//添加全景控件
</script>

