<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sales Report</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            margin: 0;
            text-align: center;
        }

        h1 {
            margin-top: 30px;
            color: #333;
        }

        .card {
            background: white;
            width: 300px;
            margin: 30px auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        .sales {
            font-size: 24px;
            color: green;
            font-weight: bold;
        }

        .low-stock {
            width: 60%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        .low-stock th, .low-stock td {
            padding: 12px;
            border: 1px solid #ddd;
        }

        .low-stock th {
            background: #007bff;
            color: white;
        }

        .low-stock tr {
            background: #fff3f3;
            color: red;
        }

        .btn {
            margin-top: 30px;
            padding: 12px 25px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            background: #007bff;
            color: white;
            cursor: pointer;
        }

        .btn:hover {
            background: #0056b3;
        }
    </style>
</head>

<body>

<h1>📊 Sales Report</h1>

<!-- Total Sales Card -->
<div class="card">
    <h3>Total Sales</h3>
    <p class="sales">₹ ${totalSales}</p>
</div>

<!-- Low Stock Section -->
<h2>⚠️ Low Stock Items</h2>

<c:if test="${empty lowStockItems}">
    <p>No low stock items ✅</p>
</c:if>

<table class="low-stock">
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
    </tr>

    <c:forEach var="item" items="${lowStockItems}">
        <tr>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
        </tr>
    </c:forEach>
</table>

<!-- Back Button -->
<form action="back" method="get">
    <button type="submit" class="btn">⬅ Back to Dashboard</button>
</form>

</body>
</html>