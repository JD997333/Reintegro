package com.reintegro.profuturo.app.android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.databinding.ItemRepaymentResultsBinding;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.ArrayList;
import java.util.List;

public class RepaymentResultsAdapter extends RecyclerView.Adapter<RepaymentResultsAdapter.ViewHolder>{
    private List<RepaymentDto> repaymentEvents = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private int selectedItemPosition = -1;
    private List<AppCompatRadioButton> radioButtons = new ArrayList<>();
    private OnItemSelectedListener radioButtonOnItemSelectedListener;

    public RepaymentResultsAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setRadioButtonOnItemSelectedListener(OnItemSelectedListener radioButtonOnItemSelectedListener) {
        this.radioButtonOnItemSelectedListener = radioButtonOnItemSelectedListener;
    }

    public void setRepaymentEvents(List<RepaymentDto> repaymentEvents) {
        this.repaymentEvents = repaymentEvents;
        notifyDataSetChanged();
    }

    private void toggleRadiobutton(int position) {
        selectedItemPosition = position;

        for (int index = 0; index < repaymentEvents.size(); index++) {
            AppCompatRadioButton radioButton;
            if (index < radioButtons.size()){
                radioButton = radioButtons.get(index);

                if (index == position) {
                    radioButton.setChecked(true);
                } else {
                    radioButton.setChecked(false);
                }
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_repayment_results, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RepaymentDto repaymentDto = repaymentEvents.get(position);

        if (position >= radioButtons.size()){
            radioButtons.add(holder.viewDataBinding.selectRadioButton);
        }

        holder.viewDataBinding.repaymentNumberTextView.setText(String.valueOf(repaymentDto.getEventNumber()));
        holder.viewDataBinding.trdDateTextView.setText(repaymentDto.getTrdDate().toDate());
        holder.viewDataBinding.discountedWeeksTextView.setText(String.valueOf(repaymentDto.getDiscountedWeeks()));
        holder.viewDataBinding.preRepaymentWeeksTextView.setText(String.valueOf(repaymentDto.getPreDiscountedWeeks()));
        holder.viewDataBinding.trdAmount.setText(repaymentDto.getTrdAmount());
        holder.viewDataBinding.preRepaymentAmountTextView.setText(repaymentDto.getPreRepaymentAmount());
        holder.viewDataBinding.selectRadioButton.setChecked(position == selectedItemPosition);
        holder.viewDataBinding.selectRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                toggleRadiobutton(position);
                radioButtonOnItemSelectedListener.onItemSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repaymentEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ItemRepaymentResultsBinding viewDataBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
