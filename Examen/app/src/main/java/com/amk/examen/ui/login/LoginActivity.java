package com.amk.examen.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.amk.examen.R;
import com.amk.examen.ui.base.BaseActivity;
import com.amk.examen.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    @BindView(R.id.et_user)
    EditText mUserEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(LoginActivity.this);
    }

    @OnClick(R.id.btn_login)
    void onServerLoginClick(View v) {
        mPresenter.onLoginClick(mUserEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    @Override
    protected void setUp() {

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    public void openMainActivity()
    {
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }
}
