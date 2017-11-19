package com.rhkr8521.bongmyeong.activity.mantoring;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhkr8521.bongmyeong.BMSendMessage;
import com.rhkr8521.bongmyeong.FreeTable;
import com.rhkr8521.bongmyeong.MantoringGift;
import com.rhkr8521.bongmyeong.R;
import com.rhkr8521.bongmyeong.SchoolMail;
import com.rhkr8521.bongmyeong.SchoolNotice;
import com.rhkr8521.bongmyeong.SchoolSchedule;
import com.rhkr8521.bongmyeong.activity.bap.BapActivity;
import com.rhkr8521.bongmyeong.activity.main.MainAdapter;
import com.rhkr8521.bongmyeong.first;
import com.rhkr8521.bongmyeong.second;
import com.rhkr8521.bongmyeong.third;
import com.rhkr8521.bongmyeong.tool.BapTool;
import com.rhkr8521.bongmyeong.tool.Preference;
import com.rhkr8521.bongmyeong.tool.RecyclerItemClickListener;

public class MantoringFragment extends Fragment {

    public static Fragment getInstance(int code) {
        MantoringFragment mFragment = new MantoringFragment();

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
                            startActivity(new Intent(getActivity(), first.class));
                            break;
                        case 1:
                            startActivity(new Intent(getActivity(), second.class));
                            break;
                        case 2:
                            startActivity(new Intent(getActivity(), third.class));
                            break;
                        case 3:
                            startActivity(new Intent(getActivity(), MantoringGift.class));
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

            mAdapter.addItem(R.drawable.first,
                    getString(R.string.title_activity_1st),
                    getString(R.string.message_activity_1st), true);

            mAdapter.addItem(R.drawable.second,
                    getString(R.string.title_activity_2st),
                    getString(R.string.message_activity_2st), true);

            mAdapter.addItem(R.drawable.third,
                    getString(R.string.title_activity_3st),
                    getString(R.string.message_activity_3st), true);

            mAdapter.addItem(R.drawable.upload,
                    getString(R.string.title_activity_gift),
                    getString(R.string.message_activity_gift), true);

        }

        return recyclerView;
    }
}
