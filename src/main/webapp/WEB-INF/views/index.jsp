<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Store Management</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #4facfe, #00f2fe);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: white;
            padding: 40px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        }

        h1 {
            margin-bottom: 10px;
        }

        p {
            color: gray;
            margin-bottom: 30px;
        }

        .btn {
            display: block;
            width: 200px;
            margin: 10px auto;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            color: white;
            transition: 0.3s;
        }

        .store-btn {
            background: #28a745;
        }

        .store-btn:hover {
            background: #218838;
        }

        .register-btn {
            background: #007bff;
        }

        .register-btn:hover {
            background: #0056b3;
        }

        .login-btn {
            background: #ff9800;
        }

        .login-btn:hover {
            background: #e68900;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Store Management System</h1>
    <p>Manage your store easily 🚀</p>

    <form action="registerStore" method="post">
        <button class="btn store-btn">Register Store</button>
    </form>

    <form action="register" method="post">
        <button class="btn register-btn">Register Admin</button>
    </form>

    <form action="login" method="post">
        <button class="btn login-btn">Login</button>
    </form>
</div>

</body>
</html>