package com.amk.examen.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.amk.examen.R;
import com.amk.examen.ui.base.BaseActivity;
import com.amk.examen.ui.login.LoginActivity;
import com.amk.examen.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashMvpView
{
    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    protected void setUp() {

    }


    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity()
    {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }
}
