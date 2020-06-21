<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение информации о СИ</title>
    <style>
        <%@include file='css/deviceadd.css'%>
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/updatedevice?id=${device.id}" autocomplete="off">
    <h3>Измените необходимые поля</h3>
    <div>
        <label for="name">Наименование: </label>
        <input name="name" type="text" class="form-control" id="name" value="${device.name}">
    </div>
    <div>
        <label for="model">Модель: </label>
        <input name="model" type="text" class="form-control" id="model" value="${device.model}">
    </div>
    <div>
        <label for="registryNumber">Номер в Гос.реестре: </label>
        <input name="registry" type="text" class="form-control" id="registryNumber" value="${device.registryNumber}">
    </div>
    <div>
        <label for="serialNumber">Заводской номер: </label>
        <input name="serial" type="text" class="form-control" id="serialNumber" value="${device.serialNumber}">
    </div>
    <div>
        <label for="calibrationDate">Дата поверки: </label>
        <input name="calibration" type="text" class="form-control" id="calibrationDate" value="${device.calibrationDate}">
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Изменить</button>
    </div>
</form>
</body>
</html>
