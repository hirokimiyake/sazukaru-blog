<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/tags/hm-form" prefix="hm-form" %>

<h1>プロフィールを登録する</h1>

<div class="container">
<form:form action="${pageContext.request.contextPath}/user/profile/finish" modelAttribute="profile" method="post">

<form:errors path="*" element="div" cssClass="alert alert-danger" role="alert" />

<div class="form-group row">
  <label for="blogName" class="col-xs-2 col-form-label">性別</label>
  <div class="col-xs-10">
    <form:radiobuttons path="sexKbn" items="${profile.sexKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
    <form:radiobuttons path="sexDiscloseKbn" items="${profile.discloseKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
</div>
<div class="form-group row">
  <label for="blogUrl" class="col-xs-2 col-form-label">お住まい</label>
  <div class="col-xs-10">
    <form:select path="homePrefectureKbn" items="${profile.prefectureKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
    <form:radiobuttons path="homePrefectureDiscloseKbn" items="${profile.discloseKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
</div>
<div class="form-group row">
  <label for="blogUrl" class="col-xs-2 col-form-label">妊活スタイル</label>
  <div class="col-xs-10">
    <form:checkboxes path="ninkatsuStyleKbn" items="${profile.ninkatsuStyleKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
    <form:radiobuttons path="ninkatsuStyleDiscloseKbn" items="${profile.discloseKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
</div>

<div class="form-group row">
  <label for="blogUrl" class="col-xs-2 col-form-label">疾患等</label>
  <div class="col-xs-10">
    <form:checkboxes path="troubleKbn" items="${profile.troubleKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
    <form:radiobuttons path="troubleDiscloseKbn" items="${profile.discloseKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
</div>

<div class="form-group row">
  <label for="blogUrl" class="col-xs-2 col-form-label">流産歴</label>
  <div class="col-xs-10">
    <form:checkboxes path="ryuzanKbn" items="${profile.ryuzanKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
    <form:radiobuttons path="ryuzanDiscloseKbn" items="${profile.discloseKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
</div>

<div class="form-group row">
  <label for="blogUrl" class="col-xs-2 col-form-label">男性不妊</label>
  <div class="col-xs-10">
    <form:checkboxes path="husbandFuninKbn" items="${profile.husbandFuninKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
    <form:radiobuttons path="husbandFuninDiscloseKbn" items="${profile.discloseKbnList.kbn}" itemLabel="kbnValueKanjiName" itemValue="kbnValueCode"/>
  </div>
</div>


<div class="form-group row">
  <div class="offset-sm-2 col-sm-10">
    <button type="submit" class="btn btn-primary">登録する</button>
  </div>
</div>
</form:form>
</div>