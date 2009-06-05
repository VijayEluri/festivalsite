<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/taglibs.jsp"%>


<s:layout-render name="/WEB-INF/layouts/default.jsp">
    <s:layout-component name="contents">
        	${actionBean.html}
    </s:layout-component>

    <s:layout-component name="extra-footer">

     	<c:if test="${actionBean.login.loggedIn}">
	     		<s:link beanclass="festivalv2.action.EditPageActionBean" event="edit" >
	     		  <s:param name="pageName" value="${actionBean.pageName}" />
	     		  Edit page: ${actionBean.pageName}
	     		</s:link>
     	</c:if>

    </s:layout-component>


</s:layout-render>
