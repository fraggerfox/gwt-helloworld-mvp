package com.example.client.view;

import com.example.client.presenter.PageTwoPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PageTwoView extends Composite implements PageTwoPresenter.Display {

	private static PageTwoViewUiBinder uiBinder = GWT
			.create(PageTwoViewUiBinder.class);

	interface PageTwoViewUiBinder extends UiBinder<Widget, PageTwoView> {
	}

	public PageTwoView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label outputTextLabel;

	@Override
	public Label getouputTextLabel() {
		return outputTextLabel;
	}
	
	@Override
	public Widget asWidget() {
		return this;
	}
}
