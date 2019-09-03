package com.scinan.intelligentdesklamp.views.clock;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.scinan.intelligentdesklamp.BaseFragment;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.clock.adapter.ClockAdapter;
import com.scinan.intelligentdesklamp.views.clock.bean.ClockBean;
import com.scinan.intelligentdesklamp.views.clock.editclock.EditClockActivity;
import com.scinan.intelligentdesklamp.views.clock.setting.SetClockActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class ClockFragment extends BaseFragment implements View.OnClickListener {
    int x = R.layout.fragment_clock;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.function_tv)
    TextView functionTv;
    @Bind(R.id.clock_lv)
    ListView clockLv;
    @Bind(R.id.listview)
    SwipeMenuListView listview;

    private List<ClockBean> clockBeanList = new ArrayList<>();
    private ClockAdapter clockAdapter;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.function_tv: {
                Intent intent = new Intent(mContext, SetClockActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.back_img: {
                getActivity().finish();
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        functionTv.setOnClickListener(this);
        backImg.setOnClickListener(this);
    }

    @Override
    public void initData() {
        initListView();

        for (int i = 0; i < 3; i++) {
            ClockBean clockBean = new ClockBean("18:0" + i, "周" + (i + 1), true);
            clockBeanList.add(clockBean);
        }
        clockAdapter = new ClockAdapter(clockBeanList, R.layout.item_clock, mContext);
        listview.setAdapter(clockAdapter);
        listview.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
    }

    private void initListView() {
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem editItem = new SwipeMenuItem(mContext);
                editItem.setWidth(200);
                editItem.setTitle("编辑");
                editItem.setTitleSize(18);
                editItem.setTitleColor(Color.WHITE);
                editItem.setBackground(R.color.item_edit);
                menu.addMenuItem(editItem);

                SwipeMenuItem deleteItem = new SwipeMenuItem(mContext);
                deleteItem.setWidth(200);
                deleteItem.setTitle("删除");
                deleteItem.setTitleSize(18);
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setBackground(R.color.item_delete);
                menu.addMenuItem(deleteItem);
            }
        };
        listview.setMenuCreator(creator);
        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0: {
                        Intent intent = new Intent(mContext, EditClockActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        showToast("删除");
                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_clock;
    }
}
