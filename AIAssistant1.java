public class AIAssistant1 {
    public static String getWellnessTip(double bmi, int waterIntake, int sleepHours) {
        if (bmi > 25) {
            return "⚠️ Your BMI suggests you might be overweight. Try increasing physical activity and eating healthier!";
        } else if (bmi < 18.5) {
            return "⚠️ Your BMI suggests you may be underweight. Consider a nutritious diet with proper protein intake!";
        }

        if (waterIntake < 2000) {
            return "💧 You need to drink more water! Stay hydrated for better energy and focus.";
        }

        if (sleepHours < 6) {
            return "😴 Your sleep is insufficient. Try to get at least 7-8 hours of rest for better recovery.";
        }

        return "✅ You're maintaining a healthy balance! Keep it up! 🏆";
    }
}
