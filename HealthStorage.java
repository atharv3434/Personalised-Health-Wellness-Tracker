import java.io.*;
import java.util.*;

public class HealthStorage {
    private static final String FILE_PATH = "health_data.txt";

    public static void saveHealthData(List<HealthEntry> healthLogs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(healthLogs);
        } catch (IOException e) {
            System.out.println("❌ Error saving health data.");
        }
    }

    public static List<HealthEntry> loadHealthData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<HealthEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
