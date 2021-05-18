import java.util.Random;

public class Krol extends Thread implements Miejsce
{
    private Krolestwo k;
    private int szczescie;
    private int dowodzenie;

    @Override
    public synchronized void dodajDobro(String nazwa)
    {
        switch (nazwa)
        {
            case "dowodzenie":
                dowodzenie++;
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
        System.out.println(kto + " zabrał od króla " + ilosc + " " + nazwa);
    }


    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("dowodzenie"))
        {
            if (dowodzenie >= ilosc)
            {
                dowodzenie -= ilosc;
                return true;
            }
        }
        return false;
    }


    @Override
    public void run()
    {
        Thread watek = new Thread(new Robotnik(this,"dowodzenie",3));
        watek.start();
    }

    public Krol(Krolestwo k, int szczescie, int dowodzenie)
    {
        this.k = k;
        this.szczescie = szczescie;
        this.dowodzenie = dowodzenie;
    }

    @Override
    public String toString()
    {
        return "Stan krola: Szczescie: " + szczescie + " dowodzenie: " + dowodzenie;
    }
}
