package src.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MarkdownToHtml {

    public static void main(String[] args) {
        if ((args.length < 2 || args.length > 5 || args.length == 3) ||
                !args[0].equals("parse") || !args[2].equals("-o")) {
            System.err.println("Usage: \"parse <path> -o <path>\"" +
                                "\n or \"parse <path>\"" +
                                "\n or \"parse <path> -o <path> --format=<md/html>\"");
            System.exit(1);
        }

        // Отримання шляхів до файлів
        String mdFilePath = args[1];
        String htmlFilePath = args[3];
        String format;
        if(args.length == 5) {
            format = args[4].replaceAll("(?<=--format=).+", "");
        }

        try {
            String markdownText = readMarkdownFile(mdFilePath);
            String htmlText = convertToHtml(markdownText);

            System.out.print("\033[7m" + markdownText + "\033[0m");

            if (htmlFilePath != null) {
                writeHtmlToFile(htmlText, htmlFilePath);
            } else {
                System.out.println(htmlText);
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
            System.exit(1);
        } catch (InvalidMarkdownException e) {
            System.err.println("Error: invalid markdown " + e.getMessage());
            System.exit(1);
        }
    }

    private static String readMarkdownFile(String inputFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private static void writeHtmlToFile(String htmlText, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(htmlText);
        }
    }

    private static String convertToHtml(String markdownText) throws InvalidMarkdownException {


        // Обробка жирного тексту
        markdownText = markdownText.replaceAll("\\*\\*(.*?)\\*\\*", "<b>$1</b>");
        // Обробка курсивного тексту
        markdownText = markdownText.replaceAll("\\_(.*?)\\_", "<i>$1</i>");
        // Обробка преформатованого тексту
        markdownText = markdownText.replaceAll("(?s)```(.*?)```", "<pre>$1</pre>");
        // Обробка моноширинного тексту
        markdownText = markdownText.replaceAll("\\`(.*?)\\`", "<code>$1</code>");
        // Обробка параграфів
        markdownText = markdownText.replaceAll("(?m)\\n\\s*\\n|\\n{2,}", "</p>\n\n<p>");

        return markdownText;
    }

    static class InvalidMarkdownException extends Exception {
        public InvalidMarkdownException(String message) {
            super(message);
        }
    }
}