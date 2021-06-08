package np.com.ruchirajkarki.atm_game.menu.characters;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import np.com.ruchirajkarki.atm_game.CharacterDetail_View_Controller;
import np.com.ruchirajkarki.atm_game.R;
import np.com.ruchirajkarki.atm_game.RecyclerViewAdapter;
import np.com.ruchirajkarki.atm_game.database.Character;
import np.com.ruchirajkarki.atm_game.database.CharacterDatabase;

public class Menu_Characters_Fragment extends Fragment implements RecyclerViewAdapter.OnCharacterListener {
//    GlobalValues mGlobalValues = new GlobalValues();
//    List<CharacterList> mCharacterList;
    List<Character> mCharacterList;
    RecyclerView characterHolderView;
    RecyclerView.Adapter customAdapter;
    RecyclerView.LayoutManager layoutManager;
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
        characterHolderView = view.findViewById(R.id.recyclerView);
        totalCharacters = db.characterDao().howManyCharacters();
        Toast.makeText(this.getContext(), "Total number of Characters: " + totalCharacters, Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        characterHolderView.setLayoutManager(layoutManager);
        customAdapter = new RecyclerViewAdapter(mCharacterList, getContext(), this);
        characterHolderView.setAdapter(customAdapter);
        return view;

//        //getting characterList from Global file
//        mCharacterList = mGlobalValues.getCharList();
//        characterHolderView = view.findViewById(R.id.recyclerView);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        characterHolderView.setLayoutManager(layoutManager);
//
//        customAdapter = new RecyclerViewAdapter(mCharacterList, getContext());
//        characterHolderView.setAdapter(customAdapter);
//        characterHolderView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Clocked", Toast.LENGTH_SHORT).show();
//            }
//        });
//        Log.d("SUBASH", String.valueOf(mCharacterList.size()));
//        return view;
    }

    @Override
    public void onCharacterClick(int position) {
//        mCharacterList.get(position);
        Toast.makeText(getContext(), String.valueOf(mCharacterList.get(position)), Toast.LENGTH_SHORT).show();
        Log.d("ERRORCHECK", "onCharacterClick: " + String.valueOf(position));
        Toast.makeText(getContext(), "Clicked" + String.valueOf("FIFIIFI"), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), CharacterDetail_View_Controller.class);
                intent.putExtra("id", mCharacterList.get(position).getCharID());
                startActivity(intent);
    }
}
//        // TODO Working code Old
//        View view = inflater.inflate(R.layout.menu_character_layout,container,false);
//        ArrayList<String> data = new ArrayList<String>();
//        data.add("Windows 10");
//        data.add("Windows 9");
//        data.add("Windows 8");
//        data.add("Windows 7");
//        data.add("Windows 6");
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                getContext(),
//                android.R.layout.simple_list_item_1,
//                data
//        );
//        ListView listView = view.findViewById(R.id.listView);
//        listView.setAdapter(adapter);
//        return view;
//    }        // Upto here

