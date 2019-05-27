<!DOCTYPE html>
<#setting classic_compatible=true>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>index</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style type="text/css">
        body{ font-family: 'Microsoft YaHei';}
        /*.panel-body{ padding: 0; }*/
    </style>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h3>——Category</h3>

    </div>
</div>
<div class="container">
    <div class="main">
        <div class="row">
            <!-- 左侧内容 -->
            <div class="col-md-3">
                <div class="list-group">
                    <a href="/category?page=1" class="list-group-item text-center active">列表</a>
                    <a href="/category/toCategoryAdd" class="list-group-item text-center ">新增</a>
                </div>
            </div>
            <!-- 右侧内容 -->
            <div class="col-md-9">
                <!-- 自定义内容 -->
                <div class="panel panel-default">
                    <div class="panel-heading">列表</div>
                    <div class="panel-body">
                        <table class="table table-striped table-responsive table-hover">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>名称</th>
                                <th>价格</th>
                                <th>类别</th>
                                <th width="120">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list page.categoryList as category>
                                <tr>
                                    <td>${category.getC_id()}</td>
                                    <td>${category.getC_product()!}</td>
                                    <td>${category.getPrice()!}</td>
                                    <#if category.getType()==0>
                                        <td>PC</td>
                                    <#elseif category.getType()==1>
                                        <td>掌机</td>
                                    <#elseif category.getType()==2>
                                        <td>主机</td>
                                    <#else>
                                        <td>未分类</td>
                                    </#if>

                                    <td>
<#--                                        <%--<a href="">详情</a>--%>-->
                                        <a href="/category/delete?c_id=${category.getC_id()}">删除</a>
                                        <a href="/category/toCategoryUpdate?c_id=${category.getC_id()}">修改</a>
                                    </td>
                                </tr>
                            </#list>


                            </tbody>
                        </table>
                    </div>
                </div>

                <!--分页 -->
                <nav>
                    <ul class="pagination pull-right">
                        <li  class="previous"><a href="#">&laquo;</a></li>
                        <#list 1..page.totalPage as currentPage>
                            <li><a href="/category?page=${currentPage}">${currentPage}</a></li>
                        </#list>
                        <li><a href="#">&raquo;</a></li>
                    </ul>

                </nav>
            </div>
        </div>
    </div>
</div>
<!-- 尾部 -->
<div class="jumbotron" style=" margin-bottom:0;margin-top:105px;">
    <div class="container">
        <span>&copy; 2016 Saitmob</span>
    </div>
</div>


<script src="/js/jquery-3.1.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>