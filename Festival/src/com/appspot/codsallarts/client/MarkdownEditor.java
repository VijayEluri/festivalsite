package com.appspot.codsallarts.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class MarkdownEditor extends DialogBox {

	private class MarkdownEditorClickHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			Widget sender = (Widget)event.getSource();
			if (sender == saveButton){
				MarkdownEditor.this.handler.save(textArea.getText());
			} else if (sender == previewButton){
				MarkdownEditor.this.handler.preview(textArea.getText());
			} else if (sender == cancelButton){
				MarkdownEditor.this.handler.cancel();
			}
		}

	}
	
	public interface MarkdownHandler {
		public void save(String markdown);
		public void preview(String markdown);
		public void cancel();
	}
	private MarkdownHandler handler;
	
	public MarkdownEditor(MarkdownHandler handler, String content){
		this.handler = handler;
		this.setText("Markdown Editor");
		Grid layout = new Grid(3,1);
		HorizontalPanel buttonBar = new HorizontalPanel();
		ClickHandler clickHandler = new  MarkdownEditor.MarkdownEditorClickHandler();
		buttonBar.add(saveButton = new Button("Save", clickHandler));
		buttonBar.add(previewButton = new Button("Preview", clickHandler));
		buttonBar.add(cancelButton = new Button("Cancel", clickHandler));
		layout.setWidget(0,0,buttonBar);
		
		textArea = new TextArea();
		textArea.setText(content);		
		textArea.setSize("40em", "300px");
		layout.setWidget(1,0,textArea);
		
		HTML previewArea = new HTML();
		previewArea.setHTML(MarkdownConverter.convertText(previewMarkdown));
		layout.setWidget(2,0,previewArea);
		this.add(layout);
		
	}

	private Button saveButton;
	private Button previewButton;
	private Button cancelButton;
	private TextArea textArea;
	private String previewMarkdown = "## Heading 2\n\\## Heading 2\n";
}
