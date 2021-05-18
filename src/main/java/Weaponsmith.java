import java.util.Random;

public class Weaponsmith extends Thread implements Miejsce
{
    private Krolestwo k;
    private int zelazo;
    private int miecze;

    @Override
    public synchronized void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException
    {
        while (!sprobujZabracDobra(nazwa, ilosc))
        {
            wait();
        }
        System.out.println(kto + " zabrał od weaponsmitha " + ilosc + " " + nazwa);
    }

    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("miecze"))
        {
            if (miecze >= ilosc)
            {
                miecze -= ilosc;
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
            case "miecze":
                miecze++;
                break;
        }
        System.out.println(this);
        notifyAll();
    }


    @Override
    public void run()
    {
        Random generator = new Random();
        int liczbaWytworcowMieczy = generator.nextInt() % 4 + 3;
        for (int i = 0; i < liczbaWytworcowMieczy; i++)
        {
            Thread watek = new Thread(new Robotnik(this, "miecze", 3));
            watek.start();
        }
    }

    public Weaponsmith(Krolestwo k, int zelazo, int miecze)
    {
        this.k = k;
        this.miecze=miecze;
        this.zelazo = zelazo;
    }

    @Override
    public String toString()
    {
        return "Stan kopalni: Zelazo: " + zelazo + " Miecze: " + miecze;
    }
}