package com.reintegro.profuturo.app.ui.main;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.reintegro.profuturo.app.BuildConfig;
import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.base.ActivityBase;
import com.reintegro.profuturo.app.android.ui.fragments.ClientDataFragment;
import com.reintegro.profuturo.app.android.ui.fragments.GreetingFragment;
import com.reintegro.profuturo.app.android.ui.fragments.SearchClientFragment;
import com.reintegro.profuturo.app.android.ui.fragments.SearchResultsFragment;
import com.reintegro.profuturo.app.android.widget.ViewPager;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.MainContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.ActivityMainBinding;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.interactor.MainInteractor;
import com.reintegro.profuturo.app.navigation.NavigationDelegate;
import com.reintegro.profuturo.app.navigation.NavigationState;
import com.reintegro.profuturo.app.presenter.MainPresenter;

public class MainActivity extends ActivityBase implements MainContract.View, NavigationDelegate<Bundle> {
    private ActivityMainBinding viewDataBinding;
    private NavigationAdapter navigationAdapter;
    private NavigationState<Integer> navigationState;
    private String agentName;
    private String version;
    private int currentFragmentPosition = -1;
    private boolean popPending;

    public static final String EXTRA_AGENT_NUMBER = "agent_number";


    private androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageSelected(final int position) {
            if (!popPending) {
                NavigationAdapter.Fragment fragment;
                fragment = navigationAdapter.getItem(position);

                if (!fragment.isBackEnabled()) {
                    viewDataBinding.navigationViewPager.setCurrentItem(currentFragmentPosition, true);
                } else {
                    currentFragmentPosition = position;
                }
                fragment.resumeFragment();
                fragment.setFragmentResumed(true);

                navigationAdapter.getItem(position).getLifecycle().addObserver(new DefaultLifecycleObserver() {
                    @Override
                    public void onResume(@NonNull LifecycleOwner owner) {
                        NavigationAdapter.Fragment fragment;
                        fragment = navigationAdapter.getItem(position);

                        if (!fragment.isFragmentResumed()) {
                            fragment.resumeFragment();
                            fragment.setFragmentResumed(true);
                        }
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (popPending && state == ViewPager.SCROLL_STATE_IDLE) {
                navigationAdapter.popUpTo(currentFragmentPosition);
                popPending = false;

                NavigationAdapter.Fragment fragment;
                fragment = navigationAdapter.getItem(currentFragmentPosition);

                if (fragment.isResettable()) {
                    fragment.reset();
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationAdapter = new NavigationAdapter(getSupportFragmentManager());
        navigationState = new NavigationState<>();

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.navigationViewPager.addOnPageChangeListener(onPageChangeListener);
        viewDataBinding.navigationViewPager.setAdapter(navigationAdapter);
        viewDataBinding.navigationViewPager.setVisibility(View.VISIBLE);
        viewDataBinding.parent.requestFocus();
        viewDataBinding.timelineView.setVisibility(View.GONE);
        //viewDataBinding.actionBar.setVisibility(View.GONE);
        //viewDataBinding.leftSidebar.setVisibility(View.GONE);

        //viewDataBinding.title.setText("Reintegro de Semanas");

        MainContract.Interactor interactor = new MainInteractor(new RetrofitDataProviderFactory(this), new RealmRepositoryFactory());
        MainContract.Presenter presenter = new MainPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

        AgentDto agentDto = new AgentDto();

        if (getIntent() != null && getIntent().hasExtra(EXTRA_AGENT_NUMBER)) {
            agentDto.setAgentCode(getIntent().getStringExtra(EXTRA_AGENT_NUMBER));
        }

        presenter.load(agentDto);
        //pushGreeting();
    }

    /*@Override
    public void showWelcomeMessage(String welcomeMessage) {
        //viewDataBinding.title.setText(welcomeMessage);
        pushFirstFragment();
        onPageChangeListener.onPageSelected(0);
    }*/

    @Override
    public void showAgentInformation(AgentDto agentDto) {
        agentName = agentDto.getFullName();
        version = BuildConfig.VERSION_NAME;

        viewDataBinding.agentNameTextView.setText(agentName);
        viewDataBinding.versionTextView.setText(version);

        pushGreeting();

        onPageChangeListener.onPageSelected(0);
    }

    @Override
    public void showGetAgentInformationError() {
        pushGreeting();
    }

    @Override
    public void pushFirstFragment() {
        //FirstFragment firstFragment = new FirstFragment();
        //firstFragment.setNavigationDelegate(this);
        //navigationAdapter.pushFragment(firstFragment);
    }

    @Override
    public void pushSecondFragment() {
        //SecondPageFragment secondPageFragment = new SecondPageFragment();
        //secondPageFragment.setNavigationDelegate(this);
        //navigationAdapter.pushFragment(secondPageFragment);
    }

    @Override
    public void pushGreeting() {
        GreetingFragment greetingFragment = new GreetingFragment();
        greetingFragment.setNavigationDelegate(this);

        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(greetingFragment);
        navigationState.putState(NavigationState.PAGE_GREETING, fragmentPosition);

        viewDataBinding.timelineView.setVisibility(View.GONE);
    }

    @Override
    public void pushSearchClient() {
        SearchClientFragment fragment = new SearchClientFragment();
        fragment.setNavigationDelegate(this);
        viewDataBinding.actionBar.setVisibility(View.VISIBLE);
        viewDataBinding.leftSidebar.setVisibility(View.VISIBLE);

        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(fragment);

        navigationState.putState(NavigationState.PAGE_SEARCH_CLIENT, fragmentPosition);

        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition);
    }

    @Override
    public void pushSearchResults() {
        //Toast.makeText(this,"Resultado clientes", Toast.LENGTH_SHORT).show();
        SearchResultsFragment fragment = new SearchResultsFragment();
        fragment.setNavigationDelegate(this);

        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(fragment);

        navigationState.putState(NavigationState.PAGE_SEARCH_RESULTS, fragmentPosition);
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition);

    }

    @Override
    public void popToGreeting() {
        int fragmentPosition;
        fragmentPosition = navigationState.getState(NavigationState.PAGE_GREETING);

        currentFragmentPosition = fragmentPosition;
        popPending = true;
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition, true);
    }

    @Override
    public void popToSearchClient() {
        int fragmentPosition;
        fragmentPosition = navigationState.getState(NavigationState.PAGE_SEARCH_CLIENT);

        currentFragmentPosition = fragmentPosition;
        popPending = true;
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition, true);
    }

    @Override
    public void pushClientDataImmediately() {
        ClientDataFragment fragment = new ClientDataFragment();
        fragment.setNavigationDelegate(this);

        navigationAdapter.popUpTo(navigationState.getState(NavigationState.PAGE_SEARCH_RESULTS));

        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(fragment);
        navigationState.putState(NavigationState.PAGE_CLIENT_DATA, fragmentPosition);
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition);
    }
}