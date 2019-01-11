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


        $(function() {
            $("form").submit(function() {
                return checkForm();
            });

            getCategory();

        });


    </script>
    <form action="${pageContext.request.contextPath}/ProductServlet?op=add" method="post" enctype="multipart/form-data">
        <!-- <input type="hidden" name="op" value="add"/> -->


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
                <td>商品图片：</td><td><input type="file" name="file01"/></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>

    </form>

</body>
</html>