package com.rhkr8521.bongmyeong.activity.bap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.rhkr8521.bongmyeong.R;
import com.rhkr8521.bongmyeong.tool.BapTool;

class BapViewHolder {
    public TextView mCalender;
    public TextView mDayOfTheWeek;
    public TextView mBreakfast;
    public TextView mLunch;
    public TextView mDinner;
    //public LinearLayout starLayout;
}

class BapListData {
    public String mCalender;
    public String mDayOfTheWeek;
    public String mBreakfast;
    public String mLunch;
    public String mDinner;
    public boolean isToday;
}

public class BapAdapter extends BaseAdapter {
    private Context mContext = null;
    private ArrayList<BapListData> mListData = new ArrayList<BapListData>();

    /**final View.OnClickListener mStarListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Intent mIntent = new Intent(mContext, BapStarActivity.class);

    if (v.getId() == R.id.giveStar) {
    mIntent.putExtra("starType", 1);
    } else {
    mIntent.putExtra("starType", 2);
    }

    mContext.startActivity(mIntent);
    }
    };**/

    public BapAdapter(Context mContext) {
        super();

        this.mContext = mContext;
    }

    public void addItem(String mCalender, String mDayOfTheWeek, String mBreakfast, String mLunch, String mDinner, boolean isToday) {
        BapListData addItemInfo = new BapListData();
        addItemInfo.mCalender = mCalender;
        addItemInfo.mDayOfTheWeek = mDayOfTheWeek;
        addItemInfo.mBreakfast = mBreakfast;
        addItemInfo.mLunch = mLunch;
        addItemInfo.mDinner = mDinner;
        addItemInfo.isToday = isToday;

        mListData.add(addItemInfo);
    }

    public void clearData() {
        mListData.clear();
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public BapListData getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        BapViewHolder mHolder;

        if (convertView == null) {
            mHolder = new BapViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_bap_item, null);

            mHolder.mCalender = (TextView) convertView.findViewById(R.id.mCalender);
            mHolder.mDayOfTheWeek = (TextView) convertView.findViewById(R.id.mDayOfTheWeek);
            mHolder.mBreakfast = (TextView) convertView.findViewById(R.id.mBreakfast);
            mHolder.mLunch = (TextView) convertView.findViewById(R.id.mLunch);
            mHolder.mDinner = (TextView) convertView.findViewById(R.id.mDinner);
            //mHolder.starLayout = (LinearLayout) convertView.findViewById(R.id.starLayout);

            convertView.setTag(mHolder);
        } else {
            mHolder = (BapViewHolder) convertView.getTag();
        }

        BapListData mData = mListData.get(position);

        String mCalender = mData.mCalender;
        String mDayOfTheWeek = mData.mDayOfTheWeek;
        String mBreakfast = mData.mBreakfast;
        String mLunch = mData.mLunch;
        String mDinner = mData.mDinner;

        if (BapTool.mStringCheck(mBreakfast))
            mBreakfast = mData.mBreakfast = mContext.getResources().getString(R.string.no_data_breakfast);
        if (BapTool.mStringCheck(mLunch))
            mLunch = mData.mLunch = mContext.getResources().getString(R.string.no_data_lunch);
        if (BapTool.mStringCheck(mDinner))
            mDinner = mData.mDinner = mContext.getResources().getString(R.string.no_data_dinner);

        mHolder.mCalender.setText(mCalender);
        mHolder.mDayOfTheWeek.setText(mDayOfTheWeek);
        mHolder.mBreakfast.setText(mBreakfast);
        mHolder.mLunch.setText(mLunch);
        mHolder.mDinner.setText(mDinner);

        /**if (mData.isToday) {
         mHolder.starLayout.setVisibility(View.VISIBLE);
         convertView.findViewById(R.id.giveStar).setOnClickListener(mStarListener);
         convertView.findViewById(R.id.showStar).setOnClickListener(mStarListener);
         } else {
         mHolder.starLayout.setVisibility(View.GONE);
         }**/

        return convertView;
    }
}
