<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/header.jsp" %>

<script type="text/javascript">
    function findProduct() {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/ProductServlet?op=find&categoryid=${param.categoryid}",
            dataType:"json",
            success:function(data) {
                $(data).each(function() {
                    var s = "<tr>";
                    s += "<td><input type='checkbox' name='pids' value='"+this.pid+"' /></td>";
                    s += "<td>"+this.pname+"</td>";
                    s += "<td>"+this.price+"</td>";
                    s += "<td>"+this.pdescription+"</td>";
                    s += "<td><img src='${pageContext.request.contextPath}"+this.path+"'/></td>";
                    s += "<td>[<a href='#' onclick='delProduct("+this.pid+",this);' >删除</a> | <a href='${pageContext.request.contextPath}/pages/editProduct.jsp?pid="+this.pid+"' >修改</a>]</td>";
                    s += "</tr>";

                    $("table").append(s);
                });
            }
        });
    }

    function delProduct(pid,delA) {
        var flag = window.confirm("确定是否删除？");
        if(flag) {
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/ProductServlet?op=del&pid=" + pid,
                success:function(msg) {
                    if(msg == "success") {
                        //通过超链接标签对象得到父标签td对象
                        //通过td对象得到父标签tr对象
                        $(delA).parent().parent().remove();
                        alert("删除成功！");
                    }
                    else {
                        alert("删除失败！请联系管理员！");
                    }
                }

            });
        }

    }

    function getCategory() {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/CategoryServlet?op=get",
            dataType:"json",
            success:function(data) {
                $(data).each(function() {
                    $("#div01").append("<a href='${pageContext.request.contextPath}/pages/listProduct.jsp?categoryid="+this.cid+"'>"+this.cname+"</a>&nbsp;&nbsp;");
                });
            }
        });
    }

    function checkAll() {
        var flag = false;

        if($("#all").is(":checked")) {
            flag = true;
        }


        //获取所有的商品复选框
        var inputList = $("input[name=pids]");
        inputList.each(function() {
            $(this).attr("checked",flag);
        });

    }

    function delMulti() {
        var inputList = $("input[name=pids]:checked");
        if(inputList.size() == 0) {
            alert("请选择要删除的商品！");
            return;
        }

        var flag = window.confirm("确定删除商品？");
        if(flag) {

            var pids = "";
            inputList.each(function() {
                if(pids != "") {
                    pids += ",";
                }

                pids += $(this).val();


            });


            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/ProductServlet?op=delMulti&pids=" + pids,
                success:function(msg) {
                    if(msg == "success") {

                        inputList.each(function() {
                            $(this).parent().parent().remove();

                        });

                        alert("删除成功！");
                    }
                    else {
                        alert("删除失败！");
                    }
                }

            });
        }
    }

    //页面加载完进入此函数
    $(function() {
        getCategory();
        findProduct();

        $("#all").click(function() {
            checkAll();
        });

    });

</script>

<div id="div01"></div>

<div style="width: 600px;margin: auto;text-align: left;"><a href="#" onclick="delMulti();">删除</a></div>

<table style="width:600px;">
    <tr>
        <td><input type="checkbox" name="all" id="all"/></td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>商品图片</td>
        <td>操作</td>
    </tr>


</table>

</body>
</html>