import java.util.Random;

public class Kopalnia extends Thread implements Miejsce
{
    private Krolestwo k;
    private int zelazo;
    private int kilofy;
    private int klejnoty;

    @Override
    public synchronized void dodajDobro(String nazwa)
    {
        switch (nazwa)
        {
            case "zelazo":
                zelazo++;
                break;
            case "klejnoty":
                klejnoty++;
                break;
        }
        System.out.println(this);
    }


    @Override
    public void run()
    {
        Random generator = new Random();
        int liczbaKopaczyZelaza = generator.nextInt() % 4 + 3;
        int liczbaKopaczyDiamentow = generator.nextInt() % 4 + 3;
        for (int i = 0; i < liczbaKopaczyZelaza; i++)
        {
            Thread watek = new Thread(new Robotnik(this,"zelazo",3));
            watek.start();
        }
        for (int i = 0; i < liczbaKopaczyDiamentow; i++)
        {
            Thread watek = new Thread(new Robotnik(this,"klejnoty",3));
            watek.start();
        }

    }

    public Kopalnia(Krolestwo k, int zelazo, int kilofy, int klejnoty)
    {
        this.k = k;
        this.kilofy = kilofy;
        this.klejnoty = klejnoty;
        this.zelazo = zelazo;
    }

    @Override
    public String toString()
    {
        return "Stan kopalni: Zelazo: " + zelazo + " Klejnoty: " + klejnoty + " Kilofy: " + kilofy;
    }
}