import java.util.Random;
import lombok.SneakyThrows;
public class Drwal extends Thread implements Miejsce
{
    private Krolestwo k;
    private int drewno;
    private int siekiery;

    @Override
    public synchronized void dodajDobro(String nazwa)
    {
        switch (nazwa)
        {
            case "drewno":
                drewno++;
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
        System.out.println(kto + " zabrał od drwala " + ilosc + " " + nazwa);
    }


    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("drewno"))
        {
            if (drewno >= ilosc)
            {
                drewno -= ilosc;
                return true;
            }
        }
        return false;
    }

    @SneakyThrows
    @Override
    public void run()
    {
        Random generator = new Random();
        while(!Thread.interrupted())
        {
            k.getToolsmith().oddajDobra("siekiery", 1,"Drwal");
            int liczbaDrwali = generator.nextInt() % 4 + 3;
            for (int i = 0; i < liczbaDrwali; i++) {
                Thread watek = new Thread(new Robotnik(this, "drewno", 3));
                watek.start();
            }
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