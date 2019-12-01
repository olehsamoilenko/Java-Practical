<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Routes</title>
</head>
<body>

    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Start</th>
                <th>End</th>
                <th>Distance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${routes}" var="route">
                <tr>
                    <td>${route.id}</td>
                    <td>${route.startCity}</td>
                    <td>${route.endCity}</td>
                    <td>${route.distance}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form action="/addRoutes">
        <button type="submit">Add new route</button>
    </form>

</body>
</html>
