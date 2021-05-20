package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.reintegro.profuturo.app.R;

import java.util.ArrayList;
import java.util.List;

public class EditText extends LinearLayoutCompat {
    private AppCompatEditText input;
    private AppCompatTextView label;
    private List<InputFilter> inputFilters = new ArrayList<>();
    private String inputHint;
    private String labelText;
    private View view;
    private float inputTextSize;
    private boolean inputLongClickable;
    private int inputImeOptions;
    private int inputInputType;
    private int inputMaxLength;
    private int inputTextColor;
    private int labelTextColor;

    public EditText(Context context) {
        super(context);
        init(context, null);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public String getText() {
        return input.getText().toString();
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        input.setCustomSelectionActionModeCallback(callback);
    }

    public void setLongClickable(boolean longClickable) {
        input.setLongClickable(longClickable);
    }

    public void setMaxLength(int maxLength) {
        input.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
    }

    public void setSelection(int selection) {
        input.setSelection(selection);
    }

    public void setText(String text) {
        input.setText(text);
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        input.addTextChangedListener(textWatcher);
    }

    private void init(Context context, AttributeSet attrs) {
        inputImeOptions = EditorInfo.IME_ACTION_NEXT;
        inputInputType = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL;
        inputLongClickable = true;

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.widget_edit_text, this, true);

        input = view.findViewById(R.id.input);
        label = view.findViewById(R.id.label);

        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EditText, 0, 0);

            for (int index = 0; index < typedArray.getIndexCount(); index++) {
                int attributeIndex = typedArray.getIndex(index);

                switch (attributeIndex) {
                    case R.styleable.EditText_android_imeOptions:
                        inputImeOptions = typedArray.getInteger(attributeIndex, EditorInfo.IME_ACTION_NEXT);
                        break;

                    case R.styleable.EditText_android_inputType:
                        inputInputType = typedArray.getInteger(attributeIndex, 0);
                        break;

                    case R.styleable.EditText_android_longClickable:
                        inputLongClickable = typedArray.getBoolean(attributeIndex, true);
                        break;

                    case R.styleable.EditText_android_maxLength:
                        inputMaxLength = typedArray.getInteger(attributeIndex, 0);
                        inputFilters.add(new InputFilter.LengthFilter(inputMaxLength));
                        break;

                    case R.styleable.EditText_inputHint:
                        inputHint = typedArray.getString(attributeIndex);
                        break;

                    case R.styleable.EditText_inputTextColor:
                        inputTextColor = typedArray.getColor(attributeIndex, 0);
                        break;

                    case R.styleable.EditText_inputTextSize:
                        inputTextSize = typedArray.getDimension(attributeIndex, 0);
                        break;

                    case R.styleable.EditText_labelText:
                        labelText = typedArray.getString(attributeIndex);
                        break;

                    case R.styleable.EditText_labelTextColor:
                        labelTextColor = typedArray.getColor(attributeIndex, 0);
                        break;
                }
            }

            typedArray.recycle();
        }

        input.getPaint().setTextSize(inputTextSize);
        input.setFilters(inputFilters.toArray(new InputFilter[0]));
        input.setHint(inputHint);
        input.setImeOptions(inputImeOptions);
        input.setInputType(inputInputType);
        input.setTextColor(inputTextColor);

        label.setText(labelText);
        label.setTextColor(labelTextColor);
    }
}
