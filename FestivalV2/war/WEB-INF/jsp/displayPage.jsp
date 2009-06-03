<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/taglibs.jsp"%>


<s:layout-render name="/WEB-INF/layouts/default.jsp">
    <s:layout-component name="contents">
    	<div id="editable_content">
        	${actionBean.html}
     	</div>
     	<c:if test="${actionBean.login.loggedIn}">
	     	
	     	<div id="editable_content_link">
	     		<s:link href="festivalv2.action.EditPageActionBean" event="edit" >
	     		  <s:param name="pageName" value="${actionBean.pageName}" />
	     		  Edit page: ${actionBean.pageName}
	     		</s:link>
	     	</div>
     	</c:if>
    </s:layout-component>
</s:layout-render>
