package com.amk.examen.ui.main.categories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amk.examen.R;
import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.di.component.ActivityComponent;
import com.amk.examen.ui.base.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends BaseFragment implements
        CategoriesMvpView, CategoriesAdapter.Callback {

    public static final String TAG = "OpenSourceFragment";
    @Inject
    CategoriesMvpPresenter<CategoriesMvpView> mPresenter;
    @Inject
    CategoriesAdapter mCategoriesAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.repo_recycler_view)
    RecyclerView mRecyclerView;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    public static CategoriesFragment newInstance() {
        Bundle args = new Bundle();
        CategoriesFragment fragment = new CategoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mCategoriesAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    public void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList)
    {
        mCategoriesAdapter.addItems(resultArrayList);
    }

    @Override
    public void onRepoEmptyViewRetryClick() {

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view)
    {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mCategoriesAdapter);

        mPresenter.onViewPrepared();
    }
}
