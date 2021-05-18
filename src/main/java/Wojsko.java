import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import lombok.SneakyThrows;
public class Wojsko extends Thread{
    private Krolestwo k;
    private int dowodzenie;
    private int indeks;
    private boolean zyje=true;
    public Wojsko(Krolestwo k, int dowodzenie, int indeks)
    {
        this.k=k;
        this.dowodzenie=dowodzenie;
        this.indeks=indeks;
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
    public void walka(Krolestwo wrogieKrolestwo)
    {
        Random generator=new Random();
        int przeciwnik=generator.nextInt();
        if(przeciwnik<0)
            przeciwnik=-przeciwnik;
        przeciwnik=przeciwnik%wrogieKrolestwo.getWojsko().size();
        float szansa1=this.dowodzenie*(generator.nextFloat()%1);
        float szansa2=this.dowodzenie*(generator.nextFloat()%1);
        if(szansa1>szansa2)
        {
            wrogieKrolestwo.usunWoja(przeciwnik);
            System.out.println(this.indeks+" wojownik krolestwa "+this.k.getNazwa()+" zabil "+przeciwnik+" wojownika "+wrogieKrolestwo.getNazwa()+" krolestwa");
        }
        else
        {
            this.k.usunWoja(this.indeks);
            System.out.println(this.indeks+" wojownik krolestwa "+this.k.getNazwa()+" zostal pokonany przez "+przeciwnik+" wojownika "+wrogieKrolestwo.getNazwa()+" krolestwa");

        }
        System.out.println(this.k.getNazwa()+": "+this.k.getWojsko().size()+" wojownikow");
        System.out.println(wrogieKrolestwo.getNazwa()+": "+wrogieKrolestwo.getWojsko().size()+" wojownikow");
    }
}
