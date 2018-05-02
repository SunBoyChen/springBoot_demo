<!DOCTYPE html>
<html>
<head lang="en">
	<title>Spring Boot Demo - FreeMarker</title>
    <script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>

    <link href="/css/index.css" rel="stylesheet" />
</head>
<body>
	<center>
		<h1 id="title">${title}</h1>
		<input type="text" name="email" id="email" />
		<button id="send">发送邮件</button>
	</center>

	t
	
	<script>
		$(function(){
			$('#send').click(function(){
			    alert("发送！")
				var email = $('#email').val();
				$.ajax({
					url:'/api/mail',
					type:'post',
					data:{'email':email},
					success:function(msg){
						alert(msg);
					}
				});
			});
		})
	</script>
</body>
</html>