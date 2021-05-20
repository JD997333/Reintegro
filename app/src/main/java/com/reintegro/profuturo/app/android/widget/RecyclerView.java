package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecyclerView extends androidx.recyclerview.widget.RecyclerView {
    public abstract static class Adapter<T extends ViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<T> {
        public interface OnItemSelectedListener {
            void onItemSelected(int position);
        }

        protected OnItemSelectedListener onItemSelectedListener;

        public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.onItemSelectedListener = onItemSelectedListener;
        }
    }

    public RecyclerView(@NonNull Context context) {
        super(context);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
