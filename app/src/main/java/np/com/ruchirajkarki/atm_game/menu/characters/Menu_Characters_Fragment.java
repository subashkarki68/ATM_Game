package np.com.ruchirajkarki.atm_game.menu.characters;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import np.com.ruchirajkarki.atm_game.BottomNavigationMenuController;
import np.com.ruchirajkarki.atm_game.CharacterDetail_View_Controller;
import np.com.ruchirajkarki.atm_game.R;
import np.com.ruchirajkarki.atm_game.RecyclerViewAdapter;
import np.com.ruchirajkarki.atm_game.database.Character;
import np.com.ruchirajkarki.atm_game.database.CharacterDatabase;
import np.com.ruchirajkarki.atm_game.menu.hack.Menu_Hack_Fragment;

public class Menu_Characters_Fragment extends Fragment implements RecyclerViewAdapter.OnCharacterListener {
    List<Character> mCharacterList;
    RecyclerView characterHolderView;
    RecyclerView.Adapter customAdapter;
    CharacterDatabase db;
    View view = null;
    int totalCharacters;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menu_character_layout, container, false);
        db = CharacterDatabase.getDbInstance(this.getContext());
        mCharacterList = db.characterDao().getAll();
        characterHolderView = view.findViewById(R.id.mcl_recycler_view);
        totalCharacters = db.characterDao().howManyCharacters();
        Toast.makeText(this.getContext(), "Total number of Characters: " + totalCharacters, Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        characterHolderView.setLayoutManager(layoutManager);
        customAdapter = new RecyclerViewAdapter(mCharacterList, getContext(), this);
        characterHolderView.setAdapter(customAdapter);

        return view;


    }

    @Override
    public void onCharacterClick(int position) {
        Intent intent = new Intent(getContext(), CharacterDetail_View_Controller.class);
        intent.putExtra("id", mCharacterList.get(position).getCharID());
        startActivity(intent);
    }
}

