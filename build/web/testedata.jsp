<%-- 
    Document   : testedata
    Created on : 26/05/2019, 10:30:28
    Author     : PcLorD
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Date d = new Date();
    Calendar cal = new GregorianCalendar();
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
    String di = (String) request.getParameter("dataInicial");
    
    String dia = di.substring(8,10);
    String mes = di.substring(5,7);
    String ano = di.substring(0,4);
    
    String dataFormatadaInicial = dia+"-"+mes+"-"+ano;
    
    
    Date dataInicial = formato.parse(dataFormatadaInicial) ;
    Date dataFinal ;
   
   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Formato String </br>
        <h1>Data Inicial : <%=formato.format(dataInicial)%></h1>
        </br></br></br>
        Formato Date </br>
        <h1>Data Inicial : <%=formato.format(dataInicial)%></h1>
        </br></br></br>
        Request do Date </br>
        <h1>Data Inicial : <%=di%></h1>
      
        Data Substring Formatada </br>
        <h1>Data Inicial : <%=dataFormatadaInicial%></h1>
      
        
            

    </body>
</html>
