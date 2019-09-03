package com.scinan.intelligentdesklamp.views.me;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuestionAdapter extends BaseAdapter {
    int x = R.layout.item_question;
    private List<QuestionBean> questionBeans;
    private int resourceId;
    private Context context;

    public QuestionAdapter(List<QuestionBean> questionBeans, int resourceId, Context context) {
        this.questionBeans = questionBeans;
        this.resourceId = resourceId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return questionBeans == null ? 0 : questionBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return questionBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_question, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.questionTv.setText((position + 1) + "、" + questionBeans.get(position).getQuestion());
        return convertView;
    }

    static
    class ViewHolder {
        @Bind(R.id.question_tv)
        TextView questionTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
