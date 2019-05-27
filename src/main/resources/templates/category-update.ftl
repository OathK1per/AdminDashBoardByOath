<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>form</title>
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
                    <a href="/category?page=1" class="list-group-item text-center ">列表</a>
                    <a href="/category/toCategoryAdd" class="list-group-item text-center ">新增</a>
                    <a href="/category/toCategoryUpdate?c_id=${category.getC_id()}" class="list-group-item text-center active">修改</a>

                </div>
            </div>
            <!-- 右侧内容 -->
            <div class="col-md-9">
                <!-- 自定义内容 -->
                <div class="panel panel-default">
                    <div class="panel-heading">修改信息</div>
                    <div class="panel-body">
                        <form action="/category/update" method="post" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <input type="hidden" name="method" value="updateCategory">
                                <div class="col-sm-5">
                                    <input type="text" name="c_product" value="${category.c_product!}" class="form-control" placeholder="名称">
                                    <#if category??><@spring.bind "category.c_product" /><@spring.showErrors "<br>" /></#if>
                                </div>
                                <div class="col-sm-5">
                                    <p class="form-control-static text-danger">名称不能为空</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">价格</label>
                                <div class="col-sm-5">
                                    <input type="text" name="price" value="${category.getPrice()!}" class="form-control" placeholder="价格">
                                    <#if category??><@spring.bind "category.price" /><@spring.showErrors "<br>" /></#if>
                                </div>
                                <input type="hidden" name="c_id" value="${category.getC_id()}">
                                <div class="col-sm-5">
                                    <p class="form-control-static text-danger">价格不能为空</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">类别</label>
                                <div class="col-sm-5">
                                    <label class="radio-inline">
                                        <input <#if category.getType()==0>checked="checked"</#if> type="radio" name="type" value="0">PC
                                    </label>
                                    <label class="radio-inline">
                                        <input <#if category.getType()==1>checked="checked"</#if> type="radio" name="type" value="1">掌机
                                    </label>
                                    <label class="radio-inline">
                                        <input <#if category.getType()==2>checked="checked"</#if> type="radio" name="type" value="2">主机
                                    </label>
                                </div>
                                <div class="col-sm-5">
                                    <p class="form-control-static text-danger">请选择分类</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">修改</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>


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