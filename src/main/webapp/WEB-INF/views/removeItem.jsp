<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Remove Items</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            text-align: center;
        }

        table {
            margin: auto;
            border-collapse: collapse;
            width: 60%;
            background: white;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
        }

        th {
            background: #dc3545;
            color: white;
        }

        .delete-btn {
            background: red;
            color: white;
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .delete-btn:hover {
            background: darkred;
        }
    </style>
</head>
<brbody>

<h2>Delete Items</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>

    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.i_id}</td>
            <td>${item.name}</td>
            <td>
                <form action="/deleteItem" method="post">
                    <input type="hidden" name="id" value="${item.i_id}">
                    <button class="delete-btn">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</br>
<form action="/back" method="get">
			        <input type="submit" value="BACK">
			 </form>
</body>
</html>