package com.reintegro.profuturo.app.navigation;

import java.util.HashMap;

public class NavigationState<T> {
    public static final String PAGE_CERTIFIED_ACCOUNTS = "PAGE_CERTIFIED_ACCOUNTS";
    public static final String PAGE_CLIENT_DATA = "PAGE_CLIENT_DATA";
    public static final String PAGE_DOCUMENT_CAPTURE = "PAGE_DOCUMENT_CAPTURE";
    public static final String PAGE_GREETING = "PAGE_GREETING";
    public static final String PAGE_REGISTER_CAPTURE = "PAGE_REGISTER_CAPTURE";
    public static final String PAGE_REGISTER_CAPTURE_SUMMARY = "PAGE_REGISTER_CAPTURE_SUMMARY";
    public static final String PAGE_SAVE_PROCEDURE = "PAGE_SAVE_PROCEDURE";
    public static final String PAGE_SEARCH_CLIENT = "PAGE_SEARCH_CLIENT";
    public static final String PAGE_SEARCH_RESULTS = "PAGE_SEARCH_RESULTS";
    public static final String PAGE_REPAYMENT_EVENTS = "PAGE_REPAYMENT_EVENTS";
    public static final String PAGE_SELECT_APPLICANTS = "PAGE_SELECT_APPLICANTS";
    public static final String PAGE_REPAYMENT_EVENT_DETAIL = "PAGE_REPAYMENT_EVENT_DETAIL";

    private HashMap<String, T> state = new HashMap<>();

    public T getState(String page) {
        return state.get(page);
    }

    public void putState(String page, T state) {
        this.state.put(page, state);
    }
}