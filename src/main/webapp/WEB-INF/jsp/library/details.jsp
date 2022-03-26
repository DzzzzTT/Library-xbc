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
                    <td>标签</td>
                    <td>值</td>
                </tr>
                <tr>
                    <td>图书编号</td>
                    <td><c:out value="${library.xbc1913041334Id}"></c:out></td>
                </tr>
                <tr>
                    <td>图书名称</td>
                    <td><c:out value="${library.xbc1913041334Name}"></c:out></td>
                </tr>
                <tr>
                    <td>图书价格</td>
                    <td><c:out value="${library.xbc1913041334Price}"></c:out></td>
                </tr>
            </table>
        </div>
    </body>
</html>