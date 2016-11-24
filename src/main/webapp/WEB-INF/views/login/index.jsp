<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/tags/hm-form" prefix="hm-form" %>

<h1>ログイン</h1>

<div class="container">
<form:form action="${pageContext.request.contextPath}/login/login" modelAttribute="credential" method="post">

    <form:errors path="*" element="div" cssClass="alert alert-danger" role="alert" />

<hm-form:element path="mailAddress" element="div" cssClass="form-group row" cssErrorClass="form-group row has-error">
  <label for="mail_address" class="col-xs-2 col-form-label">メールアドレス</label>
  <div class="col-xs-10">
    <form:input path="mailAddress" cssClass="form-control" type="text" cssId="mail_address" />
    <form:errors path="mailAddress" />
  </div>
</hm-form:element>
<hm-form:element path="password" element="div" cssClass="form-group row" cssErrorClass="form-group row has-error">
  <label for="password" class="col-xs-2 col-form-label">パスワード</label>
  <div class="col-xs-10">
    <form:input path="password" cssClass="form-control" type="password" cssId="password" />
  </div>
</hm-form:element>

<div class="form-group row">
  <div class="offset-sm-2 col-sm-10">
    <button type="submit" class="btn btn-primary">ログイン</button>
  </div>
</div>
<form:hidden path="path"/>
</form:form>
</div>