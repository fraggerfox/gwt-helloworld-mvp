package com.example.client.presenter;

import com.example.client.event.PageOneEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class PageOnePresenter implements Presenter {
	public interface Display {
		HasClickHandlers getSubmitButtonClickHandler();

		HasValue<String> getinputTextValue();

		Widget asWidget();
	}

	private final Display display;
	private final HandlerManager eventBus;

	public PageOnePresenter(HandlerManager eventBus, Display display) {
		this.display = display;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		this.display.getSubmitButtonClickHandler().addClickHandler(
				new ClickHandler() {
					public void onClick(ClickEvent event) {
						doValueVerify();
					}
				});
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private void doValueVerify() {
		String value = this.display.getinputTextValue().getValue();
		if (value.length() > 0) {
			eventBus.fireEvent(new PageOneEvent(value));
		}
	}
}
