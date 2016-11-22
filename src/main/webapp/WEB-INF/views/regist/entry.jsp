<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>会員登録</h1>

<div class="container">
<form:form action="${pageContext.request.contextPath}/regist/regist" modelAttribute="bean" method="post">

<div class="form-group row">
  <label for="mailaddress" class="col-xs-2 col-form-label">メールアドレス</label>
  <div class="col-xs-10">
    <form:input path="mailaddress" cssClass="form-control" type="text" cssId="mailaddress" />
  </div>
</div>
<div class="form-group row">
  <label for="password" class="col-xs-2 col-form-label">パスワード</label>
  <div class="col-xs-10">
    <form:input path="password" cssClass="form-control" type="password" cssId="password" />
  </div>
</div>
<div class="form-group row">
  <label for="name" class="col-xs-2 col-form-label">お名前</label>
  <div class="col-xs-10">
    <form:input path="name" cssClass="form-control" type="text" cssId="name" />
  </div>
</div>
<div class="form-group row">
  <label for="nickname" class="col-xs-2 col-form-label">ニックネーム</label>
  <div class="col-xs-10">
    <form:input path="nickname" cssClass="form-control" type="text" cssId="nickname" />
  </div>
</div>

<div class="form-group row">
  <label class="col-sm-2"></label>
  <div class="col-sm-10">
    <div class="form-check">
      <label class="form-check-label">
        <form:checkbox path="kiyakuAgree" cssClass="form-check-input" /> 授かるブログ利用規約に同意する
      </label>
    </div>
  </div>
</div>
<div class="form-group row">
  <label class="col-sm-2"></label>
  <div class="col-sm-10">
    <div class="form-check">
      <label class="form-check-label">
        <form:checkbox path="privacyAgree" cssClass="form-check-input" /> 個人情報取り扱い同意書に同意する
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