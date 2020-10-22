public class CsvCoordinator {

    public static void main(String[] args) {
        ThreadManager threadManager = new ThreadManager();
        threadManager.startReading(args);
        threadManager.startWriting();
    }

}

