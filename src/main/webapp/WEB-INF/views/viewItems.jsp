<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Items</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            text-align: center;
        }

        table {
            margin: auto;
            border-collapse: collapse;
            width: 75%;
            background: white;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
        }

        th {
            background: #007bff;
            color: white;
        }

        tr:hover {
            background: #f1f1f1;
        }

        .btn {
            padding: 6px 12px;
            margin: 2px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .update { background: orange; color: white; }
        .sell { background: green; color: white; }

        .pagination button {
            padding: 8px 12px;
            margin: 3px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .active-page {
            background: #007bff;
            color: white;
        }

        .sort, .search {
            margin-bottom: 15px;
        }

        .sort a {
            margin: 0 10px;
            text-decoration: none;
            font-weight: bold;
            color: #007bff;
        }
    </style>
</head>

<body>

<h2>Items List</h2>

<!-- 🔍 SEARCH -->
<form action="/viewItems" method="get" class="search">

    <input type="text" name="keyword" value="${keyword}" placeholder="Search item name">

    <input type="hidden" name="sortField" value="${sortField}">
    <input type="hidden" name="sortDir" value="${sortDir}">

    <input type="submit" value="Search">

</form>

<!-- 🔥 SORTING -->
<div class="sort">

    <!-- NAME -->
    <a href="/viewItems?page=0&sortField=name&sortDir=${sortField == 'name' && sortDir == 'asc' ? 'desc' : 'asc'}&keyword=${keyword}">
        Name
        <c:if test="${sortField == 'name'}">
            (${sortDir == 'asc' ? '↑' : '↓'})
        </c:if>
    </a>

    |

    <!-- PRICE -->
    <a href="/viewItems?page=0&sortField=price&sortDir=${sortField == 'price' && sortDir == 'asc' ? 'desc' : 'asc'}&keyword=${keyword}">
        Price
        <c:if test="${sortField == 'price'}">
            (${sortDir == 'asc' ? '↑' : '↓'})
        </c:if>
    </a>

</div>

<!-- 📦 TABLE -->
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.i_id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>

            <td>
                <!-- Update -->
                <form action="/editItem" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${item.i_id}">
                    <input type="submit" value="Update" class="btn update">
                </form>

                <!-- Sell -->
                <form action="/sellItem" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${item.i_id}">
                    <input type="submit" value="Sell" class="btn sell">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- 🔥 PAGINATION -->
<c:if test="${totalPages > 1}">
    <div class="pagination" style="margin-top:20px;">

        <!-- Prev -->
        <c:if test="${currentPage > 0}">
            <a href="/viewItems?page=${currentPage - 1}&sortField=${sortField}&sortDir=${sortDir}&keyword=${keyword}">
                <button>Prev</button>
            </a>
        </c:if>

        <!-- Numbers -->
        <c:forEach begin="0" end="${totalPages - 1}" var="i">
            <a href="/viewItems?page=${i}&sortField=${sortField}&sortDir=${sortDir}&keyword=${keyword}">
                <button class="${i == currentPage ? 'active-page' : ''}">
                    ${i + 1}
                </button>
            </a>
        </c:forEach>

        <!-- Next -->
        <c:if test="${currentPage < totalPages - 1}">
            <a href="/viewItems?page=${currentPage + 1}&sortField=${sortField}&sortDir=${sortDir}&keyword=${keyword}">
                <button>Next</button>
            </a>
        </c:if>

    </div>
</c:if>

<br>

<form action="/back" method="get">
    <input type="submit" value="BACK">
</form>

</body>
</html>