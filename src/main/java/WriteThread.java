import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteThread implements Runnable {
    public final String name;
    public final ArrayList<String> dataToWrite;

    public WriteThread(String name, ArrayList<String> dataToWrite) {
        this.name = name;
        this.dataToWrite = dataToWrite;
    }

    @Override
    public void run() {
        StringBuilder result = new StringBuilder();
        dataToWrite.forEach(dataToWrite -> {
            result.append(dataToWrite);
            result.append(";");
        });
        try {
            writeToFile(name, result.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private void writeToFile(String fileName, String stringToWrite) throws IOException {
        // Синхронизация по ключу
        synchronized (name) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(stringToWrite);
            bufferedWriter.close();
        }
    }


}
