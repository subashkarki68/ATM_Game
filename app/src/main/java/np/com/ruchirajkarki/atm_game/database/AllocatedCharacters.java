package np.com.ruchirajkarki.atm_game.database;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import np.com.ruchirajkarki.atm_game.R;

public class AllocatedCharacters extends Application {
    public List<Character> allCharactersList = new ArrayList<>();
    int mNumberOfCharatersToPlayWith = 10;

    public AllocatedCharacters(List<Character> allocatedCharacters) {
        buildAllCharactersList();
        buildAllocatedCharacterList(allocatedCharacters);
    }

    private void buildAllCharactersList() {
        allCharactersList.addAll(Arrays.asList(
            //Do Not have same name for two people
            new Character( R.drawable.ic_char_female_1, "Taha Dillard", "Germany","Momo", "Cricket"),
            new Character( R.drawable.ic_char_female_2, "Ajay Mcghee",  "Germany","Momo", "Cricket"),
            new Character( R.drawable.ic_char_male_1, "Levi Stewart", "Netherlands","Sandwich", "Badminton"),
            new Character( R.drawable.ic_char_male_2, "Brendan Price", "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Pearce Harwood", "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Ziggy Scott", "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Rikki Nixon", "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Elliott Gross", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Abbas Mata", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jake Legge", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Caris Gilmour", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tonisha Cortez", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Britney Wolfe", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Zohaib Dalby", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jasmin Reader", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Elyas Alvarado", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Agatha Winter", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bessie Randall", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lyra Bridges", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Corinne Mustafa", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Malcolm Andersen", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lilly Browning", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Eira Edge", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Katelin Bender", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Joely Pace", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Darsh Pittman", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Safwan Broadhurst", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tia Morse", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tiffany Dudley", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Richard Meadows", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bryony Daniels", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Irving Mcknight", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tahmid Ashley", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Dolly Bauer", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lorna Devlin", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Braden Hodges", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Akram Hagan", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Madiha Wheeler", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jeffery Haynes", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Gwion Rollins", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Marwan Beck", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bernadette Reeve", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lillian Avery", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Husnain Forbes", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Sameer Vaughan", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Josephine Finch", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Amy-Leigh Huff", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Cadence Derrick", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Ellena Mullins", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Homer Bonilla", "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Subash Karki", "Nepal", "Hotdog", "Biking")

    ));

    }

    //build default characters
    private void buildAllocatedCharacterList(List<Character> characters) {
        //Here we will build all the allocated characters to play with, we will get random 8 characters from
        //allCharactersList and add to allocatedCharacters List
        int totalNumberOfCharacters = allCharactersList.size();

        Integer[] arr = new Integer[totalNumberOfCharacters];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        Log.d("CHECKME", "buildAllocatedCharacterList: " + Arrays.toString(arr));
        for(int i = 0; i < mNumberOfCharatersToPlayWith; i++)
        {
            characters.add(allCharactersList.get(arr[i]));
        }
    }
}
