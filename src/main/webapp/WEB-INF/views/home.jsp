<!DOCTYPE html>
<html>
<head>
    <title>Store Dashboard</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            text-align: center;
            margin: 0;
        }

        h1 {
            margin-top: 30px;
            color: #333;
        }

        .container {
            margin-top: 50px;
        }

        .btn {
            display: inline-block;
            padding: 15px 30px;
            margin: 12px;
            font-size: 18px;
            text-decoration: none;
            color: white;
            background: #007bff;
            border-radius: 8px;
            transition: 0.3s;
        }

        .btn:hover {
            background: #0056b3;
        }

        .logout-btn {
            padding: 12px 25px;
            font-size: 16px;
            color: white;
            background: red;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 30px;
        }

        .logout-btn:hover {
            background: darkred;
        }
    </style>
</head>

<body>

<h1>Store Dashboard</h1>

<div class="container">

    <!-- Use absolute URLs (IMPORTANT) -->
    <a href="/addItem" class="btn">Add Item</a>
    <a href="/viewItems" class="btn">View Items</a>
    <a href="/removeItem" class="btn">Remove Item</a>
    <a href="/salesReport" class="btn">Sales Report</a>

    <br><br>
	<form action="/deleteStore" method="post" 
	      onsubmit="return confirm('Are you sure? This will delete everything!');">
	    <input type="submit" value="Delete Store">
	</form>
	<br><br>
    <!-- Logout -->
    <form action="/logout" method="get">
        <button type="submit" class="logout-btn">Logout</button>
    </form>

</div>

</body>
</html>