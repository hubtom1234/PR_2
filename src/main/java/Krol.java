public class Krol extends Thread{
    private Krolestwo k;
    private int szczescie;
    private int dowodzenie;
    public Krol(Krolestwo k, int szczescie, int dowodzenie)
    {
        this.k=k;
        this.szczescie=szczescie;
        this.dowodzenie=dowodzenie;
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
            this.szczescie++;
        }
    }
}

