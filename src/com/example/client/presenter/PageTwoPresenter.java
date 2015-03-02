package com.example.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PageTwoPresenter implements Presenter {
	public interface Display {
		Label getouputTextLabel();

		Widget asWidget();
	}

	private final Display display;
	private final HandlerManager eventBus;
	private final String value;

	public PageTwoPresenter(HandlerManager eventBus, Display display,
			String value) {
		this.display = display;
		this.eventBus = eventBus;
		this.value = value;

		this.display.getouputTextLabel().setText(this.value);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
}
