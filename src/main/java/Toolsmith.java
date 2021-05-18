import java.util.Random;

public class Toolsmith extends Thread implements Miejsce
{
    private Krolestwo k;
    private int zelazo;
    private int kilofy;
    private int drewno;
    private int siekiery;

    @Override
    public synchronized void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException
    {
        while (!sprobujZabracDobra(nazwa, ilosc))
        {
            wait();
        }
        System.out.println(kto + " zabrał od toolsmitha " + ilosc + " " + nazwa);
    }

    @Override
    public boolean sprobujZabracDobra(String nazwa, int ilosc)
    {
        if (nazwa.equals("kilofy"))
        {
            if (kilofy >= ilosc)
            {
                kilofy -= ilosc;
                return true;
            }
        }
        else if (nazwa.equals("siekiery"))
        {
            if (siekiery >= ilosc)
            {
                siekiery -= ilosc;
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
            case "kilofy":
                kilofy++;
                break;
            case "siekiery":
                siekiery++;
                break;
        }
        System.out.println(this);
        notifyAll();
    }


    @Override
    public void run()
    {
        Random generator = new Random();
        int liczbaWytworcowSiekier = generator.nextInt() % 4 + 3;
        int liczbaWytworcowKilofow = generator.nextInt() % 4 + 3;
        for (int i = 0; i < liczbaWytworcowSiekier; i++)
        {
            Thread watek = new Thread(new Robotnik(this, "siekiery", 3));
            watek.start();
        }
        for (int i = 0; i < liczbaWytworcowKilofow; i++)
        {
            Thread watek = new Thread(new Robotnik(this, "kilofy", 3));
            watek.start();
        }

    }

    public Toolsmith(Krolestwo k, int zelazo, int kilofy, int siekiery, int drewno)
    {
        this.k = k;
        this.kilofy = kilofy;
        this.drewno = drewno;
        this.zelazo = zelazo;
        this.siekiery=siekiery;
    }

    @Override
    public String toString()
    {
        return "Stan kopalni: Zelazo: " + zelazo + " Drewno: " + drewno + " Kilofy: " + kilofy + "Siekiery: " + siekiery;
    }
}