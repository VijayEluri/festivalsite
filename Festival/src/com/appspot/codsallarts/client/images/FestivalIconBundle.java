package com.appspot.codsallarts.client.images;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

public interface FestivalIconBundle extends ImageBundle {

	  /**
	   */
	@Resource("gwtLogo.png")
	  AbstractImagePrototype loadingLarge();
	  
	  /**
	   * Would match either file 'newFileIcon.gif' or 'newFileIcon.png' in the same package as this type. Note that other file extensions may also be recognized.
	   * 
	   */
	@Resource("gwtLogo.png")
	  AbstractImagePrototype loading();

	}