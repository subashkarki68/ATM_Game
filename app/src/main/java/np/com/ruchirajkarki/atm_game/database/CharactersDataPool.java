package np.com.ruchirajkarki.atm_game.database;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import np.com.ruchirajkarki.atm_game.R;
import np.com.ruchirajkarki.atm_game.database.Character;
import np.com.ruchirajkarki.atm_game.database.CharacterDatabase;

public class CharactersDataPool extends Application {
    public List<Character> characters = new ArrayList<>();

    public CharactersDataPool(List<Character> characters) {
        buildDefaultCharacterList(characters);
    }

    //build default characters
    private void buildDefaultCharacterList(List<Character> characters) {
//        Character chr1 = new Character(mPasscode(),R.drawable.ic_char_female_1, "Test Gomez",80000,false,"Germany",1990,"Momo","Cricket");
//        Character chr2 = new Character(mPasscode(),R.drawable.ic_char_female_2, "SS Gomez",80000,false,"Germany",1990,"Momo","Cricket");
//        Character chr3 = new Character(mPasscode(),R.drawable.ic_char_male_1, "Nelsan Mandela",88000,false,"Netherlands",1978,"Sandwich","Badminton");
//        Character chr4 = new Character(mPasscode(),R.drawable.ic_char_male_2, "Sandy Mandy",98000,false,"Denmark",1987,"Hotdog","Biking");
//        Character chr5 = new Character(mPasscode(),R.drawable.ic_char_male_2, "Sandy Mandy",98000,false,"Denmark",1987,"Hotdog","Biking");
//        Character chr6 = new Character(mPasscode(),R.drawable.ic_char_male_2, "Test Mandy",98000,false,"Denmark",1987,"Hotdog","Biking");
        characters.addAll(Arrays.asList(
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
}
