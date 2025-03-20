import java.util.Scanner;

public class HealthApp {
    private static HealthManager healthManager = new HealthManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🧬 Welcome to Personalized Health & Wellness Tracker 🧬");

        while (true) {
            System.out.println("\n1. Log Health Data");
            System.out.println("2. View Health Summary");
            System.out.println("3. Get AI Wellness Suggestion");
            System.out.println("4. Delete Health Entry");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    healthManager.logHealthEntry();
                    break;
                case 2:
                    healthManager.viewHealthSummary();
                    break;
                case 3:
                    healthManager.getAISuggestion();
                    break;
                case 4:
                    healthManager.deleteHealthEntry();
                    break;
                case 5:
                    System.out.println("Exiting... Stay healthy & strong! 💪");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
