package com.reintegro.profuturo.app.util;

import android.content.Context;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.reintegro.profuturo.app.android.base.ActivityBase;
import com.reintegro.profuturo.app.api.converter.DateResponseConverter;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
            repaymentEntity.setTrdDate(DateResponseConverter.convertFromResponse("20080521", Constants.DATE_FORMAT_5));
            repaymentEntity.setDiscountedWeeks(4);
            repaymentEntity.setPreDiscountedWeeks(0);
            repaymentEntity.setTrdAmount(2800.00);
            repaymentEntity.setPreRepaymentAmount(0D);
            repaymentEntity.setRepaymentValueDay(100.00);
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

    public static File decodeBase64(String base64, String fileName) {
        File file;
        file = null;

        try {
            byte[] bytes;
            bytes = Base64.decode(base64, Base64.DEFAULT);

            file = File.createTempFile(fileName, Constants.FILE_EXTENSION_PDF);
            file.createNewFile();

            FileOutputStream fileOutputStream;
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return file;
    }

    public static RepaymentEntity getRepaymentDummy(){
        RepaymentEntity repaymentEntity;
        repaymentEntity = new RepaymentEntity();
        repaymentEntity.setAforeKey("534");
        repaymentEntity.setBenefitType("66");
        repaymentEntity.setDiagnoseProcess("");
        repaymentEntity.setDiscountedWeeks(12);
        repaymentEntity.setEventNumber(2);
        repaymentEntity.setNss("68907520180");
        repaymentEntity.setOperationResult("01");
        repaymentEntity.setPreDiscountedWeeks(0);
        repaymentEntity.setPreRepaymentAmount(0.0);
        repaymentEntity.setRepaymentValueDay(123.41);
        repaymentEntity.setRequestedWeeks(0);
        repaymentEntity.setResolutionNumber("005813");
        repaymentEntity.setSelected(false);
        repaymentEntity.setTrdAmount(10366.44);
        repaymentEntity.setTrdDate(DateResponseConverter.convertFromResponse("20200903", Constants.DATE_FORMAT_5));

        return repaymentEntity;
    }

    public static String formatAmountToMoney(Double amount){
        DecimalFormat amountFormat = new DecimalFormat("#,###.00");
        DecimalFormat zeroAmountFormat = new DecimalFormat("0,000.00");

        if (amount == 0.0){
            return "$" + zeroAmountFormat.format(amount);
        }else {
            return "$" + amountFormat.format(amount);
        }
    }

    public static List<String> getIdentificationTypes(){
        List<String> idTypes = new ArrayList<>();
        idTypes.add(Constants.ID_TYPE_INE);
        idTypes.add(Constants.ID_TYPE_PASSPORT);
        idTypes.add(Constants.ID_TYPE_MILITARY);
        idTypes.add(Constants.ID_TYPE_PROFESSIONAL);
        idTypes.add(Constants.ID_TYPE_MIGRATION_DOC);

        return idTypes;
    }
}
