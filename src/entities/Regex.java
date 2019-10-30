package entities;

public enum Regex {
    SENTENCES("([^.!?]+[.!?])"),
    INTERROGATIVE_SENTENCES("([^.!?]+[?])"),
    PHONES("\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}"),
    EMAILS("\\w+[.,_,-,+]?\\w+[.,_,-,+]?\\w+@\\w+[.]?\\w+[.]\\w+"),
    WORDS("(\\w+[.,_,-,+]?\\w+[.,_,-,+]?\\w+@\\w+[.]?\\w+[.]?\\w+|\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}|[А-ЯЁа-яё]*|[a-zA-Z])");

    private String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
