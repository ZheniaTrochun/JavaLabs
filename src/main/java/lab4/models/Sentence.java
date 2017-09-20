package lab4.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhenia on 14.05.17.
 */
public class Sentence {
    private SentenceMember[] members;

    public Sentence(SentenceMember[] members) {
        this.members = members;
    }

    public SentenceMember[] getMembers() {
        return members;
    }

    public void setMembers(SentenceMember[] members) {
        this.members = members;
    }

    public Sentence(String str) {
        members = parse(str);
    }

    private SentenceMember[] parse(String str) {
        List<Integer> delimsIndexes = new ArrayList<>();
        char[] delims = {'.', '!', '?', '<', '>', ' ', ',', ':', ';'};

        for (int i = 0; i < delims.length; i++) {
            int index = -1;
            do {
                index = str.indexOf(delims[i], index+1);
                if (index != -1) delimsIndexes.add(index);
            } while (index != -1);
        }

        List<SentenceMember> tmpSent = new ArrayList<>();

        Collections.sort(delimsIndexes);

        tmpSent.add(new Word(str.substring(0, delimsIndexes.get(0)).trim()));
        tmpSent.add(new Delimiter(str.charAt(delimsIndexes.get(0))));

        for (int i = 1; i < delimsIndexes.size(); i++) {
            tmpSent.add(new Word(str.substring(delimsIndexes.get(i-1), delimsIndexes.get(i)).trim()));
            tmpSent.add(new Delimiter(str.charAt(delimsIndexes.get(i))));
        }

        members = new SentenceMember[tmpSent.size()];

        return tmpSent.toArray(members);
    }

    public Sentence reverse() {
        SentenceMember[] tmp = new SentenceMember[members.length];

        for (int i = 0; i < members.length; i++) {
            tmp[i] = members[members.length - 1 - i].reverse();
        }

        return new Sentence(tmp);
    }

    public String longestPalindrome() {
        int len = 1;
        String longest = " ";

        for(int i = 0; i < members.length; i++) {
            if(members[i].reverse().toString().equals(members[i].toString()) && (members[i].toString().length() > len)) {
                longest = members[i].toString();
                len = members[i].toString().length();
            }
        }

        return longest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(members, sentence.members);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(members);
    }

    @Override
    public String toString() {
        return Arrays.stream(members).map(SentenceMember::toString).collect(Collectors.joining());
    }
}
