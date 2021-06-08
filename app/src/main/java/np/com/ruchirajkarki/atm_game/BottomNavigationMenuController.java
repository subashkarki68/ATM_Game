package np.com.ruchirajkarki.atm_game;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import np.com.ruchirajkarki.atm_game.menu.characters.Menu_Characters_Fragment;
import np.com.ruchirajkarki.atm_game.menu.hack.Menu_Hack_Fragment;
import np.com.ruchirajkarki.atm_game.menu.research.Menu_Research_Fragment;
import np.com.ruchirajkarki.atm_game.menu.tools.Menu_Tools_Fragment;

public class BottomNavigationMenuController extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    boolean viewCreated = false;
    //private BottomNavigationMenuLayoutBinding binding;
    ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_menu_layout);
//     binding = BottomNavigationMenuLayoutBinding.inflate(getLayoutInflater());
//     setContentView(binding.getRoot());

        // Loading Default Fragment

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
        if (!viewCreated) {
            loadFragment(new Menu_Characters_Fragment());
            viewCreated = true;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        Log.d("SUBASH", "onNavigationItemSelected() callback received");
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.menu_characters:
                Log.d("SUBASH", "Case menu_characters");
                fragment = new Menu_Characters_Fragment();
                break;
            case R.id.menu_research:
                Log.d("SUBASH", "Case menu_research");
                fragment = new Menu_Research_Fragment();
                break;
            case R.id.menu_tools:
                Log.d("SUBASH", "Case menu_tools");
                fragment = new Menu_Tools_Fragment();
                break;
            case R.id.menu_hack:
                Log.d("SUBASH", "Case menu_hack");
                fragment = new Menu_Hack_Fragment();
                break;
        }
        Log.d("SUBASH", "returning load fragment");
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        Log.d("SUBASH", "loadFragment()...Trying to load fragment");
        if (fragment != null) {
            Log.d("SUBASH", "Fragment is not null");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_fragment_holder, fragment)
                    .commit();
            return true;
        }
        Log.d("SUBASH", "Fragment is null");
        return false;
    }

    public void clickedMe(View view) {
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setMessage("You are About to exit Game.")
                .setCancelable(true)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        BottomNavigationMenuController.this.finish();
                    }
                })
                .setNegativeButton("Don't Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = exitDialog.create();
        alertDialog.show();
    }
}