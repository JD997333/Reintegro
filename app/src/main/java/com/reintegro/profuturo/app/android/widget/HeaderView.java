package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.reintegro.profuturo.app.R;

public class HeaderView extends LinearLayoutCompat {
    private AppCompatTextView label;
    private String labelText;
    private View view;
    private float labelTextSize;
    private int labelTextColor;

    public HeaderView(Context context) {
        super(context);
        init(context, null);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.widget_header_view, this);

        label = view.findViewById(R.id.label);

        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0);

            for (int index = 0; index < typedArray.getIndexCount(); index++) {
                int attributeIndex = typedArray.getIndex(index);

                switch (attributeIndex) {
                    case R.styleable.HeaderView_labelText:
                        labelText = typedArray.getString(attributeIndex);
                        break;

                    case R.styleable.HeaderView_labelTextColor:
                        labelTextColor = typedArray.getColor(attributeIndex, 0);
                        break;

                    case R.styleable.HeaderView_labelTextSize:
                        labelTextSize = typedArray.getDimension(attributeIndex, 0);
                        break;
                }
            }

            typedArray.recycle();
        }

        label.getPaint().setTextSize(labelTextSize);
        label.setText(labelText);
        label.setTextColor(labelTextColor);
    }
}

