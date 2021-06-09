package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.reintegro.profuturo.app.R;

public class TimelineView extends ConstraintLayout {
    public static final int POSITION_INITIAL_CAPTURE = 0;
    public static final int POSITION_REPAYMENT_EVENTS = 1;
    public static final int POSITION_DOCUMENTS_CAPTURE = 2;
    public static final int POSITION_BIOMETRICS_CAPTURE = 3;
    public static final int POSITION_SAVE_PROCEDURE = 4;

    private AppCompatImageView initialCaptureImageView;
    private AppCompatImageView repaymentAmountImageView;
    private AppCompatImageView documentsCaptureImageView;
    private AppCompatImageView biometricCaptureImageView;
    private AppCompatImageView saveProcedureImageView;

    public TimelineView(Context context) {
        super(context);
        init(context);
    }

    public TimelineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TimelineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setCurrentPosition(int position) {
        switch (position) {
            case POSITION_INITIAL_CAPTURE:
                initialCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                repaymentAmountImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                documentsCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                biometricCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_REPAYMENT_EVENTS:
                initialCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                repaymentAmountImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                documentsCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                biometricCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_DOCUMENTS_CAPTURE:
                initialCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                repaymentAmountImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                documentsCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                biometricCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_BIOMETRICS_CAPTURE:
                initialCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                repaymentAmountImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                documentsCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                biometricCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_SAVE_PROCEDURE:
                initialCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                repaymentAmountImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                documentsCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                biometricCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_current);

                break;
        }
    }

    private void init(Context context) {
        LayoutInflater layoutInflater;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        view = layoutInflater.inflate(R.layout.widget_timeline, this, true);

        initialCaptureImageView = view.findViewById(R.id.initial_capture_image_view);
        repaymentAmountImageView = view.findViewById(R.id.repayment_amount_image_view);
        documentsCaptureImageView = view.findViewById(R.id.documents_capture_image_view);
        biometricCaptureImageView = view.findViewById(R.id.biometric_capture_image_view);
        saveProcedureImageView = view.findViewById(R.id.save_procedure_image_view);
    }
}
