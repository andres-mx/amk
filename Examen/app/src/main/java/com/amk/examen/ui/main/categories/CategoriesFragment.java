package com.amk.examen.ui.main.categories;


import android.content.Context;
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
import com.amk.examen.ui.main.artist.ArtistAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends BaseFragment implements
        CategoriesMvpView, CategoriesAdapter.Callback {

    public static final String TAG = "CategoriesFragment";
    @Inject
    CategoriesMvpPresenter<CategoriesMvpView> mPresenter;
    @Inject
    CategoriesAdapter mCategoriesAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.repo_recycler_view)
    RecyclerView mRecyclerView;

    public OnInteractionKind listener;

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
        if (getActivity() instanceof OnInteractionKind)
        {
            this.listener = (OnInteractionKind) getActivity();
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList)
    {
        mCategoriesAdapter.addItems(resultArrayList);
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

    @Override
    public void onInteractionArtist(String primaryGenreName)
    {
        listener.onInteractionKind(primaryGenreName);
    }

    public interface OnInteractionKind {

        void onInteractionKind(String primaryGenreName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInteractionKind)
        {
            this.listener = (OnInteractionKind) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

}
