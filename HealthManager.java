import java.util.*;

public class HealthManager {
    private List<HealthEntry> healthLogs;
    private Scanner sc;

    public HealthManager() {
        this.healthLogs = HealthStorage.loadHealthData();
        this.sc = new Scanner(System.in);
    }

    public void logHealthEntry() {
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter height (m): ");
        double height = sc.nextDouble();
        System.out.print("Enter water intake (ml): ");
        int waterIntake = sc.nextInt();
        System.out.print("Enter steps walked: ");
        int stepsWalked = sc.nextInt();
        System.out.print("Enter sleep hours: ");
        int sleepHours = sc.nextInt();
        System.out.print("Enter calories consumed: ");
        int caloriesConsumed = sc.nextInt();
        sc.nextLine(); // Consume newline

        healthLogs.add(new HealthEntry(weight, height, waterIntake, stepsWalked, sleepHours, caloriesConsumed));
        HealthStorage.saveHealthData(healthLogs);
        System.out.println("✅ Health Data Logged Successfully!");
    }

    public void viewHealthSummary() {
        if (healthLogs.isEmpty()) {
            System.out.println("📄 No health records found.");
            return;
        }

        double avgBMI = 0, totalWater = 0, totalSteps = 0, totalSleep = 0;
        for (HealthEntry entry : healthLogs) {
            System.out.println(entry);
            avgBMI += entry.getBMI();
            totalWater += entry.waterIntake;
            totalSteps += entry.stepsWalked;
            totalSleep += entry.sleepHours;
        }

        avgBMI /= healthLogs.size();
        System.out.println("\n📊 Overall Summary:");
        System.out.println("🔹 Average BMI: " + String.format("%.2f", avgBMI));
        System.out.println("🔹 Total Water Intake: " + totalWater + " ml");
        System.out.println("🔹 Total Steps Walked: " + totalSteps);
        System.out.println("🔹 Total Sleep Hours: " + totalSleep + " h");
    }

    public void getAISuggestion() {
        if (healthLogs.isEmpty()) {
            System.out.println("📌 No data available for AI suggestions.");
            return;
        }

        HealthEntry latestEntry = healthLogs.get(healthLogs.size() - 1);
        System.out.println("🤖 AI Wellness Suggestion:");
        System.out.println(AIAssistant1.getWellnessTip(latestEntry.getBMI(), latestEntry.waterIntake, latestEntry.sleepHours));
    }

    public void deleteHealthEntry() {
        viewHealthSummary();
        System.out.print("Enter log number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < healthLogs.size()) {
            healthLogs.remove(index);
            HealthStorage.saveHealthData(healthLogs);
            System.out.println("✅ Health Log Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid entry number.");
        }
    }
}
