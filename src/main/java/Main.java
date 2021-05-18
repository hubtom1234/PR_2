import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Krolestwo rigcz = new Krolestwo("rigcz");
        Thread watekKrolestwo = new Thread(rigcz);
        watekKrolestwo.start();
        watekKrolestwo.join();
    }
}