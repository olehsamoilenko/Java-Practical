<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
        <thead>
            <tr>
                <th>Bus Id</th>
                <th>Numberplate</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${buses}"  var="bus">
                <tr>
                    <td>${bus.id}</td>
                    <td>${bus.numberplate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form action="/addBuses">
        <button type="submit">Add new bus</button>
    </form>

</body>
</html>
