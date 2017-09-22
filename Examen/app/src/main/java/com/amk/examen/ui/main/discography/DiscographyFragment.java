package com.amk.examen.ui.main.discography;


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
import com.amk.examen.ui.main.artist.ArtistFragment;
import com.amk.examen.ui.main.artist.ArtistMvpPresenter;
import com.amk.examen.ui.main.artist.ArtistMvpView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscographyFragment extends BaseFragment implements
        DiscographyMvpView, DiscographyAdapter.Callback {

    public static final String TAG = "DiscographyFragment";
    private static String mPrimaryGenreName = "";
    @Inject
    DiscographyMvpPresenter<DiscographyMvpView> mPresenter;
    @Inject
    DiscographyAdapter mDiscographyAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.repo_recycler_view)
    RecyclerView mRecyclerView;

    public DiscographyFragment() {
        // Required empty public constructor
    }

    public static DiscographyFragment newInstance(String discography)
    {
        mPrimaryGenreName = discography;
        Bundle args = new Bundle();
        DiscographyFragment fragment = new DiscographyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discography, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mDiscographyAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    public void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList) {
        mDiscographyAdapter.addItems(resultArrayList);
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
        mRecyclerView.setAdapter(mDiscographyAdapter);

        mPresenter.onViewPrepared(mPrimaryGenreName);
    }

}
