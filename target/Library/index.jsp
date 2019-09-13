<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2018-12-28
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
  <script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <body class="layui-layout-body">
  <!-- 顶部菜单开始 -->
  <div class="layui-header" >
    <ul class="layui-nav layui-layout-left">
    <li class="layui-nav-item"><a href="reader_borrowed.jsp"style="font-weight: bolder">${reader.name}的借书记录</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
          <a><img src="images/img.jpeg" class="layui-nav-img">${reader.name}</a>
      </li>
      <li class="layui-nav-item"><a href="/logout">退出</a></li>
    </ul>
  </div>
  </body>
</div>

<div class="layui-container" style="width: 1000px;height: 600px;margin-top: 0px;padding-top: 60px;">
  <div style="margin-left: 300px; width: 200px;">
    <div class="container" style="width: 500px;height: 50px;margin:10px auto;">
      <form action="/seekBook" class="parent" style="width: 100%;height: 42px;top: 4px;position: relative;" method="post">
        <input type="text"placeholder="请输入书名"style="width: 380px;height: 40px;border: 1px solid #ccc;font-size: 16px;outline: none;"/>
        <button style="width: 100px;height: 40px; position: absolute;background-color:rgb(35,38,46);border: 1px solid rgb(35,38,46);color: #fff;font-size: 16px;outline: none;">搜索图书</button>
      </form>
    </div>
  </div>

  <table class="layui-hide" id="test" lay-filter="test"></table>

  <script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="borrow">借阅</a>
  </script>

</div>



<script src="/layui/layui.js" charset="utf-8"></script>
<script>
  layui.use('table', function(){
    var table = layui.table;

    table.render({
      elem: '#test'
      ,url:'/findAll'
      ,title: '图书列表'
      ,cols: [[
        {field:'id', width:100, title: '图书编号', sort: true}
        ,{field:'name', width:150, title: '图书名称'}
        ,{field:'author', width:100, title: '作者'}
        ,{field:'publish', width:180, title: '出版社'}
        ,{field:'pages',width:100,  title: '图书页数', sort: true}
        ,{field:'price',width:100,  title: '价格', sort: true}
        ,{field:'bookcasename',width:170,  title: '分类'}
        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
      ]]
      ,page: true
    });

    table.on('tool(test)', function(obj){
      var data = obj.data;
      if(obj.event === 'borrow'){
        window.location.href="/reader_borrow/"+data.id;
      }
    });

  });
</script>
</body>
</html>