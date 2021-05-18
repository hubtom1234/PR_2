import java.util.Random;

public class Kopalnia extends Thread {
    private Krolestwo k;
    private int zelazo;
    private int kilofy;
    private int klejnoty;
    @Override
    public void run()
    {
        Random generator=new Random();
        int i=0;
        while(i<100)
        {
            if(generator.nextInt()%2==0)
            {
                this.zelazo++;
            }
            if(generator.nextInt()%3==0)
            {
                this.kilofy++;
            }
            if(generator.nextInt()%5==0)
            {
                this.klejnoty++;
            }
            System.out.println("Zasoby kopalni: "+this.zelazo+" stali, "+this.kilofy+" kilofow, "+this.klejnoty+" klejnotow.");
            i++;
        }
        for (Weaponsmith w:this.k.getWeaponsmith()) {
            synchronized (w)
            {
                w.notify();
            }
        }
        for (Toolsmith t:this.k.getToolsmith()) {
            synchronized (t)
            {
                t.notify();
            }
        }
        for (Jubiler j:this.k.getJubilerzy()) {
            synchronized (j)
            {
                j.notify();
            }
        }
    }
    public Kopalnia(Krolestwo k, int zelazo, int kilofy, int klejnoty)
    {
        this.k=k;
        this.kilofy=kilofy;
        this.klejnoty=klejnoty;
        this.zelazo=zelazo;
    }
}
