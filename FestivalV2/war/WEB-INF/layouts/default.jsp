<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>

<stripes:layout-definition>

<head>
<title> Codsall Community Arts Festival </title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" href="greenpage.css" type="text/css"	media="screen" />
<link rel="stylesheet" href="print.css" type="text/css" media="print" />
<script type="text/javascript">
var timeout    = 500;
var closetimer = 0;
var ddmenuitem = 0;

function jsddm_open()
{  jsddm_canceltimer();
   jsddm_close();
   ddmenuitem = $(this).find('ul').css('visibility', 'visible');}

function jsddm_close()
{  if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');}

function jsddm_timer()
{  closetimer = window.setTimeout(jsddm_close, timeout);}

function jsddm_canceltimer()
{  if(closetimer)
   {  window.clearTimeout(closetimer);
      closetimer = null;}}

$(document).ready(function()
{  $('#jsddm > li').bind('mouseover', jsddm_open)
   $('#jsddm > li').bind('mouseout',  jsddm_timer)});

document.onclick = jsddm_close;

function swap_banner_f(){
	var banner_index = 0;
	var banner_urls = new Array('url(images/banner.jpg)','url(images/curtains.jpg)');
	return function(e){
		banner_index = banner_index + 1;
		if (banner_index >= banner_urls.length){
			banner_index = 0;
		}
		$('#banner').css('background-image', banner_urls[banner_index]);
	};
}
swap_banner_onclick = swap_banner_f();
$(document).ready(function(){
	$('#banner').bind("mouseenter",swap_banner_onclick);


	 });

</script>
</head>
<body>
<div id="page-panel">
	<div id="banner"><img src="images/ccaf-small.png" alt="ccaf logo"
		class="header-logo" align="left" />
		<h1>Codsall Community Arts Festival</h1>
	</div>
	<div id="post-banner" />
		<div id="menu">
		<ul id="jsddm">
			<li><a href="index.jsp">Home</a>
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
    <div id="post-menu" />
	<div id="body">
         <stripes:layout-component name="contents"/>
	</div>
	
	
	<div id="bottom"></div>
	<div id="footer">
	<img src="images/southstaffs.gif" class="logo" alt="South Staffs Council"/>
	<img src="images/scclogo-sm.gif" class="logo" alt="Staffs Council"/>
	&#099;&#111;&#100;&#115;&#097;&#108;&#108;&#097;&#114;&#116;&#115;&#102;&#101;&#115;&#116;&#105;&#118;&#097;&#108;&#064;&#103;&#111;&#111;&#103;&#108;&#101;&#109;&#097;&#105;&#108;&#046;&#099;&#111;&#109;
	<br />  Registered Charity #1127064
	<br />  Admin Login
	</div>
</div>
</body>
</stripes:layout-definition>

