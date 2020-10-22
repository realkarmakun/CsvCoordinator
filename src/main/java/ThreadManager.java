import java.io.File;


// Менеджер потоков, который создаст потоки для чтение и записи так как надо
public class ThreadManager {
    public CsvData csvData;

    public ThreadManager() {
        this.csvData = new CsvData();
    }

    // Начать читать файл
    public void startReading(String[] args) {
        for (String arg : args) {
            Thread thread = new Thread(new DataBuilderThread(new File(arg), this));
            thread.start();
        }

    }

    public CsvData getCsvData() {
        return this.csvData;
    }

    public void startWriting() {
        csvData.getData().forEach((name, data) -> {
            Thread thread = new Thread(new WriteThread(name, data));
            thread.start();
        });
    }


}
