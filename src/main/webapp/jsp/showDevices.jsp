<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оборудование СИКН</title>
    <style>
        <%@include file='css/alldevices.css' %>
    </style>
</head>
<body>
    <table>
        <thead>
            <th id="idTh">ID</th>
            <th>Наименование</th>
            <th>Модель</th>
            <th>Номер в Гос.реестре СИ</th>
            <th>Заводской номер</th>
            <th>Дата поверки</th>
        </thead>
        <tbody>
            <c:forEach var="device" items="${devices}">
                <tr>
                    <td id="idTd">${device.id}</td>
                    <td>${device.name}</td>
                    <td>${device.model}</td>
                    <td>${device.registryNumber}</td>
                    <td>${device.serialNumber}</td>
                    <td>${device.calibrationDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
