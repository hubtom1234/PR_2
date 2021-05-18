public class Jubiler extends Thread{
    private Krolestwo k;
    private int blyskotki;
    private int klejnoty;
    public Jubiler(Krolestwo k, int blyskotki, int klejnoty)
    {
        this.k=k;
        this.blyskotki=blyskotki;
        this.klejnoty=klejnoty;
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
            this.blyskotki++;
            for (Ksiezniczka ks:this.k.getKsiezniczki()) {
                synchronized (ks)
                {
                    ks.notify();
                }
            }
            System.out.println("Jubiler wyprodukowal blyskotke");
        }
    }
}
