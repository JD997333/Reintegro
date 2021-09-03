package com.reintegro.profuturo.app.navigation;

public interface NavigationDelegate<T> {
    void popToGreeting();
    void popToSearchClient();
    void popToInitialCapture();
    void pushGreeting();
    void pushSearchClient();
    void pushSearchResults();
    void pushClientDataImmediately();
    void pushInitialCapture();
    void pushSelectApplicant();
    void pushSelectApplicantNoGone();
    void pushRepaymentEventsDetail();
    void pushDocumentsCapture();
    void pushBiometricCapture();
}
