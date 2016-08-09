package com.hw.sirius.thinktank.shared.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hw.sirius.thinktank.shared.ui.interfaces.BasePresenter;
import com.hw.sirius.thinktank.shared.ui.interfaces.LoadingView;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements LoadingView {
    protected BasePresenter presenter;

    private Toast toast;
    private ProgressDialog loadingView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        initPresenter();
    }

    public abstract void initPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    protected void onDestroy() {
        hideLoading();
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void showLoading() {
        if (loadingView != null && loadingView.isShowing()) {
            loadingView.dismiss();
            loadingView = null;
            return;
        }
        loadingView = new ProgressDialog(this);
        loadingView.setCancelable(false);
        loadingView.setCanceledOnTouchOutside(false);
        loadingView.show();
    }

    @Override
    public void hideLoading() {
        if (loadingView != null) {
            loadingView.dismiss();
            loadingView = null;
        }
    }

    @Override
    public void showRetry() {
        hideLoading();
    }

    @Override
    public void hideRetry() {
        hideLoading();
    }

    @Override
    public void showError(String message) {
        hideLoading();

        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public Context context() {
        return this;
    }
}

