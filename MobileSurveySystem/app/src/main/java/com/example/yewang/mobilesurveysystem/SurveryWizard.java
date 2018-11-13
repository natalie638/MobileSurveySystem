package com.example.yewang.mobilesurveysystem;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SurveryWizard extends ListActivity {

    private static final String TAG = "Group-project";
    private static final int ADD_TODO_ITEM_REQUEST = 0;

    WizardItemListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_survery_wizard);

        mAdapter = new WizardItemListAdapter(getApplicationContext());

//        set footer and header
        getListView().setHeaderDividersEnabled(true);
        getListView().setFooterDividersEnabled(true);

        LinearLayout footView = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.wizard_footer,null);
        RelativeLayout headView = (RelativeLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.wizard_header,null);
//        RelativeLayout
        getListView().addHeaderView(headView);
        getListView().addFooterView(footView);


//        set action TO DO

    final Button addbtn = findViewById(R.id.addWizBtn);
    addbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SurveryWizard.this,AddWizardItem.class);

            startActivityForResult(intent,ADD_TODO_ITEM_REQUEST);

        }
    });
        getListView().setAdapter(mAdapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(ADD_TODO_ITEM_REQUEST== requestCode && RESULT_OK== resultCode){
            WizardItem toDoItem = new WizardItem(data);
            mAdapter.add(toDoItem);
        }
    }

}
