package com.reintegro.profuturo.app.domain.state;

import com.reintegro.profuturo.app.contract.SelectApplicantContract;

public class SelectApplicantState implements SelectApplicantContract.State {
    private boolean biometricIndicatorEnabled;
    private boolean expedientIndicatorEnabled;
    private boolean isOwnerApplicant;

    @Override
    public void setBiometricIndicatorEnabled(boolean enabled) {
        this.biometricIndicatorEnabled = enabled;
    }

    @Override
    public void setExpedientIndicatorEnabled(boolean enabled) {
        this.expedientIndicatorEnabled = enabled;
    }

    @Override
    public void setIsOwnerApplicant(boolean isOwnerApplicant) {
        this.isOwnerApplicant = isOwnerApplicant;
    }

    @Override
    public boolean isOwnerApplicant() {
        return isOwnerApplicant;
    }

    @Override
    public boolean isBiometricIndicatorEnabled() {
        return biometricIndicatorEnabled;
    }

    @Override
    public boolean isExpedientIndicatorEnabled() {
        return expedientIndicatorEnabled;
    }
}
