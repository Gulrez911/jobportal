<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<title>Home</title>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<script type="text/javascript" src="./resources/script/jquery.min.js"></script>
<script type="text/javascript" src="./resources/script/bootstrap.min.js"></script>
</head>
<body>
		<div class="container">
				<form action="pwdSuccess" method="post" id="pwdSubmit">
						Password: <input type="password" name="password" id="pwd1"> Re-Enter Password: <input
								type="password" name="password" id="pwd2"> <input type="button" value="Submit"
								onclick="checkpwd()">
				</form>
		</div>
		<script type="text/javascript">
			function checkpwd() {
				console.log("Test");
				var ps = $("#pwd1").val();
				var ps2 = $("#pwd2").val();
				console.log(ps+"  "+ps2)
				if (ps == ps2) {
					alert("password match")
					$("#pwdSubmit").submit();
				}
			}
		</script>
</body>
</html>