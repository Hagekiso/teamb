<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="css/index.css">
<title>�f�����K</title>
</head>
<body>
	<h1>�f�����K</h1>
	

	
<table border="0" cellpadding="0" cellspacing="0">
	
	<tbody>
	
		<form action="writecontents" method="Post">
		
		<tr>
			<td valign="top">
				<input type="hidden" name="MAX_FILE_SIZE" value="1048576">
				<input type="hidden" name="f" value="1">
				<br>
				<table border="0" cellpadding="4" cellspacing="0">
					<tbody>
						<tr>
							<td align="right" nowrap="">
								<font color="red">��</font>���O
								<input name="user_name" size="18" value=""> 
							</td>
							<td align="left" nowrap="">
								Email 
								<input name="email_address" size="22" value="" style="ime-mode:disabled">
							</td>
						</tr>
						<tr>
							<td align="right" nowrap="">
								�폜�p�p�X���[�h
								<input name="delete_key" value="" style="ime-mode:disabled">
							</td>
							<td align="left" nowrap="">
								�摜
								<!--<input type="file" size="41" name="image" value="">-->������
							</td>
						</tr>
						<tr>
							<!--
							<td align="right" nowrap="" valign="top">
								<img src="/captcha.php?PHPSESSID=2b46f06d623a8716298293029c227d15">
							</td>
							<td>
								<input type="text" maxlength="10" name="keystring">
								<br>
								<font size="2">���}���̕��������͂��Ă��������B</font>
							</td>
							�F�ؖ�����-->
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table border="0" cellpadding="5" cellspacing="0">
					<tbody>
						<tr>
							<td valign="middle">
								<font color="red">��</font>���b�Z�[�W(�^�O�g�p�s��)
								<br>
								<textarea name="message" cols="60" rows="6"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table border="0" cellpadding="5" cellspacing="0" width="100%">
					<tbody>
						<tr>
							<td align="right">
								<input type="submit" value=" �� �M ">
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		
		</form>
		
	</tbody>
	
</table>
	
	<div align="right"><a href="delete">�R�����g�̍폜</a></div>
	
	<hr>
	<c:forEach var="cb" items="${al}">
		<c:if test="${!cb.delete_flag}" >
			<c:out value="${cb.post_number}"/>
			<c:out value="${cb.user_name}"/><br>
			<pre><c:out value="${cb.message}"/></pre><br>
		</c:if>
	</c:forEach>
	<hr>
</body>
</html>