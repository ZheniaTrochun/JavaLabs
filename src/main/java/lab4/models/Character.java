package lab4.models;

/**
 * Created by zhenia on 14.05.17.
 */
public abstract class Character {
    protected char character;

    public Character(char character) {
        this.character = character;
    }

    public Character() {
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character that = (Character) o;

        return character == that.character;

    }

    @Override
    public int hashCode() {
        return (int) character;
    }

    @Override
    public String toString() {
        return "" + character;
    }
}
