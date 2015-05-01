<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Popular Photos</title>
</head>
<body>
<h1>Popular Photos</h1>
<h2><a href="${authURL}">Refresh</a></h2>
<c:forEach items="${photos}" var="photo">
Username : <c:out value="${photo.username}"></c:out>
<br/>
Likes : <c:out value="${photo.likes}"></c:out>
<br/>
Caption : <c:out value="${photo.caption}"></c:out>
<br/>
Created Date : <c:out value="${photo.postedTime}"></c:out>
<br/>
Permalink : <a href="<c:out value="${photo.permalink}"></c:out>"><c:out value="${photo.permalink}"></c:out></a>
<br/>
ImageURL : <a href="<c:out value="${photo.imageURL}"></c:out>"><c:out value="${photo.imageURL}"></c:out></a>
<br/>
Image : <img src="<c:out value="${photo.imageURL}"></c:out>" alt="NA"/>
<br/>

<hr/>
</c:forEach>
</body>
</html>
