package com.example.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PageOneEvent extends GwtEvent<PageOneEventHandler> {
	public static Type<PageOneEventHandler> TYPE = new Type<PageOneEventHandler>();
	private final String value;

	public PageOneEvent(String value) {
		this.value = value;
	}

	public String getId() {
		return value;
	}

	@Override
	public Type<PageOneEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PageOneEventHandler handler) {
		handler.onValueSubmit(this);
	}
}
