<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


							
	<div class="container">
		<div class="row">
		
			<div class="widget-header widget-header-flat">
				<h4 class="widget-title smaller">
					<i class="ace-icon fa fa-quote-left smaller-80"></i>
					<h1>${topic.title}</h1>
					<p class="lead">${topic.content}</p>
				</h4>
			</div>
		
			<div class="list-group bs-callout bs-callout-info">
				<tbody>
				<c:forEach items="${replys.content}" var="reply">
						<a href="${ctx}/topic/${topic.id}" target="_blank" class="list-group-item">
							<span class="badge">14</span>
							<h4 class="list-group-item-heading">${reply.content}</h4>
						</a>
				</c:forEach>
				</tbody>
			</div>
		</div>
	</div>
		
</body>
</html>