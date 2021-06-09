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
    String[] arrayOfFavouriteFood;
    String[] arrayOfFavouriteGame;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        //
//            Intent intent = new Intent(this,Test_swipe.class);
//            startActivity(intent);

        //
        resources = getResources();
        btn_continue = findViewById(R.id.hl_btn_continue);
        btn_exit = findViewById(R.id.hl_btn_exit);
        db = CharacterDatabase.getDbInstance(this.getApplicationContext());

        //Array of the character names and shuffle them
        arrayOfCharNames = resources.getStringArray(R.array.names);
        Collections.shuffle(Arrays.asList(arrayOfCharNames));
        //Array of country names
        arrayOfCountryNames = resources.getStringArray(R.array.countries);
        //Array of favourite food
        arrayOfFavouriteFood = resources.getStringArray(R.array.favouriteFood);
        //Array of facourite game
        arrayOfFavouriteGame = resources.getStringArray(R.array.favouriteGame);


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
        AllocatedCharacters allocatedCharacters = new AllocatedCharacters(
                arrayOfCharNames,
                arrayOfCountryNames,
                arrayOfFavouriteFood,
                arrayOfFavouriteGame,
                characters);
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
}