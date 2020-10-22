import java.util.ArrayList;
import java.util.HashMap;

public class CsvData {
    public HashMap<String, ArrayList<String>> data;

    public CsvData() {
        this.data = new HashMap<>();
    }

    public void add(String name, String entry) {
        // Если имя еще не существовало, создаем его (значение уникально) -> добавляем значение
        if (!this.data.containsKey(name)) {
            ArrayList<String> newDataSet = new ArrayList<>();
            newDataSet.add(entry);
            this.data.put(name, newDataSet);
        }
        // Если имя существовало, но значение уникально -> добавляем значение
        if (!this.data.get(name).contains(entry)) {
            this.data.get(name).add(entry);
        }
        // Если имя существовало и значение не уникально -> ничего не делаем
    }

    public HashMap<String, ArrayList<String>> getData() {
        return this.data;
    }
}
