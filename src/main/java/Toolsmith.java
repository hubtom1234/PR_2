public class Toolsmith extends Thread{
    private Krolestwo k;
    private int siekiery;
    private int drewno;
    private int zelazo;
    private int kilofy;
    public Toolsmith(Krolestwo k, int siekiery, int drewno, int zelazo, int kilofy)
    {
        this.k=k;
        this.siekiery=siekiery;
        this.drewno=drewno;
        this.zelazo=zelazo;
        this.kilofy=kilofy;
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
            for (Drwal d:this.k.getDrwal()) {
                synchronized (d)
                {
                    d.notify();
                }
            }
            for (Kopalnia kop:this.k.getKopalnia()) {
                synchronized (kop)
                {
                    kop.notify();
                }
            }
            //System.out.println("J");
        }
    }
}