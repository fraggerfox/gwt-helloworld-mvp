package com.example.client.view;

import com.example.client.presenter.PageOnePresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PageOneView extends Composite implements PageOnePresenter.Display {

	private static PageOneViewUiBinder uiBinder = GWT
			.create(PageOneViewUiBinder.class);

	interface PageOneViewUiBinder extends UiBinder<Widget, PageOneView> {
	}

	public PageOneView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox inputText;
	@UiField
	Button submitButton;
	
	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasClickHandlers getSubmitButtonClickHandler() {
		return submitButton;
	}

	@Override
	public HasValue<String> getinputTextValue() {
		return inputText;
	}
}
