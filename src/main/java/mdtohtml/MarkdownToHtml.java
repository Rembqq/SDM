package mdtohtml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MarkdownToHtml {

    public static void main(String[] args) {

        // possible amount of arguments = 2; 4; 5;
        // it always has to contain "parse" as first arg
        // if there are five args, then the fifth must contain --format=
        // if there are not 2 args(4 or 5), then the third must be "-o"

        if(args.length == 0 || args.length > 4)
        {
            System.err.println("Following commands are allowed: \"<path_to_md>\"" +
                                "\n or \"<path_to_md> --out <path_to_new_file>\"" +
                                "\n or \"<path_to_md> --out <path_to_new_file> --format=<md/html>\"" +
                                "\n or \"<path_to_md> --format=<md/html>\"" +
                                "\n or \"<path_to_md> --format=<md/html> --out <path_to_new_file> \"");
            System.exit(1);
        }

        int out_index = -1;
        String format = "";

        for(int i = 0; i < args.length; ++i) {
            if(args[i].equals("--out")) {
                out_index = i;
            }
            else if(args[i].contains("--format=")) {
                format = args[i].replaceAll("--format=", "");
            }
        }

        // Отримання шляхів до файлів
        String mdFilePath = args[0];
        String FilePath = "";
        if(out_index != -1)
        {
            FilePath = args[out_index + 1];
        }

        try {
            String markdownText = readMarkdownFile(mdFilePath);
            String htmlText = convertToHtml(markdownText);

            if(out_index == -1)
            {
                if(format.equals("md") || format.isEmpty()) {
                    System.out.print("\033[7m" + markdownText + "\033[0m");
                }
                else if(format.equals("html")) {
                    System.out.print("\033[7m" + htmlText + "\033[0m");
                }
            } else {
                if(format.equals("html") || format.isEmpty()) {
                    writeToFile(htmlText, FilePath);
                }
                else if(format.equals("md")) {
                    writeToFile(markdownText, FilePath);
                }

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

    private static void writeToFile(String htmlText, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(htmlText);
        }
    }

    public static String convertToHtml(String markdownText) throws InvalidMarkdownException {


        // Обробка жирного тексту
        markdownText = markdownText.replaceAll("\\*\\*(.+?)\\*\\*", "<b>$1</b>");
        // Обробка курсивного тексту
        markdownText = markdownText.replaceAll("\\_(.+?)\\_", "<i>$1</i>");
        // Обробка преформатованого тексту
        markdownText = markdownText.replaceAll("(?s)```(.+?)```", "<pre>$1</pre>");
        // Обробка моноширинного тексту
        markdownText = markdownText.replaceAll("\\`(.+?)\\`", "<code>$1</code>");
        // Обробка параграфів

        markdownText = markdownText.replaceAll("(?s)(?<=\\n|^)(.+?)(?=\\n\\n|$)", "<p>$1</p>");

        return markdownText;
    }

    public static class InvalidMarkdownException extends Exception {
        public InvalidMarkdownException(String message) {
            super(message);
        }
    }
}