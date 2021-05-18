import java.util.Random;
import lombok.SneakyThrows;
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


    @SneakyThrows
    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            k.getJubiler().oddajDobra("blyskotki", 2,"Ksiezniczka");
            this.wait(15000);
            szczescie++;
        }
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
        return "Stan ksiezniczki: Szczescie: " + szczescie + " blyskotki: " + blyskotki;
    }
}