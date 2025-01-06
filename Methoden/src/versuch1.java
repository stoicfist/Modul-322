import java.time.LocalDate;

public class versuch1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        outputTimestamp();
        outputMessage("welcome");
        int result = addUp(b, a);
        outputTimestamp();
    }

    public static void outputTimestamp() {
        System.out.println("Current date is: " + LocalDate.now());
    }

    public static void outputMessage(String message) {
        System.out.println(message);
    }

    public static int addUp(int a, int b) {
        return a + b;
    }
}

