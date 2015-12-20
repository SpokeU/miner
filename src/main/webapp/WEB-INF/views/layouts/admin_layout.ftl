<#setting url_escaping_charset='ISO-8859-1'>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="${context_path}/css/bootstrap-orig.min.css" rel="stylesheet">
    <LINK href="${context_path}/css/main.css" rel="stylesheet" type="text/css"/>
    <script src="${context_path}/js/jquery.min.js"></script>
    <script src="${context_path}/js/bootstrap.min.js"></script>
    <script src="${context_path}/js/aw.js" type="text/javascript"></script>
    <title>ActiveWeb - <@yield to="title"/></title>
</head>
<body>

<#include "header.ftl" >

<div class="container">
    <div class="row">
        <div class="col-md-2"><#include "admin_nav.ftl" ></div>
        <div class="col-md-8">${page_content}</div>
    </div>




</div><!-- /.container -->


</body>

</html>