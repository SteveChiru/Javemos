<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/pages/header.jsp" %>
    <script type="text/javascript">
        function checkForm() {
            var cname = $("input[name=cname]").val();
            if(cname == "") {
                $("span").html("分类名称不能为空！");
                return false;
            }

            return true;
        }

        $(function() {
            $("form").submit(function() {
                return checkForm();
            });

        });


    </script>
    <form action="${pageContext.request.contextPath}/CategoryServlet" method="post">
        <input type="hidden" name="op" value="add"/>

        <table style="width:500px;">
            <tr>
                <td>分类名称：</td><td><input type="text" name="cname"/><span></span></td>
            </tr>
            <tr>
                <td>分类描述：</td><td><textarea name="description" rows="3"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>

    </form>

</body>
</html>
