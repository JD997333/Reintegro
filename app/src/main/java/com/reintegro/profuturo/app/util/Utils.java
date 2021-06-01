package com.reintegro.profuturo.app.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.reintegro.profuturo.app.android.base.ActivityBase;
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

    public static List<RepaymentDto> getMockRepaymentEvents(){
        List<RepaymentDto> repaymentEvents = new ArrayList<>();
        RepaymentDto repaymentDto;
        for(int i = 0; i < 3; i++){
            repaymentDto = new RepaymentDto();
            repaymentDto.setEventNumber(i + 1);
            repaymentDto.setTrdDate("26/05/2008");
            repaymentDto.setDiscountedWeeks(4);
            repaymentDto.setPreDiscountedWeeks(0);
            repaymentDto.setTrdAmount("$52,400.00");
            repaymentDto.setPreRepaymentAmount("$0,000.00");
            repaymentEvents.add(repaymentDto);
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
