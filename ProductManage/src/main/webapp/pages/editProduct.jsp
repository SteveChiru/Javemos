<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/header.jsp" %>

<script type="text/javascript">
    function checkForm() {
        var pname = $("input[name=pname]").val();
        if(pname == "") {
            $("span").html("商品名称不能为空！");
            return false;
        }

        return true;
    }

    function getCategory() {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/CategoryServlet?op=get",
            dataType:"json",
            success:function(data) {
                $(data).each(function() {
                    $("select[name=categoryid]").append("<option value='"+this.cid+"'>"+this.cname+"</option>");
                });
            }

        });
    }

    function findProductById() {
        var pid = $("input[name=pid]").val();
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/ProductServlet?op=findById&pid=" + pid,
            dataType:"json",
            success:function(data) {
                if(data != null) {
                    $("input[name=pname]").val(data.pname);
                    $("select[name=categoryid]").val(data.categoryid);
                    $("input[name=price]").val(data.price);
                    $("textarea[name=pdescription]").val(data.pdescription);


                }
                else {
                    alert("查找商品信息失败！请联系管理员！");
                }
            }

        });
    }


    function updateProduct() {
        //$("input[name=pname]").val();
        var formData = $("form").serialize();
        //alert(formData);

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/ProductServlet",
            data:formData,
            success:function(msg) {
                if(msg == "success") {
                    alert("修改成功！");
                }
                else {
                    alert("修改失败！请联系管理员！");
                }
            }

        });


    }

    $(function() {
        /* $("form").submit(function() {
            return checkForm();
        }); */

        $("#button01").click(function() {
            var flag = checkForm();
            if(flag) {
                updateProduct();
            }

        });

        getCategory();
        findProductById();

    });


</script>
<form action="${pageContext.request.contextPath}/ProductServlet" method="post">
    <input type="hidden" name="op" value="edit"/>
    <input type="hidden" name="pid" value="${param.pid}" />

    <table style="width:500px;">
        <tr>
            <td>商品名称：</td><td><input type="text" name="pname"/><span></span></td>
        </tr>

        <tr>
            <td>商品分类：</td><td><select name="categoryid" style="width:180px;"></select></td>
        </tr>

        <tr>
            <td>商品价格：</td><td><input type="text" name="price"/></td>
        </tr>


        <tr>
            <td>商品描述：</td><td><textarea name="pdescription" rows="3"></textarea></td>
        </tr>


        <tr>
            <td colspan="2"><input type="button" id="button01" value="提交"/></td>
        </tr>
    </table>

</form>

</body>
</html>