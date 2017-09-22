package com.amk.examen.ui.main.artist;


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
import com.amk.examen.ui.main.categories.CategoriesAdapter;
import com.amk.examen.ui.main.categories.CategoriesFragment;
import com.amk.examen.ui.main.categories.CategoriesMvpPresenter;
import com.amk.examen.ui.main.categories.CategoriesMvpView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistFragment extends BaseFragment implements
        ArtistMvpView, ArtistAdapter.Callback {

    public static final String TAG = "ArtistFragment";
    private static String mPrimaryGenreName = "";
    @Inject
    ArtistMvpPresenter<ArtistMvpView> mPresenter;
    @Inject
    ArtistAdapter mArtistAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.repo_recycler_view)
    RecyclerView mRecyclerView;

    public ArtistFragment() {
        // Required empty public constructor
    }

    public static ArtistFragment newInstance(String primaryGenreName)
    {
        mPrimaryGenreName = primaryGenreName;
        Bundle args = new Bundle();
        ArtistFragment fragment = new ArtistFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artist, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mArtistAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    public void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList) {
        mArtistAdapter.addItems(resultArrayList);
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
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mArtistAdapter);

        mPresenter.onViewPrepared(mPrimaryGenreName);
    }
}