package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.SearchClientContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentSearchClientBinding;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;
import com.reintegro.profuturo.app.domain.interactor.SearchClientInteractor;
import com.reintegro.profuturo.app.presenter.SearchClientPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

public class SearchClientFragment extends NavigationAdapter.Fragment implements SearchClientContract.View {

    private FragmentSearchClientBinding viewDataBinding;
    private SearchClientContract.Presenter presenter;

    View.OnClickListener searchOnClickListener = (view) -> {
        SearchClientDto searchClientDto;
        searchClientDto = new SearchClientDto();
        searchClientDto.setAccountNumber(viewDataBinding.accountNumberEditText.getText());
        searchClientDto.setCurp(null);
        searchClientDto.setNss(null);

        presenter.onClickSearch(searchClientDto);
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SearchClientContract.Interactor interactor;
        interactor = new SearchClientInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new SearchClientPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_client, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.searchButton.setOnClickListener(searchOnClickListener);
    }

    @Override
    public void pushSearchResults() {
        setBackEnabled(false);
        navigationDelegate.pushSearchResults();
    }
}
