package com.amk.examen.ui.main.categories;

import com.amk.examen.data.DataManager;
import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.BasePresenter;
import com.amk.examen.utils.rx.SchedulerProvider;
import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by andresaleman on 9/21/17.
 */

public class CategoriesPresenter <V extends CategoriesMvpView> extends BasePresenter<V>
        implements CategoriesMvpPresenter<V>
{
    @Inject
    public CategoriesPresenter(DataManager dataManager,
                                        SchedulerProvider schedulerProvider,
                                        CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared()
    {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getGettingStartedApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GettingStartedResponse>() {
                    @Override
                    public void accept(@NonNull GettingStartedResponse gettingStartedResponse)
                            throws Exception {
                        if (gettingStartedResponse != null && gettingStartedResponse.getResults() != null) {
                            getMvpView().updateRepo(gettingStartedResponse.getResults());
                        }
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
        getMvpView().hideLoading();
    }
}