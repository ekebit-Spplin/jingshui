<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/5
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
哈哈哈
<object type='application/x-vlc-plugin' id='vlc' events='True' width="100%" height="100%"
        pluginspage="http://www.videolan.org"
        codebase="http://downloads.videolan.org/pub/videolan/vlc-webplugins/2.0.6/npapi-vlc-2.0.6.tar.xz">
    <param name='mrl' value='rtsp://49.65.203.137:8001/my.sdp'/>
    <param name='volume' value='50'/>
    <param name='autoplay' value='true'/>
    <param name='loop' value='false'/>
    <param name='fullscreen' value='false'/>
</object>


</body>
</html>
