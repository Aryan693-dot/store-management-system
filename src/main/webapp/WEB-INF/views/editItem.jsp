<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Item</title>
</head>
<br>

<h2>Edit Item</h2>

<form action="/updateItem" method="post">

    <input type="hidden" name="i_id" value="${item.i_id}">

    Name: <input type="text" name="name" value="${item.name}"><br><br>
    Price: <input type="text" name="price" value="${item.price}"><br><br>
    Quantity: <input type="text" name="quantity" value="${item.quantity}"><br><br>

    <input type="submit" value="Update">

</form>
</br>
<form action="/back" method="get">
			        <input type="submit" value="BACK">
			 </form>
</body>
</html>