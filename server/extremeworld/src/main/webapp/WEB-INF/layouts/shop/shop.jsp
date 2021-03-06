<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>极限学院:<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta property="qc:admins" content="3741464746621011605515166375" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/3/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/messages_bs_zh.js" type="text/javascript"></script>
<script src="${ctx}/static/materialize/js/materialize.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/static/font-awesome-4.2.0/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/simditor-2.1.10/styles/simditor.css" />



<!-- materialize -->
<link type="text/css" rel="stylesheet" href="${ctx}/static/materialize/css/materialize.min.css"  media="screen,projection"/>

<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/shop.css" type="text/css" rel="stylesheet" />

<sitemesh:head/>
</head>

<body>

		<div>
<%--   			<div class="col s2">
				<%@ include file="/WEB-INF/layouts/left.jsp"%>
			</div> --%>
			<div ><!-- class=" col s10 main" -->
				<%@ include file="/WEB-INF/layouts/shop/header.jsp"%>
				<div id="main">
					<sitemesh:body/>
				</div>
				<%@ include file="/WEB-INF/layouts/footer.jsp"%>
			</div>
			
		</div>
		
		
		<script src="${ctx}/static/bootstrap/3/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="${ctx}/static/materialize/js/materialize.min.js" type="text/javascript"></script>
	
	
</body>
</html>