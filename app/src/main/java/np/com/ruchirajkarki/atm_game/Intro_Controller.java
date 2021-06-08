package np.com.ruchirajkarki.atm_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Intro_Controller extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);
    }

    public void back(View view) {
        Intent back = new Intent(Intro_Controller.this, PlayerName_Controller.class);
        startActivity(back);
        finish();
    }

    public void forward(View view) {
        Intent forward = new Intent(Intro_Controller.this, BottomNavigationMenuController.class);
        startActivity(forward);
        finish();
    }
}