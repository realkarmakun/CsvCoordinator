import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class DataBuilderThread implements Runnable {
    public ThreadManager threadManager;
    private final File file;

    public DataBuilderThread(File file, ThreadManager threadManager) {
        this.file = file;
        this.threadManager = threadManager;
    }

    @Override
    public void run() {
        try {
            List<String> allLines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            String[] namesLine = allLines.get(0).split(";");
            for (int i = 1; i < allLines.size(); i++) {
                String[] currentLine = allLines.get(i).split(";");
                for (int j = 0; j < currentLine.length; j++) {
                    addToData(namesLine[j], currentLine[j]);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void addToData(String name, String entry) {
        synchronized (threadManager.getCsvData()) {
            threadManager.getCsvData().add(name, entry);
        }
    }


}
