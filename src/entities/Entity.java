package entities;

import java.util.*;
import java.util.regex.*;

public abstract class Entity {

    public List<String> findInString(String checkedString, String regex) {
        List<String> data = new ArrayList<>();
        Pattern p = Pattern.compile(regex,
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(checkedString);

        while (matcher.find()) {
            data.add(matcher.group().trim());
        }
        return data;
    }

    public List<String> findInList(List<String> checkedList, String regex) {
        List<String> data = new ArrayList<>();

        for (String checkedString : checkedList) {
            Pattern p = Pattern.compile(regex,
                    Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(checkedString);

            while (matcher.find()) {
                data.add(matcher.group().trim());
            }
        }
        return data;
    }

    public String replaceInString(String checkedString, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(checkedString);
        checkedString = matcher.replaceAll("");
        return checkedString;
    }
}
