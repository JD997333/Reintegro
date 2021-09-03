package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.adapters.SearchResultsAdapter;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.contract.SearchResultsContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentSearchResultsBinding;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.interactor.SearchResultsInteractor;
import com.reintegro.profuturo.app.presenter.SearchResultsPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

import java.util.List;

public class SearchResultsFragment extends NavigationAdapter.Fragment implements SearchResultsContract.View {
    private SearchResultsContract.Presenter presenter;
    private FragmentSearchResultsBinding viewDatabinding;
    private SearchResultsAdapter searchResultsAdapter;
    private List<ClientDto> searchResults;

    private View.OnClickListener cancelOnClickListener = (view) -> presenter.onClickCancel();

    private View.OnClickListener newSearchOnClickListener = (view) -> presenter.onClickNewSearch();

    private RecyclerView.Adapter.OnItemSelectedListener searchResultsRadioButtonOnItemSelectedListener = (position) -> presenter.onClickSearchResult(searchResults.get(position), false);

    private RecyclerView.Adapter.OnItemSelectedListener searchResultsOnItemSelectedListener = (position) -> presenter.onClickSearchResult(searchResults.get(position), true);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SearchResultsContract.Interactor interactor;
        interactor = new SearchResultsInteractor(new RealmRepositoryFactory());
        presenter = new SearchResultsPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

        searchResultsAdapter = new SearchResultsAdapter(getLayoutInflater());
        searchResultsAdapter.setOnItemSelectedListener(searchResultsOnItemSelectedListener);
        searchResultsAdapter.setRadioButtonOnItemSelectedListener(searchResultsRadioButtonOnItemSelectedListener);

        presenter.resume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDatabinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDatabinding.cancelButton.setOnClickListener(cancelOnClickListener);
        viewDatabinding.newSearchButton.setOnClickListener(newSearchOnClickListener);
        viewDatabinding.searchResultsRecyclerView.setAdapter(searchResultsAdapter);
        viewDatabinding.searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), androidx.recyclerview.widget.RecyclerView.VERTICAL, false));
    }

    @Override
    public void popToGreeting() {
        navigationDelegate.popToGreeting();
    }

    @Override
    public void popToSearchClient() {
        navigationDelegate.popToSearchClient();
    }

    @Override
    public void pushClientDataImmediately() {
        navigationDelegate.pushClientDataImmediately();
    }

    @Override
    public void pushRepaymentEvents() {
        setBackEnabled(false);
        navigationDelegate.pushInitialCapture();
    }

    @Override
    public void pushSelectApplicant() {
        navigationDelegate.pushSelectApplicant();
    }

    @Override
    public void pushSelectApplicantNoGone() {
        navigationDelegate.pushSelectApplicantNoGone();
    }

    @Override
    public void showSearchResults(List<ClientDto> searchResults) {
        this.searchResults = searchResults;
        searchResultsAdapter.setSearchResults(searchResults);
    }
}
