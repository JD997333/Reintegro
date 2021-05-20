package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.reintegro.profuturo.app.R;

public class Spinner extends LinearLayoutCompat {
    private AppCompatSpinner spinner;
    private AppCompatTextView label;
    private LinearLayoutCompat parent;
    private LinearLayoutCompat spinnerParent;
    private String labelText;
    private View view;
    private boolean showLabel;
    private int labelTextColor;

    private View.OnLayoutChangeListener parentOnLayoutListener = (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
        spinner.setDropDownVerticalOffset(spinnerParent.getHeight());
        spinner.setDropDownWidth(parent.getWidth());
    };

    private View.OnLayoutChangeListener spinnerOnLayoutListener = (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
        if (spinner.getChildCount() != 0) {
            spinner.getChildAt(0).setBackground(null);
        }
    };

    private View.OnClickListener spinnerParentOnClickListener = (spinnerParentView) -> {
        spinner.performClick();
    };

    public Spinner(Context context) {
        super(context);
        init(context, null);
    }

    public Spinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Spinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void setAdapter(SpinnerAdapter adapter) {
        spinner.setAdapter(adapter);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        spinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setSelection(int position) {
        spinner.setSelection(position);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.widget_spinner, this, true);

        label = view.findViewById(R.id.label);
        parent = view.findViewById(R.id.parent);
        spinner = view.findViewById(R.id.spinner);
        spinnerParent = view.findViewById(R.id.spinner_parent);

        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Spinner, 0, 0);

            for (int index = 0; index < typedArray.getIndexCount(); index++) {
                int attributeIndex = typedArray.getIndex(index);

                switch (attributeIndex) {
                    case R.styleable.Spinner_labelText:
                        labelText = typedArray.getString(attributeIndex);
                        break;

                    case R.styleable.Spinner_labelTextColor:
                        labelTextColor = typedArray.getColor(attributeIndex, 0);
                        break;

                    case R.styleable.Spinner_showLabel:
                        showLabel = typedArray.getBoolean(attributeIndex, false);
                        break;
                }
            }

            typedArray.recycle();
        }

        label.setText(labelText);
        label.setTextColor(labelTextColor);
        label.setVisibility(showLabel ? View.VISIBLE : View.GONE);

        parent.addOnLayoutChangeListener(parentOnLayoutListener);

        spinner.addOnLayoutChangeListener(spinnerOnLayoutListener);

        spinnerParent.setOnClickListener(spinnerParentOnClickListener);
    }
}
