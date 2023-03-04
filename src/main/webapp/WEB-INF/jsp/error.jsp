<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true" session="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
</head>
<body>
    <%= response.getStatus() %>
    発生日時
    <%= exception != null ? "システムエラーが発生しました。" : "" %>
</body>
</html>