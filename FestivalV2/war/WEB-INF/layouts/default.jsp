<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/taglibs.jsp" %>
<s:layout-definition>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title> Codsall Community Arts Festival </title>
<script src="js/jquery-1.3.2.min.js" ></script>
<script src="js/default.js" ></script>
<link rel="stylesheet" href="greenpage.css" type="text/css"	 />
<!--  <link rel="stylesheet" href="print.css" type="text/css" media="print" /> -->
</head>
<body>
<div id="page-panel">
	<div id="banner"><img src="images/ccaf-small.png" alt="ccaf logo" class="header-logo" align="left" >
		<h1>Codsall Community Arts Festival</h1>
	</div>
	<div id="menu">
		<ul id="jsddm">
			<li><a href="index.jsp">Home</a></li>
			</li>
			<li><a href="programme.jsp">Programme</a></li>	
			<li class="parent"><a href="#">Events In Detail</a>	
				<ul>
					<li><a href="e_drama.jsp">Drama</a></li>
					<li><a href="e_music.jsp">Music</a></li>
					<li><a href="e_talks.jsp">Talks</a></li>
		            <li><a href="e_photography.jsp">Photography</a></li>
		            <li><a href="e_artsandcrafts.jsp">Arts &amp; Crafts </a></li>	           
				</ul>
			</li>			
			<li><a href="e_photography.jsp">Competition</a></li>
			<li><a href="tickets.jsp">Tickets</a></li>
			<li><a href="find-us.jsp">Find Us</a></li>
			<li class="parent"><a href="#">Supporters</a>
				<ul>
					<li><a href="patrons.jsp">Patrons</a></li>
					<li><a href="sponsors.jsp">Sponsors</a></li>
					<li><a href="advertisers.jsp">Advertisers</a></li>
					<li><a href="others.jsp">Others</a></li>
	
				</ul>
			</li>
				<li class="parent"><a href="#">About Us</a>
				<ul>
					<li><a href="committee.jsp">Committee</a></li>
					<li><a href="history.jsp">History</a></li>
					<li><a href="contact-us.jsp">Contact Us</a></li>
				</ul>
			<li><a href="previous-events.jsp">Previous Events</a></li>
			<li><a class="last" href="fringe.jsp">Fringe</a></li>
 
		</ul>
	</div>
	

	
	
	<div id="body">
	<c:choose>
        <c:when test='${actionBean.messageAvailable}'>
			<div id="errors">
	     		<ul>
	     		   <c:forEach var="message" items="${actionBean.messages}">
				     <li>
						${message}
				     </li>
   					</c:forEach>
				</ul>
	     		</div>
			
        </c:when>
    </c:choose>

         <s:layout-component name="contents"/>
    </div>
	
	
	<div id="bottom"></div>
	<div id="footer">
	<a href="http://www.staffordshire.gov.uk/yourcouncil/slcf/"><img src="images/slcf-logo.jpg" class="logo" alt="Staffs Local Community Fund" /></a>
	<a href="http://www.sstaffs.gov.uk/"><img src="images/southstaffs.gif" class="logo" alt="South Staffs Council"/></a>
	<a href="http://www.staffordshire.gov.uk/"><img src="images/newscc.png" class="logo" alt="Staffs Council"/></a>
	<a href="http://www.midcounties.coop/"><img src="images/coop.png" class="logo" alt="Mid Counties Co-op"/></a>
	<br clear="both"/>
	<br />
	 Registered Charity No. 1127064
	&bull; 
	Email: &#099;&#111;&#100;&#115;&#097;&#108;&#108;&#097;&#114;&#116;&#115;&#102;&#101;&#115;&#116;&#105;&#118;&#097;&#108;&#064;&#103;&#111;&#111;&#103;&#108;&#101;&#109;&#097;&#105;&#108;&#046;&#099;&#111;&#109;
	&bull;   
	
	<c:choose>
        <c:when test='${actionBean.login.loggedIn}'>
            <a href="${actionBean.login.logoutUrl}">Admin logout</a>            
        </c:when>
        <c:otherwise>
            <a href="${actionBean.login.loginUrl}">Admin login</a>
        </c:otherwise>
    </c:choose>
	<br />  
         <s:layout-component name="extra_footer"/>

	
	
	</div>
</div>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ?
"https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost +
"google-analytics.com/ga.js'
type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-12376778-1");
pageTracker._trackPageview();
} catch(err) {}</script>
<center><a href="http://www.tinycounter.com" target="_blank" title="free hit counter"><img border="0" alt="free hit counter" src="http://mycounter.tinycounter.com/index.php?user=fmkingst"></a></center>
</body>
</html>
</s:layout-definition>
