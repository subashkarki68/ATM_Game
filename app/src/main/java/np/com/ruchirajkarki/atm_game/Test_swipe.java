package np.com.ruchirajkarki.atm_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Test_swipe extends AppCompatActivity {
    ConstraintLayout mConstraintLayout;
    TextView mTextView;
    SwipeListener mSwipeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_swipe);
        mConstraintLayout = findViewById(R.id.ats_constraint_layout);
        mTextView = findViewById(R.id.ats_gesture_tv);

        //Initialise swipe listener
        mSwipeListener = new SwipeListener(mConstraintLayout);
    }

    private class SwipeListener implements View.OnTouchListener {
        GestureDetector mGestureDetector;

        SwipeListener(View view){
            int threshold = 100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener(){
                        @Override
                        public boolean onDown(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try{
                                if(Math.abs(xDiff) > Math.abs(yDiff)){
                                    //When x is greater than y
                                    //Check condition
                                    if(Math.abs(xDiff) > threshold
                                            && Math.abs(velocityX) > velocity_threshold){
                                        //when x difference is greater than threshold
                                        //when x difference is greater than threshold
                                        //check condition
                                        if(xDiff > 0){
                                            //Whem swipe right
                                            mTextView.setText("Swiped Right");
                                        }else {
                                            //when swipe left
                                            mTextView.setText("Swiped Left");
                                        }
                                        return true;
                                    }
                                }else {
                                    //When y is greater than x
                                    //check condition
                                    if(Math.abs(yDiff) > threshold
                                            && Math.abs(velocityY) > velocity_threshold){
                                        //When y difference is greater than threshold
                                        //When y difference is greater than velocity threshold
                                        if(yDiff > 0){
                                            //When swipe down
                                            mTextView.setText("Swiped Down");
                                        }else {
                                            //When Swipe Up
                                            mTextView.setText("Swiped UP");
                                        }
                                        return true;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };
            //Initialige gesture detection
            mGestureDetector = new GestureDetector(listener);
            //Set listener on view
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return mGestureDetector.onTouchEvent(event);
        }
    }
}