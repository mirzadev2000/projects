package com.example.bookstoreapplication;

import javafx.event.Event;
import javafx.event.EventType;

public class BookstoreEvent extends Event {

    public BookstoreEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static final EventType<BookstoreEvent> createScene = new EventType<>("createScene");
    public static final EventType<BookstoreEvent> overviewScene = new EventType<>("overviewScene");
}
