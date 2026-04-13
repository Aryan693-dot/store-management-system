<!DOCTYPE html>
<html>
<head>
    <title>Add Item</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            text-align: center;
        }

        form {
            background: white;
            padding: 30px;
            display: inline-block;
            margin-top: 50px;
            border-radius: 10px;
        }

        input {
            padding: 10px;
            margin: 10px;
            width: 200px;
        }

        button {
            padding: 10px 20px;
            background: green;
            color: white;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<br>

<h2>Add Item</h2>

<form action="saveItem" method="post">
    <input type="text" name="name" placeholder="Item Name"><br>
    <input type="text" name="price" placeholder="Price"><br>
    <input type="text" name="quantity" placeholder="Quantity"><br>
    <button type="submit">Save</button>
</form>
</br>
<form action="/back" method="get">
			        <input type="submit" value="BACK">
			 </form>
</body>
</html>