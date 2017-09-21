package com.amk.examen.ui.splash;

import com.amk.examen.data.DataManager;
import com.amk.examen.ui.base.BasePresenter;
import com.amk.examen.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by andresaleman on 9/21/17.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        decideNextActivity();

    }

    private void decideNextActivity() {
        getMvpView().openLoginActivity();
    }
}
