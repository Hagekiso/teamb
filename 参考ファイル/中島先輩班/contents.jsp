<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>${tb.title}</title>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="header">
	</div>

	
	<%
		ThreadBean tb = (ThreadBean)request.getAttribute("tb");
		ArrayList contentsList = tb.getContentsList();
		request.setAttribute("conList",contentsList); 
	%>
	
	<h1> ${tb.title} </h1>
	<h3>�J�e�S���F${tb.category}</h3>
	<a href="/testbb">�g�b�v��</a>
	<a href="/testbb/selectthread">�X���b�h�I����</a>
	<a href="#footer">�y�[�W�̈�ԉ��ց�</a>
	
	<hr>
	<c:forEach var="cb" items="${conList}">
		<c:out value="${cb.contentNo}"/>:
		<c:out value="${cb.name}" />
		<c:out value="${cb.date}"/><br>
		<pre><c:out value="${cb.text}"/></pre> <br>
	</c:forEach>
	
	<hr><hr><br>
	
	<c:if test="${tb.contentsCount < 100}" >
		<form method='Post' action='writecontents'>
			���O:<input type='text' name='name' placeholder="�������i�S�p15�����܂Łj"><br>
			<textarea name='text' cols='50' rows='5' placeholder="�S�p2000�����܂�"></textarea><br><br>
			<input type='submit' value='��������'>
			<input type="hidden" name="threadNo" value="${tb.threadNo}">
			<input type="hidden" name="contentNo" value="${tb.contentsCount+1}">
		</form>
	</c:if>
	
	<c:if test="${tb.contentsCount >= 100}" >
		���e��������𒴂����̂ł��̃X���b�h�ɂ͓��e�ł��܂���B�B�B
		<br>
	</c:if>
	
	
	<div id="footer">
		<a href="#header">�y�[�W�̈�ԏ�ց�</a>
	</div>

</body>
</html>