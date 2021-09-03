package com.reintegro.profuturo.app.android.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ApplicantTypesAdapter extends ArrayAdapter<String> {
    private List<String> mApplicantTypes;

    public ApplicantTypesAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return mApplicantTypes == null ? 0 : mApplicantTypes.size() + 1;
    }


    @Nullable
    @Override
    public String getItem(int position) {
        if (position == 0) {
            return "Seleccione una opción";
        } else {
            return mApplicantTypes.get(position - 1);
        }
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;

        if (position == 0) {
            TextView textView = new TextView(getContext());
            textView.setHeight(4);
            textView.setVisibility(View.GONE);
            view = textView;
        } else {

            view = super.getDropDownView(position, null, parent);
        }

        return view;
    }

    public void setApplicantTypes(List<String> applicantTypes){
        this.mApplicantTypes = applicantTypes;
        notifyDataSetChanged();
    }
}
