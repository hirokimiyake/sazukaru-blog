<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/tags/hm-form" prefix="hm-form" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	$('#file').change(function() {$('#form').submit();});
<c:if test="${picture.path!=null}">
	$('#<c:out value="${picture.idName}" />',parent.document).val('<c:out value="${picture.path}" />');
</c:if>
});
</script>
</head>
<body>
<c:if test="${picture.path!=null}"><img src="${pageContext.request.contextPath}${picture.path}" /></c:if>

<form:form id="form" action="${pageContext.request.contextPath}/common/picture/upload" modelAttribute="picture" method="post" enctype="multipart/form-data">
<form:input type="file" path="file" id="file" />
<form:input path="idName" type="hidden"/>
</form:form>

</body>
</html>