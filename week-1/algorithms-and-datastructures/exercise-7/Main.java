import java.util.HashMap;
import java.util.Map;

class FinancialForecasting {
    private Map<String, Double> memo = new HashMap<>();

    public double calculateFutureValue(double presentValue, double growthRate, int years) {
        String key = presentValue + "," + growthRate + "," + years;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (years == 0) {
            return presentValue;
        } else {
            double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
            memo.put(key, futureValue);
            return futureValue;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        FinancialForecasting ff = new FinancialForecasting();

        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int years = 10;

        double futureValue = ff.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value: " + futureValue);
    }
}

