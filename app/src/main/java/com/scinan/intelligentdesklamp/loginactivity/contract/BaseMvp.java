package com.scinan.intelligentdesklamp.loginactivity.contract;

import com.scinan.intelligentdesklamp.loginactivity.model.Model;
import com.scinan.intelligentdesklamp.loginactivity.presenter.BasePresenter;
import com.scinan.intelligentdesklamp.loginactivity.view.View;

public interface BaseMvp<M extends Model, V extends View, P extends BasePresenter> {
    M createModel();

    V createView();

    P createPresenter();
}
