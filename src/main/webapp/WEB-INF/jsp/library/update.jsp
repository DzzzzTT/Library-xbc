<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改图书</title>
<!-- 加载Query文件-->
<script type="text/javascript" src="/js/jquery-3.2.1.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
    $("#submit").click(function() {
        var xbc1913041334Id=$("#xbc1913041334Id").val();
        var xbc1913041334Name=$("#xbc1913041334Name").val();
        var xbc1913041334Price=$("#xbc1913041334Price").val();
        var photo=$("#photo").val();
        if ($.trim(xbc1913041334Name)=='') {
            alert("图书名不能为空！");
            return;
        }
        var params = {
            xbc1913041334Id:xbc1913041334Id,
            xbc1913041334Name:xbc1913041334Name,
            xbc1913041334Price:xbc1913041334Price,
            photo:photo
        };
        $.post({
            url:"./insert",
            // 此处需要告知传递参数类型为JSON，不能缺少
            contentType:"application/json",
            // 将JSON转化为字符串传递
            data:JSON.stringify(params),
            // 成功后的方法
            success:function(result){
                if(result==null||result.xbc1913041334Id==null) {
                    alert("插入失败");
                    return;
                }
                alert("插入成功"+result.xbc1913041334Name+">>"+result.xbc1913041334Price+">>"+result.photo);
                window.location.href="./table";
            }



        });
   });
});
</script>
</head>
<body>
    <div style="margin: 20px 0;"></div>
    <form method="post" action="./update1" enctype="multipart/form-data">
        <table>
            <tr>
                <td>图书编号：</td>
                <td><input id="xbc1913041334Id" name="xbc1913041334Id" type="hidden" value=${library.xbc1913041334Id }></td>
            </tr>
            <tr>
                <td>图书名称：</td>
                <td><input id="xbc1913041334Name" name="xbc1913041334Name" value=${library.xbc1913041334Name}></td>
            </tr>
            <tr>
                <td>图书价钱：</td>
                <td><input id="xbc1913041334Price" name="xbc1913041334Price" value=${library.xbc1913041334Price }></td>
            </tr>
            <tr>
                <td>图片：</td>
                <td><input type="file" id="photo" name="photo" value=${library.photo }/></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><input id="button" type="submit" value="修改" /></td>
            </tr>
        </table>
    </form>
</body>