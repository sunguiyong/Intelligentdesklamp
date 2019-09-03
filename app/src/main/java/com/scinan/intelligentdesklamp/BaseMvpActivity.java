package com.scinan.intelligentdesklamp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.scinan.intelligentdesklamp.loginactivity.contract.BaseMvp;
import com.scinan.intelligentdesklamp.loginactivity.model.Model;
import com.scinan.intelligentdesklamp.loginactivity.presenter.BasePresenter;
import com.scinan.intelligentdesklamp.loginactivity.view.View;

public abstract class BaseMvpActivity<M extends Model, V extends View, P extends BasePresenter> extends AppCompatActivity implements BaseMvp<M, V, P> {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        presenter = createPresenter();
        if (presenter != null) {
            //将model层注册到presenter中
            presenter.registerModel(createModel());
            //view注册进去
            presenter.registerView(createView());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //activity销毁时调用，让具体实现BasePresenter中onViewDestroy()方法做出决定
            presenter.destroy();
        }
    }
}
