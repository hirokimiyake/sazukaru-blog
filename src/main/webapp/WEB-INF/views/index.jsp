<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.apache.activemq.broker.BrokerService" %>
<%
BrokerService broker = new BrokerService();
// configure the broker
broker.addConnector("tcp://localhost:61616");
broker.start();
%>
<h1>index</h1>