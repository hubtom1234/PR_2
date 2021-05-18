import java.util.Random;
import lombok.SneakyThrows;
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


    @SneakyThrows
    @Override
    public void run()
    {
        Random generator=new Random();
        while (!Thread.interrupted())
        {
            k.getKopalnia().oddajDobra("zelazo", 3,"Ksiezniczka");
            k.getDrwal().oddajDobra("drewno",3,"Ksiezniczka");
            this.wait(15000);
            if(generator.nextInt()%2==0)
            {
                siekiery++;
            }
            else
            {
                kilofy++;
            }
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