package np.com.ruchirajkarki.atm_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerName_Controller extends AppCompatActivity {
    SharedPreferences playerDetailSP;
    SharedPreferences.Editor playerDetailEditor;
    EditText epnl_enter_player_name;
    RadioGroup epnl_player_gender_radio;
    RadioButton epnl_female_radio;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_player_name_layout);
        epnl_enter_player_name = findViewById(R.id.epnl_enter_player_name);
        epnl_player_gender_radio = findViewById(R.id.epnl_player_gender);
        epnl_female_radio = findViewById(R.id.radio_female);
        playerDetailSP = getSharedPreferences("PLAYER_DETAILS",MODE_PRIVATE);
        playerDetailEditor = playerDetailSP.edit();
    }

    public void back(View view) {
//        Intent back = new Intent(PlayerName_Controller.this, MainActivity.class);
//        startActivity(back);
        finish();
    }

    public void forward(View view) {
        playerName = epnl_enter_player_name.getText().toString();
        String playerGender;
        if(TextUtils.isEmpty(playerName)){
            epnl_enter_player_name.setError("Please Enter your name");
        }else {

            //Getting player name and gender
            int selectedRadioID;
            int femaleRadioID = epnl_female_radio.getId();
            boolean isFemale = false;
            selectedRadioID = epnl_player_gender_radio.getCheckedRadioButtonId();
            if(selectedRadioID == femaleRadioID){
                isFemale = true;
            }
            //Putting Player Details in SharedPreference
            Intent forward = new Intent(PlayerName_Controller.this, Intro_Controller.class);
            playerDetailEditor.putString("PLAYER_NAME",playerName);
            playerDetailEditor.putString("PLAYER_GENDER",getPlayerGender(isFemale));
            playerDetailEditor.commit();

            startActivity(forward);
            finish();
        }
    }
    private String getPlayerGender(Boolean isFemale){
        if(isFemale){
            return "Female";
        }else{
            return "Male";
        }

    }
}