<%@include file="/WEB-INF/jsp/taglibs.jsp" %>
<%@page import="net.sourceforge.stripes.action.ForwardResolution"%>

<%

    ForwardResolution forwardResolution = new
ForwardResolution(festivalv2.action.LoadPageActionBean.class);
	forwardResolution.addParameter("page.pageName", "full-program");
    forwardResolution.execute(request, response);

%> 