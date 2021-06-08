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
            new Character( R.drawable.ic_char_female_1, "Taha Dillard", false, "Germany","Momo", "Cricket"),
            new Character( R.drawable.ic_char_female_2, "Ajay Mcghee",  false, "Germany","Momo", "Cricket"),
            new Character( R.drawable.ic_char_male_1, "Levi Stewart", false, "Netherlands","Sandwich", "Badminton"),
            new Character( R.drawable.ic_char_male_2, "Brendan Price", false, "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Pearce Harwood", false, "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Ziggy Scott", false, "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Rikki Nixon", false, "Denmark","Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Elliott Gross", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Abbas Mata", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jake Legge", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Caris Gilmour", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tonisha Cortez", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Britney Wolfe", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Zohaib Dalby", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jasmin Reader", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Elyas Alvarado", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Agatha Winter", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bessie Randall", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lyra Bridges", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Corinne Mustafa", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Malcolm Andersen", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lilly Browning", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Eira Edge", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Katelin Bender", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Joely Pace", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Darsh Pittman", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Safwan Broadhurst", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tia Morse", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tiffany Dudley", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Richard Meadows", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bryony Daniels", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Irving Mcknight", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tahmid Ashley", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Dolly Bauer", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lorna Devlin", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Braden Hodges", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Akram Hagan", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Madiha Wheeler", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jeffery Haynes", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Gwion Rollins", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Marwan Beck", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bernadette Reeve", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lillian Avery", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Husnain Forbes", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Sameer Vaughan", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Josephine Finch", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Amy-Leigh Huff", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Cadence Derrick", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Ellena Mullins", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Homer Bonilla", false, "Denmark", "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Subash Karki", false, "Nepal", "Hotdog", "Biking")

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
