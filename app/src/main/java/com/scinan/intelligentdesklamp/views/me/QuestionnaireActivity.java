package com.scinan.intelligentdesklamp.views.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuestionnaireActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_questionnaire;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.question_lv)
    ListView questionLv;
    @Bind(R.id.submit_bt)
    Button submitBt;
    private QuestionAdapter questionAdapter;
    private List<QuestionBean> questionBeans = new ArrayList<>();

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_img:{
                finish();
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
    }

    @Override
    public void initData() {
        for (int i = 0; i < 5; i++) {
            QuestionBean questionBean = new QuestionBean("第" + (i+1) + "个问题");
            questionBeans.add(questionBean);
        }
        questionAdapter = new QuestionAdapter(questionBeans, R.layout.item_question, mContext);
        questionLv.setAdapter(questionAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_questionnaire;
    }
}
