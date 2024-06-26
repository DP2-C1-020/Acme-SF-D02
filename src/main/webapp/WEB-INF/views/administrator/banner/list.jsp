<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>	

<acme:list>
	<acme:list-column code="administrator.banner.list.label.startDate" path="startDate" width="20%"/>
	<acme:list-column code="administrator.banner.list.label.endDate" path="endDate" width="20%"/>	
	<acme:list-column code="administrator.banner.list.label.slogan" path="slogan" width="60%"/>
</acme:list>

<acme:button code="administrator.banner.list.label.button.create" action="/administrator/banner/create"/>