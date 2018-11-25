package com.example.yewang.mobilesurveysystem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WizardItemListAdapter extends BaseAdapter {

    private final List<WizardItem> mItems = new ArrayList<WizardItem>();
    private final Context mContext;
    private static final String TAG = "Group-project";

    public WizardItemListAdapter(Context context){
        mContext = context;
    }

    public void add(WizardItem item){
        mItems.add(item);
        notifyDataSetChanged();
    }
    public void delete(int pos){
        mItems.remove(pos);
    }
    public List<WizardItem> getAllItemsData(){
        return mItems;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
//Create a View for the WizardItem at specified position
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
       final RelativeLayout my_layout = (RelativeLayout)LayoutInflater.from(mContext).inflate(R.layout.inflate_item_in_list,null);
        final WizardItem wizItem = (WizardItem)getItem(position);
        final TextView question = (TextView) my_layout.findViewById(R.id.inFlate_questions);
        question.setText(wizItem.getQuestion());

        return my_layout;
    }
}
