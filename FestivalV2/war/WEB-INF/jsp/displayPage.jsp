<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/taglibs.jsp"%>


<s:layout-render name="/WEB-INF/layouts/default.jsp">
    <s:layout-component name="contents">
        	${actionBean.html}
    </s:layout-component>

    <s:layout-component name="extra_footer">

     	<c:if test="${actionBean.login.loggedIn}">
	     		<s:link beanclass="festivalv2.action.LoadPageActionBean" event="edit" >
	     		  <s:param name="page.pageName" value="${actionBean.page.pageName}" />
	     		  <s:param name="page.id" value="${actionBean.page.id}" />
	     		  Edit page: ${actionBean.page.pageName}
	     		</s:link>
	    		<br/>
	    		<a id="oldversion_trigger" href="#">Older versions</a>
	     		<div id="oldversions">
	     		<ul>
	     		   <c:forEach var="version" items="${actionBean.allPages}">
				     <li>
			     		<s:link beanclass="festivalv2.action.LoadPageActionBean" >
			     		  <s:param name="page.id" value="${version.id}" />
			     		  <s:param name="page.pageName" value="${version.pageName}" />
			     		  ${version.createdAt}
			     		</s:link>
				     
				     </li>
   					</c:forEach>
				</ul>
	     		</div>
     	</c:if>

    </s:layout-component>


</s:layout-render>
