package np.com.ruchirajkarki.atm_game.menu.hack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import np.com.ruchirajkarki.atm_game.R;
import np.com.ruchirajkarki.atm_game.database.Character;
import np.com.ruchirajkarki.atm_game.database.CharacterDatabase;

public class Menu_Hack_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private String mPasscode;
    Spinner mSpinner;
    TextView mhl_hack_status;
    EditText mhl_enter_passcode;
    Button mhl_hack_btn;
    ImageView mhl_char_image;
    CharacterDatabase db;
    List<Character> mCharacterList = new ArrayList<>();
    List<String> allCharactersNames = new ArrayList<>();
    Boolean hackedStatusFromDatabase;
    Boolean mHackStatus;
    int thisID;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_hack_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = CharacterDatabase.getDbInstance(this.getContext());
        mSpinner = view.findViewById(R.id.person_to_hack_spinner);
        mhl_char_image = view.findViewById(R.id.mhl_char_image);
        mhl_hack_status = view.findViewById(R.id.mhl_hack_status);
        mhl_hack_btn = view.findViewById(R.id.mhl_hack_btn);
        mhl_enter_passcode = view.findViewById(R.id.mhl_enter_passcode);
        allCharactersNames = db.characterDao().getAllNames();
        mCharacterList = db.characterDao().getAll();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,allCharactersNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setOnItemSelectedListener(this);
        mSpinner.setAdapter(adapter);

        mhl_hack_btn.setOnClickListener(v -> {
            String enteredPasscode = mhl_enter_passcode.getText().toString();
            if (enteredPasscode.equals(mPasscode)) {
                //If the Password is correct
                mhl_hack_status.setText("Success");
                mhl_hack_status.setTextColor(getResources().getColor(R.color.teal_700));
                db.characterDao().updateHackedStatus(true, thisID);
            } else {
                //If the Password is incorrect
                mhl_hack_status.setText("Failed");
                mhl_hack_status.setTextColor(getResources().getColor(R.color.Failed));
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        findPasswordFor(parent.getItemAtPosition(position).toString());
        findHackedStatusAlsoWriteImageFor(parent.getItemAtPosition(position).toString());
        mCharacterList = db.characterDao().getAll();
        hackedNotHackedWriter();
        //TODO delete this toast
        Toast.makeText(getContext(), "Pin is : " + mPasscode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void findPasswordFor(String name) {
        for (Character c : mCharacterList
        ) {
            if (c.getCharName().equals(name)) {
                mPasscode = c.getPasscode();
            }
        }
    }

    private void findHackedStatusAlsoWriteImageFor(String name) {
        for (Character c : mCharacterList
        ) {
            if (c.getCharName().equals(name)) {
                //Write Image for char
                mhl_char_image.setImageResource(c.getCharImg());

                hackedStatusFromDatabase = c.isHackedStatus();
                thisID = c.getCharID();
                mHackStatus = hackedStatusFromDatabase;
            }
        }
    }

    private void hackedNotHackedWriter() {
        if (mHackStatus) {
            mhl_hack_status.setText("Already Hacked");
            mhl_hack_status.setTextColor(getResources().getColor(R.color.teal_700));
        } else {
            mhl_hack_status.setText("Not Hacked");
            mhl_hack_status.setTextColor(getResources().getColor(R.color.Failed));
        }
    }

}
