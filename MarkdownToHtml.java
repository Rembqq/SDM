import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MarkdownToHtml {

    public static void main(String[] args) {
        // Перевірка наявності аргументів
        if (args.length != 4 || !args[0].equals("parse") || !args[2].equals("-o")) {
            System.err.println("Usage: parse <path> -o <path>");
            System.exit(1);
        }

        // Отримання шляхів до файлів
        String mdFilePath = args[1];
        String htmlFilePath = args[3];

        try (BufferedReader reader = new BufferedReader(new FileReader(mdFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Обробка рядків Markdown
                String htmlLine = parseMarkdown(line);
                writer.write(htmlLine);
                writer.newLine();
            }

            System.out.println("Markdown successfully parsed to HTML.");

        } catch (IOException e) {
            System.err.println("Error reading or writing files:");
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private static String parseMarkdown(String markdown) {
        // Простий парсер - приклад
        String html = markdown;

        // Обробка заголовків
        html = html.replaceAll("^# (.*)$", "<h1>$1</h1>");
        html = html.replaceAll("^## (.*)$", "<h2>$1</h2>");
        html = html.replaceAll("^### (.*)$", "<h3>$1</h3>");

        // Обробка списків
        html = html.replaceAll("^\\* (.*)$", "<li>$1</li>");
        if (html.startsWith("<li>")) {
            html = "<ul>" + html + "</ul>";
        }

        // Обробка курсиву та жирного тексту
        html = html.replaceAll("\\*\\*(.*?)\\*\\*", "<strong>$1</strong>");
        html = html.replaceAll("\\*(.*?)\\*", "<em>$1</em>");

        return html;
    }
}