<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" >
<html>
	<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css"
	href="../../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../easyui/demo/demo.css">
<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
	// 定义事件方法

	function onSearch() {
		// 指定请求路径
		var opts = $("#dg").datagrid("options");
		opts.url = "./list3";
		// 获取查询参数
		var xbc1913041334Name = $("#xbc1913041334Name").val();
		var xbc1913041334Price = $("#xbc1913041334Price").val();
		// 组织参数
		var params = {};
		if (xbc1913041334Name != null && xbc1913041334Name.trim() != '') {
			params.xbc1913041334Name = xbc1913041334Name;
		}
		if (xbc1913041334Price != null && xbc1913041334Price.trim() != '') {
			params.xbc1913041334Price = xbc1913041334Price;
		}
		// 重新载入表格数据
		$("#dg").datagrid('load', params);
	}
</script>
</head>
<body>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 350px;">
		<div data-options="region:'north'" style="height: 50px">
			<form id="searchForm" method="post">
				<table>

					<tr>
						<td>图书名称：</td>
						<td><input id="xbc1913041334Name" name="xbc1913041334Name"
							class="easyui-textbox" data-options="prompt:'输入图书名称...'"
							style="width: 100%; height: 32px"></td>
						<td>图书价格</td>
						<td><input id="xbc1913041334Price" name="xbc1913041334Price" class="easyui-textbox"
							data-options="prompt:'输入价格...'" style="width: 100%; height: 32px">
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" style="width: 80px"
							onclick="onSearch()">查询</a></td>
						<td><a href="add" class="easyui-linkbutton"
							   data-options="iconCls:'icon-search'" style="width: 80px"
							   onclick="onSearch()">添加图书</a></td>
					</tr>
				</table>
			</form>
		</div>
<%--		--%>
		<div data-options="region:'center',title:'图书列表',iconCls:'icon-ok'" class="dataContoner">
			<table id="dg" class="easyui-datagrid" data-options="border:false,singleSelect:true,fit:true,fitColumns:true">
				<thead>
					<tr>
						<th data-options="field:'xbc1913041334Id'" width="80">图书编号</th>
						<th data-options="field:'xbc1913041334Name'" width="100">图书名称</th>
						<th data-options="field:'xbc1913041334Price'" width="80">图书价格</th>
						<th data-options="field:'photo'" width="80">图书封面</th>
						<th data-options="field:''" width="100">操作</th>
					</tr>
				</thead>
				<tbody>

					<!--使用forEache渲染数据模型-->
					<c:forEach items="${libraryList}" var="library">
<%--						<%--%>
<%--							Library library=new Library();--%>
<%--							String photo=library.getPhoto();--%>
<%--							String img="D:/photo/"+photo;--%>
<%--						%>--%>
						<tr>
							<td>${library.xbc1913041334Id}</td>
							<td>${library.xbc1913041334Name}</td>
							<td>${library.xbc1913041334Price}</td>
							<td><img src="<%=basePath%>pic/${library.photo}" height="50px" width="50px"></td>
							<td><a href="update?xbc1913041334Id=${library.xbc1913041334Id}">修改</a>&nbsp&nbsp&nbsp&nbsp
								<a href="delete?xbc1913041334Id=${library.xbc1913041334Id}">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>