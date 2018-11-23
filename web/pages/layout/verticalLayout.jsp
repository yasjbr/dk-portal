<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Iterator"%>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>

<%-- Layout component
  Render a list on severals columns
  parameters : componentsList
--%>
<tiles:useAttribute id="list" name="bar" classname="java.util.List" />
<%-- Next will be a tag, as soon as tags allow include in iteration
  Wait until jsp1.3 --%>
<%
Iterator i=list.iterator();
while( i.hasNext() )
  {
  String comp=(String)i.next();
%>
<tiles:insert name="<%=comp%>" flush="true" />
<br>

<%
  } // end loop
%>
 
