<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>���Ǘ��ҁ��X���b�h�I��</title>
	<link href="css/font.css" rel="stylesheet" type="text/css" />
		<a href="index.html"><img src="img/zhuti.png"></a>

</head>
<body>
	<br>
	<div class="text" style=" text-align:center;">

	<h1> �Ǘ��҉�� </h1>
	<a href="/testbb">�g�b�v��</a>
	<a href="/testbb/selectthread">�X���b�h�I����</a>
	<hr>

	<div class="table" style=" align:center;">
	<h2>�X���b�h�ꗗ</h2>
	<p>�����W�I�{�^���ō폜����X���b�h��I�����č폜�{�^���������Ă�������</p>
	<table border="1" cellpadding="0" cellspacing="0"  background="img/tablehaike.jpg" align="center">
	<tr><th>�X���ԍ�</th> <th>�^�C�g��</th> <th>�J�e�S��</th> <th>���X��</th> </tr>
	
	<form method="Post" action="ThDeleteSer">
		
		<c:forEach var="tb" items="${al}">
			<tr>
	            	<td>	<input type="radio" name="threNo" value="${tb.threadNo}"> <c:out value="${tb.threadNo}"/></tb>
				<td> <a href="/testbb/showadminthread?thread=${tb.threadNo}"> <c:out value="${tb.title}" /> </a> </td>
				<td> <c:out value="${tb.category}" /> </td>
				<td> <c:out value="${tb.contentsCount}" /> </td>
			</tr>
		</c:forEach>
		
		</div>
		</table>
	<br>
	<hr>
	<p style="color:red">���폜�͎������܂���B�悭�m�F�̏�폜���Ă��������B</p>
	<input type="submit" value="�폜">
	</form>
	</div>
	
	
</body>
</html>