import java.util.Random;

public class Drwal extends Thread implements Miejsce
{
    private Krolestwo k;
    private int drewno;
    private int siekiery;

    @Override
    public synchronized void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException
    {
        while (!sprobujZabracDobra(nazwa, ilosc))
        {
            wait();
        }
        System.out.println(kto + " zabrał z kopani " + ilosc + " " + nazwa);
    }

    @Override
    public synchronized void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException
    {
        while (!sprobujZabracDobra(nazwa, ilosc))
        {
            wait();
        }
        System.out.println(kto + " zabrał od drwala " + ilosc + " " + nazwa);
    }

    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("blyskotki"))
        {
            if (drewno >= ilosc)
            {
                drewno -= ilosc;
                return true;
            }
        }
        return false;
    }


    @Override
    public void run()
    {
        Random generator = new Random();
        int liczbaDrwali = generator.nextInt() % 4 + 3;
        for (int i = 0; i < liczbaDrwali; i++)
        {
            Thread watek = new Thread(new Robotnik(this,"drewno",3));
            watek.start();
        }
    }

    public Drwal(Krolestwo k, int drewno, int siekiery)
    {
        this.k = k;
        this.drewno = drewno;
        this.siekiery = siekiery;
    }

    @Override
    public String toString()
    {
        return "Stan drwala: Drewno: " + drewno + " siekiery: " + siekiery;
    }
}