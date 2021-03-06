package np.com.ruchirajkarki.atm_game.database;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import np.com.ruchirajkarki.atm_game.R;

public class AllocatedCharacters extends Application {
    public List<Character> allCharactersList = new ArrayList<>();
    int mNumberOfCharatersToPlayWith = 10;
    int[] mCharacterImages = {
            R.drawable.ic_char_female_1,
            R.drawable.ic_char_female_2,
            R.drawable.ic_char_female_3,
            R.drawable.ic_char_female_4,
            R.drawable.ic_char_female_5,
            R.drawable.ic_char_male_1,
            R.drawable.ic_char_male_2,
            R.drawable.ic_char_male_3,
            R.drawable.ic_char_male_4,
            R.drawable.ic_char_male_5,
            R.drawable.ic_char_male_6,
            R.drawable.ic_char_male_7
    };

    public AllocatedCharacters(
            String[] arrayOfCharNames,
            String[] arrayOfCountryNames,
            String[] arrayOfFavouriteFood,
            String[] arrayOfFavouriteGame,
            List<Character> allocatedCharacters)
    {
//        checkForDuplicateCharactersNames(arrayOfCharNames);
        buildAllocatedCharacterList(
                arrayOfCharNames,
                arrayOfCountryNames,
                arrayOfFavouriteFood,
                arrayOfFavouriteGame,
                allocatedCharacters);
    }

    //build allocated characters
    private void buildAllocatedCharacterList(
            String[] arrayOfCharNames,
            String[] arrayOfCountryNames,
            String[] arrayOfFavouriteFood,
            String[] arrayOfFavouriteGame,
            List<Character> characters) {

        //Here we will build all the allocated characters to play with, we will get random 8 characters from
        //allCharactersList and add to allocatedCharacters List
        int totalNumberOfCharacters = allCharactersList.size();
        Integer[] arr = new Integer[totalNumberOfCharacters];

        //this loop for character name generation
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));

        for (int i = 0; i < mNumberOfCharatersToPlayWith; i++) {
            characters.add(new Character(
                    mCharacterImages[mCharImageIndex()],
//                    R.drawable.ic_test_char,
                    mCharName(arrayOfCharNames, i),
                    arrayOfCountryNames[new Random().nextInt(arrayOfCountryNames.length)],
                    arrayOfFavouriteFood[new Random().nextInt(arrayOfFavouriteFood.length)],
                    arrayOfFavouriteGame[new Random().nextInt(arrayOfFavouriteGame.length)]
            ));
        }
    }

    private String mCharName(String[] arrayOfCharNames, int index) {
        String charName;
        charName = arrayOfCharNames[index];
        return charName;
    }

    private int mCharImageIndex() {
        int image = new Random().nextInt(mCharacterImages.length);
        return image;
    }


    //Check For Duplicating Names
    private void checkForDuplicateCharactersNames(String[] arrayOfNames) {
        String[] test = arrayOfNames;
        int numberOfItemsChecks = 0;

        for (int x = 0; x < test.length; x++) {
            numberOfItemsChecks++;
            String postString;
            String preString = test[x];
            for (int ax = x + 1; ax < test.length; ax++) {
                postString = test[ax];
//                Log.d("CheckDuplicates", "Checking if " + preString + " = " + postString);
                if (preString.equals(postString)) {
                    Log.d("CheckDuplicates", preString + " = " + postString);
                }
            }
        }
        Log.d("CheckDuplicates", "checkForDuplicateCharactersNames: " + numberOfItemsChecks);
    }
}
