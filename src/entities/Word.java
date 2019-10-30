package entities;

import java.util.*;

public class Word extends Entity {
    List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public Set<String> findByLength(List<String> checkedList, int length) {
        Set<String> fond = new LinkedHashSet<>();
        for (String word : checkedList) {
            if (word.length() == length) {
                fond.add(word);
            }
        }
        return fond;
    }

    public void printSetWords(Set<String> stringSet) {
        System.out.println("Список слов в предложениях:");
        for (String word : stringSet) {
            System.out.println(word);
        }
    }
}
