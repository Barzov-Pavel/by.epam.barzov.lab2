package parsers;

import java.io.*;
import java.util.regex.*;

public class TextFileParsing implements Parser {
    private String text;

    @Override
    public String parsing(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder = stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        text = new String(stringBuilder);
        return text;
    }

    @Override
    public String replaceTab(String text) {
        Pattern p = Pattern.compile("\\s{2,}");
        Matcher matcher = p.matcher(text);
        this.text = matcher.replaceAll(" ");

        Pattern p2 = Pattern.compile("¬");
        Matcher matcher2 = p2.matcher(this.text);
        this.text = matcher2.replaceAll("");
        return this.text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
