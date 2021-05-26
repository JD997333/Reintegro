package com.reintegro.profuturo.app.android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.databinding.ItemRepaymentResultsBinding;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.ArrayList;
import java.util.List;

public class RepaymentResultsAdapter extends RecyclerView.Adapter<RepaymentResultsAdapter.ViewHolder>{
    private List<RepaymentDto> repaymentEvents = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public RepaymentResultsAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_repayment_results, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return repaymentEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemRepaymentResultsBinding viewDataBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
