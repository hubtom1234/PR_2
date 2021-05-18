public class Drwal extends Thread
{
    private Krolestwo k;
    private int siekiery;
    private int drewno;

    public Drwal(Krolestwo k, int siekiery, int drewno)
    {
        this.k = k;
        this.siekiery = siekiery;
        this.drewno = drewno;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                try
                {
                    this.wait();
                    System.out.println("Tescik");
                } catch (InterruptedException ie)
                {
                }
            }
            //wycinanie drewna
            for (Toolsmith t : this.k.getToolsmith())
            {
                synchronized (t)
                {
                    t.notify();
                }
            }
            //System.out.println("J");
        }
    }
}