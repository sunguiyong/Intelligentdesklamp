package com.scinan.intelligentdesklamp.loginactivity.presenter;

import com.scinan.intelligentdesklamp.loginactivity.model.Model;
import com.scinan.intelligentdesklamp.loginactivity.view.View;

public interface Presenter<M extends Model, V extends View> {
    /**
     * 注册model层
     */
    void registerModel(M model);

    /**
     * 注册view层
     */
    void registerView(V view);

    /**
     * 获取View
     */
    V getView();

    /**
     * 销毁动作(如Activity、fragment的卸载)
     */
    void destroy();
}
