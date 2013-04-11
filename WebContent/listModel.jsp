<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.mberendt.Model"%>
<%@ page import="com.mberendt.ModelDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wszystkie rekordy</title>
</head>
<body>

<%
ModelDao dao = new ModelDao();
List<Model> modelList = dao.getAllModels();
%>
<table border="2">
<tr>
<th>Id</th>
<th>Kolumna1</th>
</tr>
<tr>
<%
for(Model model: modelList){
%>
<td><%=model.getId()%></td>
<td><%=model.getKolumna1()%></td>
<td><%=model.getKolumna2()%></td>
<td><%=model.getKolumna3()%></td>
<td><%=model.getKolumna4()%></td>
<td>
<a href="ModelHandler?action=editform&id=<%=model.getId()%>">Aktualizuj</a>
<td>
<a href="ModelHandler?action=delete&id=<%=model.getId()%>">Usun</a>

</tr>
<%
}
%>
</table>
<br>
<p><a href="ModelHandler?action=insert">Dodaj rekord</a></p>

</body>
</html>