<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get User Detail</title>
</head>
<body>

<form action="ClientServlet" method="post">

<!-- <form action="http://localhost:8080/RESTfulWebService/backend/user/service/uploadFile" method="post" enctype="multipart/form-data"> -->

Name: <input type="text" name="username"/>
<br>
Email: <input type="text" name="email"/>
<!-- <br>
Mobile Number: <input type="text" name="phone" />
<br>
Last Name: <input type="text" name="lastname" />
<br>
Upload File: <input type="file" name="fiile"/> -->
<input type="submit" value = "Get" />
</form>

</body>
</html>