package np.com.ruchirajkarki.atm_game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

        characters = db.characterDao().getAll();

        Intent intent = getIntent();
        thisID = intent.getIntExtra("id", -1);
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

    //
//    ////////////////////////////////////////////////////////////
//    int thisID;
//    List<CharacterList> mCharacterList;
//    GlobalValues mGlobalValues;
//    ImageView mCharImage;
//    TextView mCharName, mCharID;
//    TextView mBankBalance, mStatus, mCountry, mBirthYear, mFavouriteFood, mFavouriteGame;
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.character_detail_view_layout);
//        mCharImage = findViewById(R.id.cdvl_image_holder);
//        mCharName = findViewById(R.id.cdvl_name_holder);
//        mCharID = findViewById(R.id.cdvl_char_id);
//
//        mBankBalance = findViewById(R.id.cdvl_bank_balance_value);
//        mStatus = findViewById(R.id.cdvl_status_value);
//        mCountry = findViewById(R.id.cdvl_country_value);
//        mBirthYear = findViewById(R.id.cdvl_birth_year_value);
//        mFavouriteFood = findViewById(R.id.cdvl_favourite_food_value);
//        mFavouriteGame = findViewById(R.id.cdvl_favourite_game_value);
//
//        mGlobalValues = new GlobalValues();
//        mCharacterList = mGlobalValues.getCharList();
//        Intent intent = getIntent();
//        thisID = intent.getIntExtra("id",-1);
//        CharacterList character = null;
//
//        if(thisID>=0){
//            for(CharacterList c: mCharacterList){
//                if(c.getCharID() == thisID)
//                    character = c;
//            }
//            assert character != null;
//            mCharImage.setImageResource(character.getCharImg());
//            mCharName.setText(character.getCharName());
//            mCharID.setText("ID: " + thisID);
//
//            mBankBalance.setText(" : " + character.getBankBalance());
//            mCountry.setText(" : " + character.getCountry());
//            mBirthYear.setText(" : " + character.getBirthYear());
//            mFavouriteFood.setText(" : " + character.getFavouriteFood());
//            mFavouriteGame.setText(" : " + character.getFavouriteGame());
//
//            //If character is hacked or not
//            if(character.isHackedStatus()) {
//                mStatus.setText(" : Hacked");
//            }else{
//                mStatus.setText(" : Not Hacked");
//            }
//
//        }
//
//    }
    public void back(View view) {
        finish();
    }
}