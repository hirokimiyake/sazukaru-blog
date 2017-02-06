<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/tags/hm-form" prefix="hm-form" %>

<h1>ブログを登録する</h1>

<div class="container">
<form:form action="${pageContext.request.contextPath}/user/blog/regist" modelAttribute="userBlog" method="post">

<form:errors path="*" element="div" cssClass="alert alert-danger" role="alert" />

<div class="form-group row">
  <label for="blogName" class="col-xs-2 col-form-label">ブログ名</label>
  <div class="col-xs-10">
    <form:input path="blogName" cssClass="form-control" type="text" cssId="blogName" />
  </div>
</div>
<div class="form-group row">
  <label for="blogUrl" class="col-xs-2 col-form-label">ブログURL</label>
  <div class="col-xs-10">
    <form:input path="blogUrl" cssClass="form-control" type="text" cssId="blogUrl" />
  </div>
</div>
<div class="form-group row">
  <label for="rss" class="col-xs-2 col-form-label">ブログのRSS</label>
  <div class="col-xs-10">
    <form:input path="rss" cssClass="form-control" type="text" cssId="rss" />
  </div>
</div>
<div class="form-group row">
  <label for="introduction" class="col-xs-2 col-form-label">自己紹介</label>
  <div class="col-xs-10">
    <form:textarea path="introduction" cssClass="form-control" cssId="introduction" />
  </div>
</div>
<div class="form-group row">
  <label for="profilePicturePath" class="col-xs-2 col-form-label">プロフィール画像</label>
  <div class="col-xs-10">
    <iframe src="${pageContext.request.contextPath}/common/picture/entry?idName=profilePicturePath" frameborder="0"></iframe>
    <form:input path="profilePicturePath" cssClass="" type="text" cssId="profilePicturePath" />
  </div>
</div>

<div class="form-group row">
  <label class="col-sm-2"></label>
  <div class="col-sm-10">
    <div class="form-check">
      <label class="form-check-label">
        <form:checkbox path="kiyakuAgree" class="form-check-input" /> ブログ登録者利用規約に同意する
      </label>
    </div>
  </div>
</div>
<div class="form-group row">
  <div class="offset-sm-2 col-sm-10">
    <button type="submit" class="btn btn-primary">登録する</button>
  </div>
</div>
</form:form>
</div>