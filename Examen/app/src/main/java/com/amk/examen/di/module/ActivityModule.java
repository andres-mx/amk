package com.amk.examen.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.di.ActivityContext;
import com.amk.examen.di.PerActivity;
import com.amk.examen.ui.login.LoginMvpPresenter;
import com.amk.examen.ui.login.LoginMvpView;
import com.amk.examen.ui.login.LoginPresenter;
import com.amk.examen.ui.main.MainMvpPresenter;
import com.amk.examen.ui.main.MainMvpView;
import com.amk.examen.ui.main.MainPresenter;
import com.amk.examen.ui.main.artist.ArtistAdapter;
import com.amk.examen.ui.main.artist.ArtistMvpPresenter;
import com.amk.examen.ui.main.artist.ArtistMvpView;
import com.amk.examen.ui.main.artist.ArtistPresenter;
import com.amk.examen.ui.main.categories.CategoriesAdapter;
import com.amk.examen.ui.main.categories.CategoriesMvpPresenter;
import com.amk.examen.ui.main.categories.CategoriesMvpView;
import com.amk.examen.ui.main.categories.CategoriesPresenter;
import com.amk.examen.ui.splash.SplashMvpPresenter;
import com.amk.examen.ui.splash.SplashMvpView;
import com.amk.examen.ui.splash.SplashPresenter;
import com.amk.examen.utils.rx.AppSchedulerProvider;
import com.amk.examen.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by andresaleman on 9/21/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    CategoriesMvpPresenter<CategoriesMvpView> provideCategoriesPresenter(
            CategoriesPresenter<CategoriesMvpView> presenter) {
        return presenter;
    }

    @Provides
    CategoriesAdapter provideCategoriesAdapter() {
        return new CategoriesAdapter(new ArrayList<GettingStartedResponse.Result>());
    }

    @Provides
    ArtistMvpPresenter<ArtistMvpView> provideArtistPresenter(
            ArtistPresenter<ArtistMvpView> presenter) {
        return presenter;
    }

    @Provides
    ArtistAdapter provideArtistAdapter() {
        return new ArtistAdapter(new ArrayList<GettingStartedResponse.Result>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}