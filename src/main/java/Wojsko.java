public class Wojsko extends Thread{
    private Krolestwo k;
    private int bron;
    private int dowodzenie;
    public Wojsko(Krolestwo k, int bron, int dowodzenie)
    {
        this.k=k;
        this.bron=bron;
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
        }
    }
}
