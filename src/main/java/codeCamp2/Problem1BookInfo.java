package codeCamp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1BookInfo {
    public static void extractBookInfo(String filename) {

        StringBuilder htmlLines = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine())!= null) {
                htmlLines.append(line);
                htmlLines.append(System.lineSeparator());
            }
            String text  = htmlLines.toString();

            //Pattern p = Pattern.compile("(<p.*?>)(.*)(</p>)"); // also works
            Pattern p = Pattern.compile("(<p>)(.*?)(</p>)");

            Matcher matcher = p.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group(2));
            }

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Path filePath = Paths.get(".", "src/main/java/codeCamp2/bookInfo.html");
        extractBookInfo(filePath.toString());

    }

}
