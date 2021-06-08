package np.com.ruchirajkarki.atm_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import np.com.ruchirajkarki.atm_game.database.AllocatedCharacters;
import np.com.ruchirajkarki.atm_game.database.Character;
import np.com.ruchirajkarki.atm_game.database.CharacterDatabase;

public class MainActivity extends AppCompatActivity {
    CharacterDatabase db;
    List<Character> characters = new ArrayList<>();
    Boolean canContinue = false;
    Button btn_continue;
    Button btn_exit;
    String[] arrayOfCharNames;
    String[] arrayOfCountryNames;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        resources = getResources();
        btn_continue = findViewById(R.id.hl_btn_continue);
        btn_exit = findViewById(R.id.hl_btn_exit);
        db = CharacterDatabase.getDbInstance(this.getApplicationContext());

        //Array of the character names and shuffle them
        arrayOfCharNames = resources.getStringArray(R.array.names);
        Collections.shuffle(Arrays.asList(arrayOfCharNames));
        arrayOfCountryNames = resources.getStringArray(R.array.countries);

        if (db.characterDao().howManyCharacters() > 0) {
            canContinue = true;
            btn_continue.setVisibility(View.VISIBLE);
        }
//        fillDatabaseCharacter();


        btn_exit.setOnClickListener(v -> exitApp());
    }

    public void newGame(View view) {
        if (canContinue) newGameDialog();
        else {
            okNewGame();
        }
    }

    private void okNewGame() {
        Intent newGame = new Intent(MainActivity.this, BottomNavigationMenuController.class);
        startActivity(newGame);
        generateDatabase();
        finish();
    }

    private void newGameDialog() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setMessage("There is already a saved game, Want to start a new game anyway?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        okNewGame();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = exitDialog.create();
        alertDialog.show();
    }

    private void generateDatabase() {
        db.characterDao().deleteAllEntries();
        //Add all characters to the database
        AllocatedCharacters allocatedCharacters = new AllocatedCharacters(arrayOfCharNames, arrayOfCountryNames, characters);
        for (Character c : characters
        ) {
            db.characterDao().insertOne(c);
        }


    }

    @Override
    public void onBackPressed() {
        exitApp();
    }

    public void exitApp() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setMessage("Are you sure you want to exit?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = exitDialog.create();
        alertDialog.show();
    }

    public void continueGame(View view) {
        Intent continueGame = new Intent(MainActivity.this, BottomNavigationMenuController.class);
        startActivity(continueGame);
        finish();
    }
// TODO Delete
//    private void fillDatabaseCharacter(){
//
//        Character chr1 = new Character(mPasscode(),R.drawable.ic_char_female_1, "Selena Gomez",80000,false,"Germany",1990,"Momo","Cricket");
//        Character chr2 = new Character(mPasscode(),R.drawable.ic_char_female_2, "SS Gomez",80000,false,"Germany",1990,"Momo","Cricket");
//        Character chr3 = new Character(mPasscode(),R.drawable.ic_char_male_1, "Nelsan Mandela",88000,false,"Netherlands",1978,"Sandwich","Badminton");
//        Character chr4 = new Character(mPasscode(),R.drawable.ic_char_male_2, "Sandy Mandy",98000,false,"Denmark",1987,"Hotdog","Biking");
//
//        db.characterDao().insertAll(chr1,chr2,chr3,chr4);
//    }
//
//    private String mPasscode(){
//        String passcode;
//        String p1,p2,p3,p4;
//        p1 = String.valueOf(randomNumberTill10());
//        p2 = String.valueOf(randomNumberTill10());
//        p3 = String.valueOf(randomNumberTill10());
//        p4 = String.valueOf(randomNumberTill10());
//        passcode = p1+p2+p3+p4;
//        return passcode;
//    }
//    private int randomNumberTill10(){
//        return  new Random().nextInt(10);
//    }
}