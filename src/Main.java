import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String BASE_PATH = "C:\\Games\\";

    public static void createDirAndLog(StringBuilder stringBuilder, String dirName) {
        File file = new File(BASE_PATH + dirName);
        if (file.mkdir()) {
            stringBuilder.append("Directory ")
                    .append(file.getName())
                    .append(" was successfully created")
                    .append("\n");
        }
    }

    public static void createFileAndLog(StringBuilder stringBuilder, String filename) {
        File file = new File(BASE_PATH + filename);
        try {
            if (file.createNewFile()) {
                stringBuilder.append("File ")
                        .append(file.getName())
                        .append(" was successfully created")
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to create file " + filename + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        createDirAndLog(result, "src");
        createDirAndLog(result, "res");
        createDirAndLog(result, "savegames");
        createDirAndLog(result, "temp");

        createDirAndLog(result, "src\\main");
        createDirAndLog(result, "src\\test");

        createFileAndLog(result, "src\\main\\Main.java");
        createFileAndLog(result, "src\\main\\Utils.java");

        createDirAndLog(result, "res\\drawables");
        createDirAndLog(result, "res\\vectors");
        createDirAndLog(result, "res\\icons");

        createFileAndLog(result, "temp\\temp.txt");

        try (FileWriter writer = new FileWriter(BASE_PATH + "temp\\temp.txt", false)) {
            writer.write(result.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Unable to write to the temp file: " + ex.getMessage());
        }
    }
}
