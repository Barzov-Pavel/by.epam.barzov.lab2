import entities.*;
import parsers.TextFileParsing;

import java.io.*;

public class Menu {
    TextFileParsing fileParsing = new TextFileParsing();
    Sentence interrogativeSentences = new Sentence();
    Word words = new Word();

    public void showMenu() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;
        String path = "text.txt";

        try {
            System.out.println("Введите путь к файлу");
            path = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Неверная опция!");
        }

        File file = new File(path);

        while (choice != 0) {
            System.out.println("\nВыберите одну из опций:");
            System.out.println("1. Парсить текст");
            System.out.println("2. Удалить пробелы и табуляции");
            System.out.println("3. Найти имейлы");
            System.out.println("4. Найти телефоны");
            System.out.println("5. Найти вопросительные предложения");
            System.out.println("6. Найти слова заданной длины в вопросительных предложениях");
            System.out.println("0. Выход");

            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                System.out.println("Неверная опция!");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    fileParsing.parsing(file);
                    break;

                case 2:
                    fileParsing.setText(fileParsing.replaceTab(fileParsing.getText()));
                    break;

                case 3:
                    System.out.println(words.findInString(fileParsing.getText(), Regex.EMAILS.getRegex()));
                    break;

                case 4:
                    System.out.println(words.findInString(fileParsing.getText(), Regex.PHONES.getRegex()));
                    break;

                case 5:
                    interrogativeSentences.setSentences(interrogativeSentences.findInString(fileParsing.getText(), Regex.INTERROGATIVE_SENTENCES.getRegex()));
                    interrogativeSentences.printArraySentences(interrogativeSentences.getSentences());
                    break;

                case 6:
                    int length = 0;
                    System.out.println("Введите длинну слов для поиска");
                    try {
                        length = Integer.parseInt(bufferedReader.readLine());
                    } catch (IOException e) {
                        System.out.println("Неверная опция!");
                        choice = 0;
                    }
                    words.setWords(words.findInList(interrogativeSentences.getSentences(), Regex.WORDS.getRegex()));
                    words.printSetWords(words.findByLength(words.getWords(), length));
                    break;

                case 0:
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

