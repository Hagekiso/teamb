<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"%>
	

<html>
<head>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
	<title>�X���b�h�쐬</title>
</head>
<body>
		<a href="index.html"><img src="img/zhuti.png"></a>
		<div class="text" style=" text-align:center;">
		<h1>�X���b�h�쐬�t�H�[��</h1>
		<a href="/testbb/">�g�b�v��</a>
		<a href="/testbb/selectthread">�X���b�h�I����</a>
		<hr>
		<br>
		<form method='Post' action='newthread'>
		�^�C�g���F<input type='text' name='title' placeholder="�S�p50�����܂�">
		<select name='cat'>
		<option value="�w�Z����">�w�Z����</option>
		<option value="�A�E">�A�E</option>
		<option value="�G�k">�G�k</option>
		</select>
		<br>
		<br>
		���O:<input type='text' name='name' placeholder="�������i�S�p15�����܂Łj"><br>
		<textarea name='text' cols='50' rows='5' placeholder="�S�p2000�����܂�"></textarea><br><br>
		<input type='submit' value='�X���b�h�쐬'>
	</form>

</body>
</html>