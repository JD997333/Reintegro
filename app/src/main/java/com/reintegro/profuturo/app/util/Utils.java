package com.reintegro.profuturo.app.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.reintegro.profuturo.app.android.base.ActivityBase;
import com.reintegro.profuturo.app.api.converter.DateResponseConverter;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void hideSoftKeyboard(ActivityBase activity) {
        View view = activity.getCurrentFocus();

        InputMethodManager iim = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        assert view != null;
        if (iim != null && view != null)
            iim.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static List<RepaymentEntity> getMockRepaymentEvents(){
        List<RepaymentEntity> repaymentEvents = new ArrayList<>();
        RepaymentEntity repaymentEntity;
        for(int i = 0; i < 7; i++){
            repaymentEntity = new RepaymentEntity();
            repaymentEntity.setEventNumber(i + 1);
            repaymentEntity.setTrdDate(DateResponseConverter.convertFromResponse("2008/05/21", Constants.DATE_FORMAT_4));
            repaymentEntity.setDiscountedWeeks("4");
            repaymentEntity.setPreDiscountedWeeks(0);
            repaymentEntity.setTrdAmount("$52,400.00");
            repaymentEntity.setPreRepaymentAmount("$0,000.00");
            repaymentEvents.add(repaymentEntity);
        }

        return repaymentEvents;
    }

    public static String formatClientAccountNumber(String clientAccountNumber) {
        StringBuilder formatedClientAccountNumber;
        formatedClientAccountNumber = new StringBuilder();

        int missingZeros;
        missingZeros = 10 - clientAccountNumber.length();

        for (int index = 0; index < missingZeros; index++) {
            formatedClientAccountNumber.append(0);
        }

        formatedClientAccountNumber.append(clientAccountNumber);

        return formatedClientAccountNumber.toString();
    }
}
