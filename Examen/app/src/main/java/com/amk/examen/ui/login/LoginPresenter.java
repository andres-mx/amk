package com.amk.examen.ui.login;

import android.os.CountDownTimer;

import com.amk.examen.R;
import com.amk.examen.data.DataManager;
import com.amk.examen.ui.base.BasePresenter;
import com.amk.examen.utils.CommonUtils;
import com.amk.examen.utils.rx.SchedulerProvider;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by andresaleman on 9/21/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginClick(String user, String password)
    {
        if(!CommonUtils.isEmpty(user,password))
        {
            getMvpView().onError(R.string.info_empty);
            return;
        }

        if(!CommonUtils.isRegexSpace(user))
        {
            getMvpView().onError(R.string.info_space_user);
            return;
        }

        if(!CommonUtils.isRegexSpace(password))
        {
            getMvpView().onError(R.string.info_space_password);
            return;
        }

        if(!CommonUtils.isLengthEigth(user))
        {
            getMvpView().onError(R.string.info_length_user);
            return;
        }

        if(!CommonUtils.isLengthEigth(password))
        {
            getMvpView().onError(R.string.info_length_password);
            return;
        }

        if(!CommonUtils.isRegexSpecialCharacter(user))
        {
            getMvpView().onError(R.string.info_special_user);
            return;
        }

        if(!CommonUtils.isRegexSpecialCharacter(password))
        {
            getMvpView().onError(R.string.info_special_password);
            return;
        }

        if(!CommonUtils.isRegexAUpperCaseLetter(user))
        {
            getMvpView().onError(R.string.info_letter_user);
            return;
        }

        if(!CommonUtils.isRegexAUpperCaseLetter(password))
        {
            getMvpView().onError(R.string.info_letter_password);
            return;
        }
        getMvpView().showLoading();
        CountDownTimer timer;

        timer = new CountDownTimer(3000, 3000)
        {
            public void onTick(long millisUntilFinished)
            {
            }

            public void onFinish()
            {
                getDataManager().updateUserInfo(DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER);
                getMvpView().hideLoading();
                getMvpView().openMainActivity();
            }
        };
        timer.start();

    }
}
