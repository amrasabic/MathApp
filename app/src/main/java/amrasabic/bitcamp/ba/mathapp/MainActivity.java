package amrasabic.bitcamp.ba.mathapp;

import android.app.ProgressDialog;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mSubmitButton;
    private EditText mResult;
    private TextView mExpressionView;
    private TextView mCorrectResultView;

    private ProgressBar progressBar = null;
    private int progressBarStatus = 0;
    private Handler progressBarbHandler = new Handler();

//    private Expression[] mExpressions = new Expression[] {
//            new Expression(R.string.twelve, 12),
//            new Expression(R.string.four, 4),
//            new Expression(R.string.three, 3),
//            new Expression(R.string.thirty, 30),
//            new Expression(R.string.eight, 8),
//            new Expression(R.string.ninetynine, 99),
//            new Expression(R.string.six, 6),
//            new Expression(R.string.ten, 10),
//            new Expression(R.string.zero, 0),
//            new Expression(R.string.thirtysix, 36)
//    };

    private RandomExpression[] mRandomExpressions = new RandomExpression[10];

    private int mCurrentIndex = 0;
    private int mCorrectResults = 0;

    private void updateExpression(){
        RandomExpression ex = new RandomExpression();
        mRandomExpressions[mCurrentIndex] = ex;
        RandomExpression expression = mRandomExpressions[mCurrentIndex];
        mExpressionView.setText(expression.getA() + " " + expression.getOperator() + " " + expression.getB());
    }

    private void checkResult(int result){
        int correctResult = mRandomExpressions[mCurrentIndex].getResult();

        int expressionResultId = 0;

        if(correctResult == result) {
            expressionResultId = R.string.correct_toast;
            mCorrectResults++;
        } else {
            expressionResultId = R.string.incorrect_toast;
        }

        Toast.makeText(this, expressionResultId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(10);
        progressBar.setVisibility(View.VISIBLE);

        mExpressionView = (TextView) findViewById(R.id.expression);
        updateExpression();
        mResult = (EditText) findViewById(R.id.result);
        mCorrectResultView = (TextView) findViewById(R.id.correct_results);

        mSubmitButton = (Button) findViewById(R.id.submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    checkResult(Integer.parseInt(mResult.getText().toString()));
                } catch (NumberFormatException e) {

                }
                mCorrectResultView.setText("Number of correct answers: " + mCorrectResults + "/" + (mCurrentIndex + 1) + "." );
                mCurrentIndex = (mCurrentIndex + 1) % mRandomExpressions.length;
                progressBar.setProgress(mCorrectResults);


                if(mCurrentIndex == 0){
                    mCorrectResultView.setText("Game Over. \nNumber of correct answers: " + mCorrectResults + "/10. \nStarting all over again.");
                    mCorrectResults = 0;
                }
                try {
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                updateExpression();
            }
        });

    }


}
