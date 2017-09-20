package lab4.models;

/**
 * Created by zhenia on 14.05.17.
 */
public class Delimiter extends Character implements SentenceMember {
    public Delimiter(char character) {
        super(character);
    }

    @Override
    public SentenceMember reverse() {
        return this;
    }
}
