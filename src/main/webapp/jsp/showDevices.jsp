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
            <th>Наименование</th>
            <th>Модель</th>
            <th>Номер в Гос.реестре СИ</th>
            <th>Заводской номер</th>
            <th>Дата поверки</th>
            <th></th>
        </thead>
        <tbody>
            <c:forEach var="device" items="${devices}">
                <tr>
                    <td>${device.name}</td>
                    <td>${device.model}</td>
                    <td>${device.registryNumber}</td>
                    <td>${device.serialNumber}</td>
                    <td>${device.calibrationDate}</td>
                    <td>
                        <ul>
                            <li>
                                <a href="${pageContext.request.contextPath}/deletedevice?id=${device.id}">Удалить</a>
                            </li>
                            <br>
                            <li>
                                <a href="${pageContext.request.contextPath}/updatedevice?id=${device.id}">Изменить</a>
                            </li>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
     <a id="buttons-hbox" href="${pageContext.request.contextPath}/deviceadd" target="_blank">Добавить новое СИ</a>
    </div>
</body>
</html>
