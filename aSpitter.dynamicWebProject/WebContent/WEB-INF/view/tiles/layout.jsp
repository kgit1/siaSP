<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/tiles.css">
</head>

<body>
	<div class="wrap">
		<div class="tilesHeader">
			<tiles:insertAttribute name="header" />
		</div>

		<div class="center">
			<div class="tilesLeft">
				<tiles:insertAttribute name="left" />
			</div>

			<div class="tilesBody">
				<tiles:insertAttribute name="body" />
			</div>

			<div class="tilesRight">
				<tiles:insertAttribute name="right" />
			</div>
		</div>
		<div class="tilesFooter">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>
</html>
