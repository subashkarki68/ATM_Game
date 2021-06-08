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
            new Character( R.drawable.ic_char_female_1, "Taha Dillard", false, "Germany", 1990, "Momo", "Cricket"),
            new Character( R.drawable.ic_char_female_2, "Ajay Mcghee",  false, "Germany", 1990, "Momo", "Cricket"),
            new Character( R.drawable.ic_char_male_1, "Levi Stewart", false, "Netherlands", 1978, "Sandwich", "Badminton"),
            new Character( R.drawable.ic_char_male_2, "Brendan Price", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Pearce Harwood", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Ziggy Scott", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Rikki Nixon", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Elliott Gross", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Abbas Mata", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jake Legge", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Caris Gilmour", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tonisha Cortez", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Britney Wolfe", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Zohaib Dalby", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jasmin Reader", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Elyas Alvarado", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Agatha Winter", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bessie Randall", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lyra Bridges", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Corinne Mustafa", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Malcolm Andersen", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lilly Browning", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Eira Edge", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Katelin Bender", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Joely Pace", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Darsh Pittman", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Safwan Broadhurst", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tia Morse", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tiffany Dudley", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Richard Meadows", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bryony Daniels", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Irving Mcknight", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Tahmid Ashley", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Dolly Bauer", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lorna Devlin", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Braden Hodges", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Akram Hagan", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Madiha Wheeler", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Jeffery Haynes", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Gwion Rollins", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Marwan Beck", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Bernadette Reeve", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Lillian Avery", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Husnain Forbes", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Sameer Vaughan", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Josephine Finch", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Amy-Leigh Huff", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Cadence Derrick", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Ellena Mullins", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Homer Bonilla", false, "Denmark", 1987, "Hotdog", "Biking"),
            new Character( R.drawable.ic_char_male_2, "Subash Karki", false, "Nepal", 1987, "Hotdog", "Biking")

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
