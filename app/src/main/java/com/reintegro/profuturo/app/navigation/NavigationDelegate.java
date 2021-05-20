package com.reintegro.profuturo.app.navigation;

public interface NavigationDelegate<T> {
    void pushFirstFragment();
    void pushSecondFragment();
    void popToGreeting();
    void popToSearchClient();
    void pushGreeting();
    void pushSearchClient();
    void pushSearchResults();
    void pushClientDataImmediately();
}
