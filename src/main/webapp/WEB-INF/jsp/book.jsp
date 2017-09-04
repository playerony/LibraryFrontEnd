<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Author interface</title>
</head>
<body>
	<table class="container">
        <th><h1>ID</h1></th>
        <th><h1>Title</h1></th>
        <th><h1>Opcje</h1></th>

        <c:foreach items="${books}">
            <td>${book.id}</td>
            <td>${book.title}</td>
        </c:foreach>
    </table>
</body>
</html>