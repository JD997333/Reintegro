package com.reintegro.profuturo.app.android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.databinding.ItemSearchResultsBinding;
import com.reintegro.profuturo.app.domain.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<ClientDto> searchResults = new ArrayList<>();
    private List<AppCompatRadioButton> radioButtons = new ArrayList<>();
    private OnItemSelectedListener radioButtonOnItemSelectedListener;
    private int selectedItemPosition = -1;

    public SearchResultsAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setRadioButtonOnItemSelectedListener(OnItemSelectedListener radioButtonOnItemSelectedListener) {
        this.radioButtonOnItemSelectedListener = radioButtonOnItemSelectedListener;
    }

    public void setSearchResults(List<ClientDto> searchResults) {
        this.searchResults = searchResults;
        notifyDataSetChanged();
    }

    private void toggleRadiobutton(int position) {
        selectedItemPosition = position;

        for (int index = 0; index < searchResults.size(); index++) {
            AppCompatRadioButton radioButton;
            radioButton = radioButtons.get(index);

            if (index == position) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_search_results, parent, false));
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClientDto clientDto;
        clientDto = searchResults.get(position);

        if (position >= radioButtons.size()) {
            radioButtons.add(holder.viewDataBinding.selectionRadioButton);
        }

        holder.viewDataBinding.accountNumberTextView.setText(clientDto.getAccountNumber());
        holder.viewDataBinding.curpTextView.setText(clientDto.getCurp());
        holder.viewDataBinding.nameTextView.setText(clientDto.getFullName());
        holder.viewDataBinding.nssTextView.setText(clientDto.getNss());
        holder.viewDataBinding.parent.setOnClickListener((view) -> {
            toggleRadiobutton(position);
            onItemSelectedListener.onItemSelected(position);
        });
        holder.viewDataBinding.rfcTextView.setText(clientDto.getRfc());
        holder.viewDataBinding.selectionRadioButton.setChecked(position == selectedItemPosition);
        holder.viewDataBinding.selectionRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleRadiobutton(position);
                radioButtonOnItemSelectedListener.onItemSelected(position);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemSearchResultsBinding viewDataBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
