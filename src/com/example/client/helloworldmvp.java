package com.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class helloworldmvp implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(eventBus);
		appViewer.go(RootPanel.get());
	}
}
