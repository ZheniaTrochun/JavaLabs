package lab4.controller;

import lab4.models.Sentence;
import lab4.models.Word;

import java.util.*;
import java.util.stream.Collectors;


public class Text {
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Text(String text) {
        sentences = parse(text);
    }

    private Sentence[] parse(String text) {
        List<Integer> delimsIndexes = new ArrayList<>();
        char[] delims = {'.', '!', '?'};

        text = text.replaceAll("\\s", " ");

        for (int i = 0; i < delims.length; i++) {
            int index = -1;
            do {
                index = text.indexOf(delims[i], index+1);
                if (index != -1) delimsIndexes.add(index);
            } while (index != -1);
        }

        List<Sentence> tmpSent = new ArrayList<>();

        Collections.sort(delimsIndexes);

        tmpSent.add(new Sentence(text.substring(0, delimsIndexes.get(0) + 1).trim()));

        for (int i = 1; i < delimsIndexes.size(); i++) {
            tmpSent.add(new Sentence(delimsIndexes.get(i) + 1 > text.length() - 1 ?
                    text.substring(delimsIndexes.get(i-1) + 1).trim() :
                    text.substring(delimsIndexes.get(i-1) + 1, delimsIndexes.get(i) + 1).trim()));
        }

        sentences = new Sentence[tmpSent.size()];

        return tmpSent.toArray(sentences);
    }

    public Text reverse() {
        Sentence[] tmp = new Sentence[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            tmp[i] = sentences[sentences.length - 1 - i].reverse();
        }

        return new Text(tmp);
    }

    public String longestPalindrome() {
        List<String> palindromes = new ArrayList<>();

        Arrays.stream(sentences).forEach(s -> palindromes.add(s.longestPalindrome()));

        return palindromes.stream().max((e1, e2) -> e1.compareTo(e2)).orElse(" ");
    }

    @Override
    public String toString() {
        return Arrays.stream(sentences).map(Sentence::toString).collect(Collectors.joining(" "));
    }
}
