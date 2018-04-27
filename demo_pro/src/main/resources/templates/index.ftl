<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>

    <link href="/css/index.css" rel="stylesheet" />

</head>
<body>


<#-- 默认加载static下的资源 -->
<center>
    <img src="/images/logo.png" />
    <h1 id="title">${title} 测试demo_cores跨域请求</h1>
</center>

<script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>

<script>
    $(function(){
        $('#title').click(function(){
            alert('点击了');

            $.ajax({
                url: "http://localhost:8081/api/get",
                type: "POST",
                data: {
                    name: "测试"
                },
                success: function(data, status, xhr) {
                    console.log(data);
                    alert(data.name);
                }
            });
        });
    })


</script>


</body>
</html>
