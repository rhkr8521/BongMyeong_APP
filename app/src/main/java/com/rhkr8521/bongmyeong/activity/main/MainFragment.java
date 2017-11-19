package com.rhkr8521.bongmyeong.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rhkr8521.bongmyeong.BMSendMessage;
import com.rhkr8521.bongmyeong.FreeTable;
import com.rhkr8521.bongmyeong.R;
import com.rhkr8521.bongmyeong.SchoolMail;
import com.rhkr8521.bongmyeong.SchoolNotice;
import com.rhkr8521.bongmyeong.SchoolSchedule;
import com.rhkr8521.bongmyeong.ServicePrepareNotice;
import com.rhkr8521.bongmyeong.activity.bap.BapActivity;
import com.rhkr8521.bongmyeong.tool.BapTool;
import com.rhkr8521.bongmyeong.tool.Preference;
import com.rhkr8521.bongmyeong.tool.RecyclerItemClickListener;

public class MainFragment extends Fragment {

    public static Fragment getInstance(int code) {
        MainFragment mFragment = new MainFragment();

        Bundle args = new Bundle();
        args.putInt("code", code);
        mFragment.setArguments(args);

        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recyclerview, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        final MainAdapter mAdapter = new MainAdapter(getActivity());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View mView, int position) {
                boolean isSimple = mAdapter.getItemData(position).isSimple;

                if (isSimple) {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(getActivity(), ServicePrepareNotice.class));
                            //startActivity(new Intent(getActivity(), FreeTable.class));
                            break;
                        case 1:
                            startActivity(new Intent(getActivity(), ServicePrepareNotice.class));
                            //startActivity(new Intent(getActivity(), com.rhkr8521.bongmyeong.activity.mantoring.Mantoring.class));
                            break;
                        case 2:
                            startActivity(new Intent(getActivity(), BMSendMessage.class));
                            break;
                        case 3:
                            startActivity(new Intent(getActivity(), BapActivity.class));
                            break;
                    }
                } else {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(getActivity(), SchoolNotice.class));
                            break;
                        case 1:
                            startActivity(new Intent(getActivity(), SchoolMail.class));
                            break;
                        case 2:
                            startActivity(new Intent(getActivity(), SchoolSchedule.class));
                            break;
                    }
                }
            }
        }));

        Bundle args = getArguments();
        int code = args.getInt("code");
        Preference mPref = new Preference(getActivity());

        if (code == 1) {
            // SimpleView

            mAdapter.addItem(R.drawable.freetable2,
                    getString(R.string.title_activity_freetable),
                    getString(R.string.message_activity_freetable), true);

            mAdapter.addItem(R.drawable.mentoring,
                    getString(R.string.title_activity_mantomanti),
                    getString(R.string.message_activity_mantomanti), true);

            mAdapter.addItem(R.drawable.bongdaejeon,
                    getString(R.string.title_activity_sendmessage),
                    getString(R.string.message_activity_sendmessage), true);

            if (mPref.getBoolean("simpleShowBap", true)) {
                BapTool.todayBapData mBapData = BapTool.getTodayBap(getActivity());
                mAdapter.addItem(R.drawable.rice,
                        getString(R.string.title_activity_bap),
                        getString(R.string.message_activity_bap),
                        mBapData.title,
                        mBapData.info);
            }

            } else {

                // DetailedView
                mAdapter.addItem(R.drawable.schoolnotice,
                        getString(R.string.title_activity_schoolnotice),
                        getString(R.string.message_activity_schoolnotice));
                mAdapter.addItem(R.drawable.schoolhome,
                        getString(R.string.title_activity_schoolhome),
                        getString(R.string.message_activity_schoolhome));
                mAdapter.addItem(R.drawable.calendar,
                        getString(R.string.title_activity_schedule),
                        getString(R.string.message_activity_schedule));
            }

        return recyclerView;
    }
}
