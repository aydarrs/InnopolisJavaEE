<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="device" class="pojo.Device"/>

<html>
<head>
    <title>Добавление нового СИ</title>
    <style>
        <%@include file='css/deviceadd.css' %>
    </style>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/deviceadd" autocomplete="off">
        <h3>Для добавления нового СИ заполните поля ниже</h3>
        <div>
            <label for="name">Наименование: </label>
            <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="device" property="name"/>">
        </div>
        <div>
            <label for="model">Модель: </label>
            <input name="model" type="text" class="form-control" id="model" value="<jsp:getProperty name="device" property="model"/>">
        </div>
        <div>
            <label for="registryNumber">Номер в Гос.реестре: </label>
            <input name="registry" type="text" class="form-control" id="registryNumber" value="<jsp:getProperty name="device" property="registryNumber"/>">
        </div>
        <div>
            <label for="serialNumber">Заводской номер: </label>
            <input name="serial" type="text" class="form-control" id="serialNumber" value="<jsp:getProperty name="device" property="serialNumber"/>">
        </div>
        <div>
            <label for="calibrationDate">Дата поверки: </label>
            <input name="calibration" type="text" class="form-control" id="calibrationDate" value="<jsp:getProperty name="device" property="calibrationDate"/>">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
    </form>
</body>
</html>
