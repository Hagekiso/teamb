<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>�폜�y�[�W</title>
	<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<p>���e�ԍ��ƍ폜�p�p�X���[�h����͂��Ă�������</p>
	<form method='post' action='deleteresult'>
	���e�ԍ�<input required type='text' name='post_number'>
	�폜�p�p�X<input type='text' name='delete_key'>
	<input type='submit' value='�폜'>
	</form>
	<p>${result}</p>
	<a href="index">�f���ɖ߂�</a>
</body>
</html>