public class Main {
    public static void main(String[] args) {
        Logger test1 = Logger.getInstance();
        test1.getDetails();
        Logger test2 = Logger.getInstance();


        if (test1 == test2) {
            System.out.println("Singleton is working correctly.");
        } else {
            System.out.println("Singleton is not working correctly.");
        }

    }
}

class Logger {
    private static Logger instance;

    private Logger() {

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void getDetails() {
        System.out.println("Logging working fine correctly.");
    }
}

