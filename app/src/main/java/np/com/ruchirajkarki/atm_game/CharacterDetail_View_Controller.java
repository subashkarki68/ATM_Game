package np.com.ruchirajkarki.atm_game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import np.com.ruchirajkarki.atm_game.database.Character;
import np.com.ruchirajkarki.atm_game.database.CharacterDatabase;

public class CharacterDetail_View_Controller extends AppCompatActivity {
    int thisID;
    CharacterDatabase db;
    ImageView mCharImage;
    TextView mCharName, mCharID;
    TextView mBankBalance, mStatus, mCountry, mBirthYear, mFavouriteFood, mFavouriteGame;
    List<Character> characters;

    //For Swipe
    View cdvl_swipe_view;
    InnerSwipeListener mSwipeListener;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_detail_view_layout);
        db = CharacterDatabase.getDbInstance(this.getApplicationContext());

        mCharImage = findViewById(R.id.cdvl_image_holder);
        mCharName = findViewById(R.id.cdvl_name_holder);
        mCharID = findViewById(R.id.cdvl_char_id);

        mBankBalance = findViewById(R.id.cdvl_bank_balance_value);
        mStatus = findViewById(R.id.cdvl_status_value);
        mCountry = findViewById(R.id.cdvl_country_value);
        mBirthYear = findViewById(R.id.cdvl_birth_year_value);
        mFavouriteFood = findViewById(R.id.cdvl_favourite_food_value);
        mFavouriteGame = findViewById(R.id.cdvl_favourite_game_value);

        //Initialise for Swipe
        cdvl_swipe_view = findViewById(R.id.cdvl_swipe_view);
        mSwipeListener = new InnerSwipeListener(cdvl_swipe_view);
        /////////////////////

        characters = db.characterDao().getAll();
        Intent intent = getIntent();
        thisID = intent.getIntExtra("id", -1);

        fillUpTheDetails();


    }
    public void back(View view) {
        finish();
    }

    private void fillUpTheDetails(){

        Character character = null;
        if (thisID > 0) {
            for (Character c : characters) {
                if (c.getCharID() == thisID) character = c;
            }
//            assert character != null;
            mCharImage.setImageResource(character.getCharImg());
            mCharName.setText(character.getCharName());
            mCharID.setText("ID: " + thisID);

            mBankBalance.setText(" : " + character.getBankBalance());
            mCountry.setText(" : " + character.getCountry());
            mBirthYear.setText(" : " + character.getBirthYear());
            mFavouriteFood.setText(" : " + character.getFavouriteFood());
            mFavouriteGame.setText(" : " + character.getFavouriteGame());
            //If character is hacked or not
            if (character.isHackedStatus()) {
                mStatus.setText(" : Hacked");
            } else {
                mStatus.setText(" : Not Hacked");
            }

        }
    }
    private class InnerSwipeListener implements View.OnTouchListener{
        GestureDetector mGestureDetector;

        InnerSwipeListener(View view){
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
                                            if(thisID > characters.get(0).charID) {
                                                thisID = thisID - 1;
                                            }else{
                                                thisID = characters.get(characters.size()-1).charID;
                                            }
                                            fillUpTheDetails();
                                            Log.d("SWIPETEST", "onFling: " + thisID + characters.get(0).charID);

                                        }else {
                                            //when swipe left
                                            if(thisID < characters.get(characters.size()-1).charID) {
                                                thisID = thisID + 1;
                                            }else{
                                                thisID = characters.get(0).charID;
                                            }
                                            fillUpTheDetails();
                                            Log.d("SWIPETEST", "onFling: " + thisID);


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
                                        }else {
                                            //When Swipe Up
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
