<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bus on route</title>
</head>
<body>

    <table>
        <thead>
            <tr>
                <th>Numberplate</th>
                <th>Start - End (distance)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${buses}" var="route">
                <tr>
                    <td>${route.numberplate}</td>
                    <td>${route.startCity} - ${route.endCity} (${route.distance} km)</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form action="/showBuses">
        <button type="submit">Show all buses</button>
    </form>
    <form action="/showRoutes">
        <button type="submit">Show all routes</button>
    </form>

</body>
</html>
