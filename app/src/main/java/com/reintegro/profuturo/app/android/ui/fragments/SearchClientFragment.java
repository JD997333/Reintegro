package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.widget.SnackBar;
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
    private String accountNumber;
    private String curp;
    private String nss;

    View.OnClickListener searchOnClickListener = (view) -> {
        if (isNetworkAvailable) {
            SearchClientDto searchClientDto;
            searchClientDto = new SearchClientDto();
            searchClientDto.setAccountNumber(viewDataBinding.accountNumberEditText.getText());
            searchClientDto.setCurp(viewDataBinding.curpEditText.getText());
            searchClientDto.setNss(viewDataBinding.nssEditText.getText());

            presenter.onClickSearch(searchClientDto);
        } else {
            presenter.onNetworkUnavailable();
        }
    };

    private TextWatcher accountNumberTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            accountNumber = s.toString();
            viewDataBinding.accountNumberEditText.setSelection(accountNumber.length());

            SearchClientDto searchClientDto;
            searchClientDto = new SearchClientDto();
            searchClientDto.setAccountNumber(viewDataBinding.accountNumberEditText.getText());
            searchClientDto.setCurp(viewDataBinding.curpEditText.getText());
            searchClientDto.setNss(viewDataBinding.nssEditText.getText());

            presenter.onAccountNumberTextChanged(searchClientDto);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
    };

    private TextWatcher curpTextWatcher = new TextWatcher() {
        private boolean isProcessingText;

        @Override
        public void afterTextChanged(Editable s) {
            if (!isProcessingText && !s.toString().isEmpty()) {
                isProcessingText = true;

                int lastPosition;
                lastPosition = s.length() - 1;

                if (Character.isAlphabetic(s.charAt(lastPosition)) || Character.isDigit(s.charAt(lastPosition))) {
                    curp = s.toString();
                    viewDataBinding.curpEditText.setSelection(curp.length());

                    SearchClientDto searchClientDto;
                    searchClientDto = new SearchClientDto();
                    searchClientDto.setAccountNumber(viewDataBinding.accountNumberEditText.getText());
                    searchClientDto.setCurp(viewDataBinding.curpEditText.getText());
                    searchClientDto.setNss(viewDataBinding.nssEditText.getText());

                    presenter.onCurpTextChanged(searchClientDto);
                } else {
                    curp = s.toString().substring(0, lastPosition);
                    viewDataBinding.curpEditText.setText(curp);
                }

                isProcessingText = false;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
    };

    private TextWatcher nssTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            nss = s.toString();
            viewDataBinding.nssEditText.setSelection(nss.length());

            SearchClientDto searchClientDto;
            searchClientDto = new SearchClientDto();
            searchClientDto.setAccountNumber(viewDataBinding.accountNumberEditText.getText());
            searchClientDto.setCurp(viewDataBinding.curpEditText.getText());
            searchClientDto.setNss(viewDataBinding.nssEditText.getText());

            presenter.onNssTextChanged(searchClientDto);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
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

        setResettable(true);
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
        viewDataBinding.accountNumberEditText.setText(accountNumber);
        viewDataBinding.accountNumberEditText.setTextWatcher(accountNumberTextWatcher);
        viewDataBinding.curpEditText.setText(curp);
        viewDataBinding.curpEditText.setTextWatcher(curpTextWatcher);
        viewDataBinding.nssEditText.setText(nss);
        viewDataBinding.nssEditText.setTextWatcher(nssTextWatcher);
    }

    @Override
    public void pushSearchResults() {
        setBackEnabled(false);
        navigationDelegate.pushSearchResults();
    }

    @Override
    public void clearCurp() {
        curp = null;
        viewDataBinding.curpEditText.setText(curp);
    }

    @Override
    public void clearNss() {
        nss = null;
        viewDataBinding.nssEditText.setText(nss);
    }

    @Override
    public void clearAccountNumber() {
        accountNumber = null;
        viewDataBinding.accountNumberEditText.setText(accountNumber);
    }

    @Override
    public void showEmptySearchClientDataError() {
        SnackBar.show(getView(), getString(R.string.empty_search_client_data_error_1));
    }

    @Override
    public void showSearchClientError() {
        SnackBar.show(getView(), getString(R.string.search_client_error_1));
    }

    @Override
    public void showValidateAccountNumberError() {
        SnackBar.show(getView(), getString(R.string.validate_account_number_error_1));
    }

    @Override
    public void showValidateCurpError() {
        SnackBar.show(getView(), getString(R.string.validate_curp_error_1));
    }

    @Override
    public void showValidateNssError() {
        SnackBar.show(getView(), getString(R.string.validate_nss_error_1));
    }

    @Override
    public void reset() {
        accountNumber = null;
        curp = null;
        nss = null;

        viewDataBinding.accountNumberEditText.setText(accountNumber);
        viewDataBinding.curpEditText.setText(curp);
        viewDataBinding.nssEditText.setText(nss);
    }
}
