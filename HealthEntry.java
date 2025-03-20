public class HealthEntry {
    private double weight;
    private double height;
    private int waterIntake; // in milliliters
    private int stepsWalked;
    private int sleepHours;
    private int caloriesConsumed;

    public HealthEntry(double weight, double height, int waterIntake, int stepsWalked, int sleepHours, int caloriesConsumed) {
        this.weight = weight;
        this.height = height;
        this.waterIntake = waterIntake;
        this.stepsWalked = stepsWalked;
        this.sleepHours = sleepHours;
        this.caloriesConsumed = caloriesConsumed;
    }

    public double getBMI() {
        return weight / (height * height);
    }

    @Override
    public String toString() {
        return "📊 Weight: " + weight + " kg | 📏 Height: " + height + " m | 💧 Water: " + waterIntake + "ml | 🏃 Steps: " + stepsWalked + " | 💤 Sleep: " + sleepHours + "h | 🍎 Calories: " + caloriesConsumed + " kcal | BMI: " + String.format("%.2f", getBMI());
    }
}
