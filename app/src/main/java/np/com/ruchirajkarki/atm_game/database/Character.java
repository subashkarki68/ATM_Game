package np.com.ruchirajkarki.atm_game.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Random;

@Entity(tableName = "characters")
public class Character {

    @PrimaryKey(autoGenerate = true)
    public int charID;

    @ColumnInfo
    private final int charImg;
    @ColumnInfo
    private final String charName;
    @ColumnInfo
    private int bankBalance = mBankBalance();
    @ColumnInfo
    private boolean hackedStatus = false;
    @ColumnInfo
    private final String country;
    @ColumnInfo
    private int birthYear = mBirthYear();
    @ColumnInfo
    private final String favouriteFood;
    @ColumnInfo
    private final String favouriteGame;
    @ColumnInfo
    private String passcode = mPasscode();

    public Character(int charImg, String charName, String country, String favouriteFood, String favouriteGame) {
        //        this.charID = charID;
        this.charImg = charImg;
        this.charName = charName;
        this.country = country;
        this.favouriteFood = favouriteFood;
        this.favouriteGame = favouriteGame;
    }

    private String mPasscode() {
        String passcode;
        String p1, p2, p3, p4;
        p1 = String.valueOf(randomNumberTill(10));
        p2 = String.valueOf(randomNumberTill(10));
        p3 = String.valueOf(randomNumberTill(10));
        p4 = String.valueOf(randomNumberTill(10));
        passcode = p1 + p2 + p3 + p4;
        return passcode;
    }

    private int mBirthYear() {
        int birthYear;
        birthYear = randomNumberTill(41) + 1970;
        return birthYear;
    }

    private int mBankBalance() {
        int balance;
        balance = randomNumberTill(1000) * 90;
        return balance;
    }

    private int randomNumberTill(int num) {
        return new Random().nextInt(num);
    }

    public int getCharID() {
        return charID;
    }

    public int getCharImg() {
        return charImg;
    }

    public String getCharName() {
        return charName;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    public boolean isHackedStatus() {
        return hackedStatus;
    }

    public void setHackedStatus(boolean hackedStatus) {
        this.hackedStatus = hackedStatus;
    }

    public String getCountry() {
        return country;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getFavouriteGame() {
        return favouriteGame;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }
}

