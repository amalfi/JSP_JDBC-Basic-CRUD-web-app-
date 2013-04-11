<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodaj nowy rekord</title>
</head>
<body>
	<form method="post" action='ModelHandler' name="formAddRecord">
	<input type="hidden" name="action" value="insert"/>
	<p><b>Add new record</b></p>
	
	<table>
	
	<tr>
	<td>ID</td>
	<td><input type="text" name="id" /></td>
	</tr>
	
	<tr>
	<td>Kolumna1</td>
	<td><input type="text" name="kolumna1" /></td>
	</tr>
	
	<tr>
	<td>Kolumna2</td>
	<td><input type="text" name="kolumna2" /></td>
	</tr>
	
	<tr>
	<td>Kolumna3</td>
	<td><input type="text" name="kolumna3" /></td>
	</tr>
	
	<tr>
	<td>Kolumna4</td>
	<td><input type="text" name="kolumna4" /></td>
	</tr>
	
	<tr>
	<td><input type="submit" value="Submit" /></td>
	</tr>
	
	</table>
	
	</form>
	<p><a href="ModelHandler?action=listModel">Pokaz wszystkie rekordy</a></p>
	</body>
</html>