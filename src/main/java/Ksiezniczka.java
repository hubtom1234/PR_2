public class Ksiezniczka extends Thread{
    private Krolestwo k;
    private int blyskotki;
    private int szczescie;
    public Ksiezniczka(Krolestwo k, int blyskotki, int szczescie)
    {
        this.k=k;
        this.blyskotki=blyskotki;
        this.szczescie=szczescie;
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
            System.out.println("Ksiezniczka dostala blyskotke, obecna ilosc blyskotek: "+this.blyskotki);
            for (Krol kr:this.k.getKrolowie()) {
                synchronized (kr)
                {
                    kr.notify();
                }
            }
        }
    }
}
