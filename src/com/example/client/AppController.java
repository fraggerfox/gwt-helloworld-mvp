package com.example.client;

import com.example.client.event.PageOneEvent;
import com.example.client.event.PageOneEventHandler;
import com.example.client.presenter.PageOnePresenter;
import com.example.client.presenter.PageTwoPresenter;
import com.example.client.presenter.Presenter;
import com.example.client.view.PageOneView;
import com.example.client.view.PageTwoView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private HasWidgets container;
	private PageOneView pageOneView = null;

	public AppController(HandlerManager eventBus) {
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(PageOneEvent.TYPE, new PageOneEventHandler() {
			public void onValueSubmit(PageOneEvent event) {
				doPageTwo(event.getId());
			}
		});
	}

	private void doPageTwo(String value) {
		History.newItem("pagetwo", false);
		Presenter presenter = new PageTwoPresenter(eventBus, new PageTwoView(),
				value);
		presenter.go(container);
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("pageone");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			if (token.equals("pageone")) {
				if (pageOneView == null) {
					pageOneView = new PageOneView();

				}
				new PageOnePresenter(eventBus, pageOneView).go(container);
			}
		}

	}
}
