<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Web Page</title>
</head>
<body>
	<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

	<form action="regForm"method="post">
				USERNAME:<input type="text" name="username">
				PASSWORD:<input type="password" name="password">
				STORE_NAME:<input type="text" name="store">
				<input type="submit" value="REGISTER">
	</form>

</body>
</html>