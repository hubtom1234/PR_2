public class Weaponsmith extends Thread{
    private Krolestwo k;
    private int zelazo;
    private int bron;
    public Weaponsmith(Krolestwo k, int zelazo, int bron)
    {
        this.k=k;
        this.zelazo=zelazo;
        this.bron=bron;
    }
    @Override
    public void run()
    {
        while(true)
        {
            synchronized(this)
            {
                try
                {
                    this.wait();
                }
                catch (InterruptedException ie){}
            }
            //wycinanie drewna
            for (Wojsko w:this.k.getWojsko()) {
                synchronized (w)
                {
                    w.notify();
                }
            }
            //System.out.println("J");
        }
    }
}