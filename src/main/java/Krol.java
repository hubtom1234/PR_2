import java.util.Random;
import lombok.SneakyThrows;
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


    @SneakyThrows
    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            k.getKopalnia().sprobujZabracDobra("szczescie", 3);
            this.wait(15000);
            dowodzenie++;
        }
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
