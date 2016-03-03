<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>���Ǘ��ҁ�${tb.title}</title>
	<link href="css/font.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<%
		ThreadBean tb = (ThreadBean)request.getAttribute("tb");
		ArrayList contentsList = tb.getContentsList();
		request.setAttribute("conList",contentsList); 
	%>
	
	<h1>�Ǘ��҉��</h1>
	<a href="/testbb">�g�b�v��</a>
	<a href="/testbb/selectthread">�X���b�h�I����</a>

	<hr>
	<p>�����W�I�{�^���ō폜���������e��I�����č폜�{�^���������Ă�������</p>
	<h2> ${tb.title} </h2>
	<h4>�J�e�S���F${tb.category}</h4>

	
	<form method='Post' action='condelete'>
		<c:forEach var="cb" items="${conList}">
			<input type="radio" name="conNo" value="${cb.contentNo}"><c:out value="${cb.contentNo}"/>
			<c:out value="${cb.name}"/>
			<c:out value="${cb.date}"/><br>
			<pre><c:out value="${cb.text}"/></pre> <br>
		</c:forEach>
	
	<hr><hr>
	<input type="hidden" name="threadNo" value="${tb.threadNo}">
	<input type="submit" value="�폜">
	</form>

</body>
</html>