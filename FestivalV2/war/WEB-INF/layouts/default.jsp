<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/taglibs.jsp" %>
<s:layout-definition>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title> Codsall Community Arts Festival </title>
<script src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js" ></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js" ></script>
<script src="js/default.js" ></script>
<link rel="stylesheet" href="greenpage.css" type="text/css"	media="screen" />
<link rel="stylesheet" href="print.css" type="text/css" media="print" />
<link href="facebox/facebox.css" media="screen" rel="stylesheet" type="text/css"/>
<script src="facebox/facebox.js" type="text/javascript"></script> 
</head>
<body>
<div id="page-panel">
	<div id="banner"><img src="images/ccaf-small.png" alt="ccaf logo"
		class="header-logo" align="left" />
		<h1>Codsall Community Arts Festival</h1>
	</div>
	<div id="post-banner"></div>
	<div id="menu">
		<ul id="jsddm">
			<li><a href="index.jsp">Home</a></li>
				<li class="parent"><a href="#">About Us</a>
				<ul>
					<li><a href="committee.jsp">Committee</a></li>
					<li><a href="history.jsp">History</a></li>
				</ul>
			</li>
			<li><a href="at-a-glance.jsp">At-a-Glance</a></li>
			<li><a href="full-program.jsp" class="wide">Full Programme</a></li>
			<li><a href="tickets.jsp">Tickets</a></li>
			<li class="parent"><a href="#">Supporters</a>
			<ul>
				<li><a href="patrons.jsp">Patrons</a></li>
				<li><a href="sponsors.jsp">Sponsors</a></li>
			</ul>
			</li>
		
		
			<li><a href="find-us.jsp">Find Us</a></li>
			<li><a class="last wide" href="previous-events.jsp">Previous Events</a></li>
		
		</ul>
	</div>
    <div id="post-menu" ></div>
	<div id="body">
         <s:layout-component name="contents"/>
    </div>
	
	
	<div id="bottom"></div>
	<div id="footer">
	<img src="images/southstaffs.gif" class="logo" alt="South Staffs Council"/>
	<img src="images/scclogo-sm.gif" class="logo" alt="Staffs Council"/>
	&#099;&#111;&#100;&#115;&#097;&#108;&#108;&#097;&#114;&#116;&#115;&#102;&#101;&#115;&#116;&#105;&#118;&#097;&#108;&#064;&#103;&#111;&#111;&#103;&#108;&#101;&#109;&#097;&#105;&#108;&#046;&#099;&#111;&#109;
	<br />  Registered Charity #1127064
	<br />  
	
	<c:choose>
        <c:when test='${actionBean.login.loggedIn}'>
            <a href="${actionBean.login.logoutUrl}">Admin logout</a>            
        </c:when>
        <c:otherwise>
            <a href="${actionBean.login.loginUrl}">Admin login</a>
        </c:otherwise>
    </c:choose>

	
	
	</div>
</div>
</body>
</html>
</s:layout-definition>
