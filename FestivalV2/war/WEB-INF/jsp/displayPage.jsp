<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/layouts/default.jsp">
    <s:layout-component name="contents">
        Hello ${actionBean.pageName}: ${actionBean.content}
    </s:layout-component>
</s:layout-render>
