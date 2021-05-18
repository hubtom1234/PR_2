import java.util.Random;

public class Jubiler extends Thread implements Miejsce
{
    private Krolestwo k;
    private int blyskotki;
    private int klejnoty;

    @Override
    public synchronized void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException
    {
        while (!sprobujZabracDobra(nazwa, ilosc))
        {
            wait();
        }
        System.out.println(kto + " zabrał od jubilera " + ilosc + " " + nazwa);
    }

    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("blyskotki"))
        {
            if (blyskotki >= ilosc)
            {
                blyskotki -= ilosc;
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void dodajDobro(String nazwa)
    {
        switch (nazwa)
        {
            case "blyskotki":
                blyskotki++;
                break;
        }
        System.out.println(this);
    }


    @Override
    public void run()
    {
        Random generator = new Random();
        int liczbaJubilerow = generator.nextInt() % 4 + 3;
        for (int i = 0; i < liczbaJubilerow; i++)
        {
            Thread watek = new Thread(new Robotnik(this,"blyskotki",3));
            watek.start();
        }
    }

    public Jubiler(Krolestwo k, int blyskotki, int klejnoty)
    {
        this.k = k;
        this.blyskotki=blyskotki;
        this.klejnoty = klejnoty;
    }

    @Override
    public String toString()
    {
        return "Stan jubilera: Blyskotki: " + blyskotki + " Klejnoty: " + klejnoty;
    }
}