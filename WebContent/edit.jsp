<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mberendt.Model"%>
<%@ page import="com.mberendt.ModelDao"%>
<%@ page import="com.mberendt.ModelHandler" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit record</title>
</head>
<body>
<%
Model model = new Model();
%>
<%
ModelDao dao = new ModelDao();
%>
<form method="POST"	action='ModelHandler' name='formEditModel'>
<input type="hidden" name="action" value="edit" />
<%
String mid = request.getParameter("id");
	if(mid!=null)
	{
		int id = Integer.parseInt(mid);
		model=dao.getModelById(id);
	
%>
<table>
<tr>
<td>Id</td>
<td><input type="text" name="id" /></td>
</tr>
<tr>
<td>Kolumna1</td>
<td><input type="text" name="Kolumna1" value="Kolumna1"/></td>
</tr>
<tr>
<td>Kolumna2</td>
<td><input type="text" name="Kolumna2" value="Kolumna2"/></td>
</tr>
<tr>
<td>Kolumna3</td>
<td><input type="text" name="Kolumna3" value="Kolumna3"/></td>
</tr>
<tr>
<td>Kolumna4</td>
<td><input type="text" name="Kolumna4" value="Kolumna4"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Update" /></td>
</tr>
</table>
<%
}else 
	out.println("nie znaleziono id");
%>
</form>
</body>
</html>