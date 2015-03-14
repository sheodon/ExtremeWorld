<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<script type="text/javascript">
		$(document).ready(function(){
	
			  $("a#newReply").click(function(){
			    $("div.class").append("<a>Appended item</a>");
			  });
			});
	</script>
	
</head>
<body>
					
	<div class="container main_content">
	
	<div class="reply_list_head">
		<h1>${topic.title}</h1>
		<div class="media">
			<div class="media-left">
				<a href="#"> <img class="media-object" src="${ctx}/static/ace/assets/avatars/avatar1.png" alt="..."></a>
			</div>
			
			<div class="media-body">
				<a href="#">${topic.user.name}</a>
				<p>${topic.createTime}</p>
				<br/>
				<h4>${topic.content}</h4>
			</div>
		</div>
	</div>
	
		
	

		
		<c:if test="${topic.videoSource != null}">
			<div class="row">
				<video src="http://7vilxo.com1.z0.glb.clouddn.com/video_test.mp4" controls="controls"></video>
			</div>
		</c:if>

		
		<div class="row">
			<c:forEach items="${replys.content}" var="reply">
			<div class="reply_list_item">
				<div class="media">
					<div class="media-left">
						<img class="media-object avatar"  alt="Alexa's Avatar" src="${ctx}/static/ace/assets/avatars/avatar1.png" />
					</div>
			
					<div class="row media-body">
					
						<div class="col-md-10"> 
							<a href="#">${reply.userInfo.name}</a>
							<p>${reply.createTime}</p>
							<h4>${reply.content}</h4>
						</div>
					<div class="col-md-2">
						<p>1楼</p>
						<a href="#">回复</a>
					</div>

					</div>
				</div>
				
				<!-- 子回复 -->
				<div style="padding-left: 5%">
					<c:forEach items="${reply.subReplys}" var="subreply">
						<div class="media">
							<div class="media-left">
								<img class="media-object avatar" alt="Alex Doe's avatar" src="${ctx}/static/ace/assets/avatars/avatar5.png" />
							</div>
							
							<div class="media-body">
								<a href="#"> ${subreply.userInfo.name} </a>
								<c:if test="${subreply.preSubReply  != null}">
									回复<a href="#"> ${subreply.preSubReply.userInfo.name}</a>
								</c:if>
									${subreply.content}
								<div class="row">
									<p>${subreply.createTime}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
						
						
			</div>		
		</c:forEach>
	</div>
</div>
	
	
	<form method="post" action="http://upload.qiniu.com/" enctype="multipart/form-data">
		  <input name="token" type="hidden" value="iKeYoaf3toQqqFfpdvNX5VBXX9qTL7FDN6GwcQj:O4jOrUPzqiJCmj462sZsBHDkQ6E=:eyJzY29wZSI6ImV4dHJlbWUiLCJyZXR1cm5VcmwiOiJodHRwOi8vbG9jYWxob3N0OjgwMjMvZXh0cmVtZXdvcmxkL3RvcGljLzUiLCJyZXR1cm5Cb2R5IjoieyAgICAgXCJmb29cIjogXCJiYXJcIiwgICAgIFwibmFtZVwiOiAkKGZuYW1lKSwgICAgIFwic2l6ZVwiOiAkKGZzaXplKSwgICAgIFwidHlwZVwiOiAkKG1pbWVUeXBlKSwgICAgIFwiaGFzaFwiOiAkKGV0YWcpLCAgICAgXCJ3XCI6ICQoaW1hZ2VJbmZvLndpZHRoKSwgICAgIFwiaFwiOiAkKGltYWdlSW5mby5oZWlnaHQpLCAgICAgXCJjb2xvclwiOiAkKGV4aWYuQ29sb3JTcGFjZS52YWwpIH0iLCJkZWFkbGluZSI6MTQyMjQxMzg4OX0=">
		  <input name="file" type="file" />
		  <input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;
	</form>
		

</body>
</html>