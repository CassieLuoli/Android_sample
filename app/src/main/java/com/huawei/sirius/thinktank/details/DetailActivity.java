package com.huawei.sirius.thinktank.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.details.interfaces.DetailView;
import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Luoli on 7/18/16.
 */
public class DetailActivity extends BaseActivity implements DetailView {
    public static final String TAG = DetailActivity.class.getName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meeting_detail);
    }

    @Override
    public void initPresenter() {
        this.presenter = new DetailPresenterImp(this);
    }

    @Override
    public void showDetails(MeetingEvent meetingEvent) {

    }
}
