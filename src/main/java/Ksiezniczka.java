import java.util.Random;

public class Ksiezniczka extends Thread implements Miejsce
{
    private Krolestwo k;
    private int szczescie;
    private int blyskotki;

    @Override
    public synchronized void dodajDobro(String nazwa)
    {
        switch (nazwa)
        {
            case "szczescie":
                szczescie++;
                break;
        }
        System.out.println(this);
        notifyAll();
    }

    @Override
    public synchronized void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException
    {
        while (!sprobujZabracDobra(nazwa, ilosc))
        {
            wait();
        }
        System.out.println(kto + " zabrał od ksiezniczki " + ilosc + " " + nazwa);
    }


    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("szczescie"))
        {
            if (szczescie >= ilosc)
            {
                szczescie -= ilosc;
                return true;
            }
        }
        return false;
    }


    @Override
    public void run()
    {
        Thread watek = new Thread(new Robotnik(this,"szczescie",3));
        watek.start();
    }

    public Ksiezniczka(Krolestwo k, int szczescie, int blyskotki)
    {
        this.k = k;
        this.szczescie = szczescie;
        this.blyskotki = blyskotki;
    }

    @Override
    public String toString()
    {
        return "Stan krola: Szczescie: " + szczescie + " blyskotki: " + blyskotki;
    }
}