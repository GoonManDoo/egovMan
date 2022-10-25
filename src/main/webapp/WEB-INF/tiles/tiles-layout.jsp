<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<tiles:insertAttribute name="loadFile"/>
<title>Insert title here</title>
</head>
<body>
<div id="wrap">

	<div id="nav"><tiles:insertAttribute name="header"/></div>
	<div id="left"><tiles:insertAttribute name="left"/></div>
	<div id="boddy"><tiles:insertAttribute name="body"/></div>
	<div id="footer"><tiles:insertAttribute name="footer"/></div>

</div>
</body>
</html>