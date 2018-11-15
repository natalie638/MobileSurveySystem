package com.example.yewang.mobilesurveysystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddWizardItem extends Activity {

    private static final String TAG = "Group-project";

    private TextView mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wizard_item);
        mQuestion =(TextView) findViewById(R.id.titleinput);
        final Button submitButton = (Button)findViewById(R.id.add_submit_btn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: submit data from add");

                Intent intent = new Intent();
//                gather add Item data
                WizardItem.packageIntent(intent,mQuestion.getText().toString());
                Log.i(TAG, "the new added questions: "+ mQuestion.getText().toString());
//                return data Intent and finish
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        final Button cancelButton = (Button) findViewById(R.id.add_cancel_btn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}
