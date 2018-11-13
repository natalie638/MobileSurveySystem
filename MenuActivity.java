import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;

public class MenuActivitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activitiy);
        Survey example = new Survey();
        Question q1 = new Question("How much did you enjoy the park",3);
        example.addQuestion(q1);

        TextView quesView = (TextView) findViewById(R.id.questionView);

        quesView.setText(q1.getQuestion());

        RadioGroup rg = findViewById(R.id.optionsGroup);

        for(int i =0; i < q1.getOptions(); i++){
            RadioButton button = new RadioButton(this);
            button.setId(i);
            button.setText(Integer.toString(i+1));
            rg.addView(button);
        }
    }
}
