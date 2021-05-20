package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.reintegro.profuturo.app.R;

public class TimelineView extends ConstraintLayout {
    public static final int POSITION_CAPTURE_SUMMARY = 0;
    public static final int POSITION_CCB_REQUEST = 1;
    public static final int POSITION_REGISTER_CAPTURE = 2;
    public static final int POSITION_SAVE_PROCEDURE = 3;

    private AppCompatImageView captureSummaryImageView;
    private AppCompatImageView ccbRequestImageView;
    private AppCompatImageView registerCaptureImageView;
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
            case POSITION_CAPTURE_SUMMARY:
                captureSummaryImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                ccbRequestImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                registerCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_CCB_REQUEST:
                captureSummaryImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                ccbRequestImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                registerCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_REGISTER_CAPTURE:
                captureSummaryImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                ccbRequestImageView.setImageResource(R.drawable.ic_navigation_indicator_next);
                registerCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_current);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_next);

                break;

            case POSITION_SAVE_PROCEDURE:
                captureSummaryImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                ccbRequestImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                registerCaptureImageView.setImageResource(R.drawable.ic_navigation_indicator_completed);
                saveProcedureImageView.setImageResource(R.drawable.ic_navigation_indicator_current);

                break;
        }
    }

    private void init(Context context) {
        LayoutInflater layoutInflater;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        view = layoutInflater.inflate(R.layout.widget_timeline, this, true);

        captureSummaryImageView = view.findViewById(R.id.capture_summary_image_view);
        ccbRequestImageView = view.findViewById(R.id.ccb_request_image_view);
        registerCaptureImageView = view.findViewById(R.id.register_capture_image_view);
        saveProcedureImageView = view.findViewById(R.id.save_procedure_image_view);
    }
}
