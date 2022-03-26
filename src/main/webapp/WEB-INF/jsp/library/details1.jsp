<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" >
<html>
    <head>
        <title>图书详情</title>
    </head>
    <body>
    
        <div align="center">
            <table border="1">
                <tr>
                    <td>图书编号</td>
                    <td>图书名称</td>
                    <td>图书价格</td>
                </tr>
                <c:forEach items="${library1}" var="library">
                <tr>
                   <td><c:out value="${library.xbc1913041334Id}"/></td>
                   <td><c:out value="${library.xbc1913041334Name}"/></td>
                   <td><c:out value="${library.xbc1913041334Price}"/></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>