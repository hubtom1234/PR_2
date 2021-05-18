import java.util.Random;

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
        return "Stan drwala: Drewno: " + drewno + ", Siekiery: " + siekiery;
    }
}