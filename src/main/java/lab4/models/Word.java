package lab4.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhenia on 14.05.17.
 */
public class Word implements SentenceMember {
    private Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public Word(String str) {
        letters = parse(str);
    }

    private Letter[] parse(String str) {
        if(str == null || str.isEmpty()) {
            Letter[] res = {new Letter(' ')};
            return res;
        }

        letters = new Letter[str.length()];

        List<Letter> tmpLetters = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            tmpLetters.add(new Letter(str.charAt(i)));
        }

        return  tmpLetters.toArray(letters);
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void setLetters(Letter[] letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        return Arrays.stream(letters).map(Letter::toString).collect(Collectors.joining());
    }

    @Override
    public SentenceMember reverse() {
        Letter[] tmp = new Letter[letters.length];

        for (int i = 0; i < letters.length; i++) {
            tmp[i] = letters[letters.length - 1 - i];
        }

        return new Word(tmp);
    }
}
