var timeout    = 500;
var closetimer = 0;
var ddmenuitem = 0;

function jsddm_open()
{
  jsddm_canceltimer();
  jsddm_close();
  ddmenuitem = $(this).find('ul').css('visibility', 'visible');
}

function jsddm_close()
{
  if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');
}

function jsddm_timer()
{
  closetimer = window.setTimeout(jsddm_close, timeout);
}

function jsddm_canceltimer()
{  if(closetimer)
   {
     window.clearTimeout(closetimer);
     closetimer = null;
   }
}

document.onclick = jsddm_close;


function swap_banner_f()
{
  var banner_index = 0;
  var banner_urls = new Array('url(images/banner.jpg)','url(images/curtains.jpg)');
  return function(e)
  {
    banner_index = banner_index + 1;
    if (banner_index >= banner_urls.length)
    {
      banner_index = 0;
    }
    $('#banner').css('background-image', banner_urls[banner_index]);
  };
}
swap_banner_onclick = swap_banner_f();


$(document).ready(function()
		  {
		    $('#jsddm > li').bind('mouseover', jsddm_open);
		    $('#jsddm > li').bind('mouseout',  jsddm_timer);
		    $('#banner').bind("dblclick",swap_banner_onclick);

		    /*
		    $('#editable_content').bind("dblclick",
		      function(e){
			$.facebox($("#editable_content_link").get()[0].innerHTML);

			$(this).children('div.rawcontent').dialog(
			  {resizable: false,
			   dialogClass: 'editor',
			  modal: true,
			  width: 400,
			  overlay: { backgroundColor: "#000", opacity: 1 },
			  buttons:{ "Close": function() { $(this).hide(); } },
			  close: function(ev, ui) { $(this).hide();}
			  });

		     });
		     */
		  }

);


