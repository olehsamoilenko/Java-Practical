<%--
  Created by IntelliJ IDEA.
  User: osamoile
  Date: 28.11.19
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="elem">
        <tr>
            <td>elem</td>
        </tr>
    </c:forEach>
</body>
</html>
