package entities;

import java.util.*;

public class Sentence extends Entity {
    List<String> sentences = new ArrayList<>();

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public void printArraySentences(List<String> stringArray) {
        System.out.println("Список предложений:");
        for (String string : stringArray) {
            System.out.println(string);
        }
    }
}

