import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Krolestwo k1=new Krolestwo("rigcz");
        Jubiler j=new Jubiler(k1,1);
        //Kopalnia kop=new Kopalnia(k1,1,2,3);
        Ksiezniczka ks=new Ksiezniczka(k1,1,2);
        ArrayList<Ksiezniczka> ksl=new ArrayList<Ksiezniczka>();
//        ksl.add(ks);
//        k1.setKsiezniczki(ksl);
//        j.start();
//        ks.start();

        Kopalnia kopalnia = new Kopalnia(k1,0,0,0);
        Thread kopalniaWatek = new Thread(kopalnia);
        kopalniaWatek.start();
        kopalnia.oddajDobra("zelazo",5,"Arek");
        kopalnia.oddajDobra("zelazo",5,"Darek");

        //kop.run();
    }
}