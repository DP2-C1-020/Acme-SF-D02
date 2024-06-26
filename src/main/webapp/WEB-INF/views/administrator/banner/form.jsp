<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form>
	<jstl:if test="${acme:anyOf(_command, 'show|update|delete')}">
		<acme:input-moment code="administrator.banner.form.label.instantiationMoment" path="instantiationMoment" readonly="true"/>			
	</jstl:if>
	<acme:input-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:input-moment code="administrator.banner.form.label.startDate" path="startDate"/>
	<acme:input-moment code="administrator.banner.form.label.endDate" path="endDate"/>
	<acme:input-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:input-url code="administrator.banner.form.label.link" path="link"/>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete') && !readonly}">
			<acme:submit code="administrator.banner.form.label.button.update" action="/administrator/banner/update"/>
			<acme:submit code="administrator.banner.form.label.button.delete" action="/administrator/banner/delete"/>
		</jstl:when>
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="administrator.banner.form.label.button.create" action="/administrator/banner/create"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>