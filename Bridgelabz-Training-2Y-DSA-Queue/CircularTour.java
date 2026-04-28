import java.util.Arrays;

public class CircularTour {
    public static int getStart(int[] petrol, int[] dist) {
        int balance = 0, deficit = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - dist[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] dist = {6, 5, 3, 5};

        int start = getStart(petrol, dist);
        System.out.println(start != -1 ? "Starting pump index: " + start : "No possible tour");
    }
}
