package com.example.yewang.mobilesurveysystem;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class SurveryWizard extends ListActivity {

    private static final String TAG = "Group-project";
    private static final int ADD_TODO_ITEM_REQUEST = 0;
    private FirebaseDatabase database;

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

    final Button submitbtn = findViewById(R.id.submitWizBtn);
    submitbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//            Use reference as key a like structure
//            then we can set the value to different values
//            as right now I am using location as key and rest as value
            database = FirebaseDatabase.getInstance();
            DatabaseReference databasebRef = database.getReference("New Survey");

            List<WizardItem> alldata = mAdapter.getAllItemsData();
            EditText title =  findViewById(R.id.titleinput);
            EditText location = findViewById(R.id.locationinput);
            String tmp_location = location.getText().toString();
            String tmp_title = title.getText().toString();
            int question_number =1;


            for (WizardItem x : alldata ){
                databasebRef.child(tmp_location).child(tmp_title).child(question_number+"")
                        .setValue(x.getQuestion());

                Log.i(TAG, "data: "+x.getQuestion());
                question_number++;
            }

//            TODO check if there is nothing to submit then pop something

            finish();
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
