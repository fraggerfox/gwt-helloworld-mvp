A "Hello, World!" MVP for GWT
=============================

After going through multiple documents online for GWT and reading upon the
recommended MVP pattern for GWT, I found out that setting up the amount of 
classes and interfaces needed to bootstrap a simple GWT application that follows 
the pattern is quite tedious everytime. So wrote some boilerplate code that can
help me with creating new applications.

The program consists of a simple textbox that takes any non-zero length input
and then echos back the string in the next page with a "Hello," prepended to
that text.

## Features provided by the sample "Hello, World!"

1. Implements a simple Application controller in AppController.java
2. Implements an eventBus using the internal GWT eventBus
3. Implements the basic Presenter interface, and a couple of Presenters for 
PageOne and PageTwo
4. Implements the Views for PageOne and PageTwo using the UIBinder interface.
5. Implements a basic Event handler Interface for PageOne which is captured in
Application Controller

## Notes

The application leaves "shared" and "server" packages empty since the focus of
the example is to demonstrate the MVP, but the packages are kept empty for
consistency purposes, especially when creating example applications using
WebAppCreator

Also there is no GWT RPC class implemented in any of the classes which will be
required incase this boilerplate code is planned to be used with a RPC backend.