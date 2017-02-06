<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/tags/hm-form" prefix="hm-form" %>

<h1>プロフィール編集</h1>

<div class="container">
<form:form action="${pageContext.request.contextPath}/user/profile/finish" modelAttribute="profile" method="post">

<form:errors path="*" element="div" cssClass="alert alert-danger" role="alert" />

<div class="form-group">
  <label  class="control-label" for="blogName">性別</label>

<div class="form-group">
	<c:forEach var="kbn" items="${profile.sexKbnList.kbn}">
		<label class="radio-inline"><form:radiobutton path="sexKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
<div class="btn-group" data-toggle="buttons">
	<c:forEach var="kbn" items="${profile.discloseKbnList.kbn}">
		<label class="btn btn-primary<c:if test="${kbn.kbnValueCode==profile.sexDiscloseKbn}"> active</c:if>"><form:radiobutton path="sexDiscloseKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
</div>

<div class="form-group">
  <label for="blogUrl" class="control-label">お住まい</label>
<div class="form-group">
    <form:select path="homePrefectureKbn" items="${profile.prefectureKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
<div class="btn-group" data-toggle="buttons">
	<c:forEach var="kbn" items="${profile.discloseKbnList.kbn}">
		<label class="btn btn-primary<c:if test="${kbn.kbnValueCode==profile.homePrefectureDiscloseKbn}"> active</c:if>"><form:radiobutton autocomplete="off" path="homePrefectureDiscloseKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
</div>

<div class="form-group">
<label for="blogUrl" class="control-label">妊活スタイル</label>
<div class="form-group">
	<c:forEach var="kbn" items="${profile.ninkatsuStyleKbnList.kbn}">
		<label class="checkbox-inline"><form:checkbox path="ninkatsuStyleKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
<div class="btn-group" data-toggle="buttons">
	<c:forEach var="kbn" items="${profile.discloseKbnList.kbn}">
		<label class="btn btn-primary<c:if test="${kbn.kbnValueCode==profile.ninkatsuStyleDiscloseKbn}"> active</c:if>"><form:radiobutton path="ninkatsuStyleDiscloseKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
</div>

<div class="form-group">
<label for="blogUrl" class="control-label">疾患等</label>
<div class="form-group">
	<c:forEach var="kbn" items="${profile.troubleKbnList.kbn}">
		<label class="checkbox-inline"><form:checkbox path="troubleKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
<div class="btn-group" data-toggle="buttons">
	<c:forEach var="kbn" items="${profile.discloseKbnList.kbn}">
		<label class="btn btn-primary<c:if test="${kbn.kbnValueCode==profile.troubleDiscloseKbn}"> active</c:if>"><form:radiobutton path="troubleDiscloseKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
</div>

<div class="form-group">
<label for="blogUrl" class="control-label">流産歴</label>
<div class="form-group">
	<c:forEach var="kbn" items="${profile.ryuzanKbnList.kbn}">
		<label class="checkbox-inline"><form:checkbox path="ryuzanKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
<div class="btn-group" data-toggle="buttons">
	<c:forEach var="kbn" items="${profile.discloseKbnList.kbn}">
		<label class="btn btn-primary<c:if test="${kbn.kbnValueCode==profile.ryuzanDiscloseKbn}"> active</c:if>"><form:radiobutton path="ryuzanDiscloseKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
</div>

<div class="form-group">
<label for="blogUrl" class="control-label">男性不妊</label>
<div class="form-group">
	<c:forEach var="kbn" items="${profile.husbandFuninKbnList.kbn}">
		<label class="checkbox-inline"><form:checkbox path="husbandFuninKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
<div class="btn-group" data-toggle="buttons">
	<c:forEach var="kbn" items="${profile.discloseKbnList.kbn}">
		<label class="btn btn-primary<c:if test="${kbn.kbnValueCode==profile.husbandFuninDiscloseKbn}"> active</c:if>"><form:radiobutton path="husbandFuninDiscloseKbn" value="${kbn.kbnValueCode}" /><c:out value="${kbn.kbnValueKanjiName}" /></label>
	</c:forEach>
</div>
</div>

<div class="form-group row">
  <div class="offset-sm-2 col-sm-10">
    <button type="submit" class="btn btn-primary">登録する</button>
  </div>
</div>
</form:form>
</div>