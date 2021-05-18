import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Krolestwo k1=new Krolestwo();
        Jubiler j=new Jubiler(k1,1,2);
        Kopalnia kop=new Kopalnia(k1,1,2,3);
        Ksiezniczka ks=new Ksiezniczka(k1,1,2);
        ArrayList<Ksiezniczka> ksl=new ArrayList<Ksiezniczka>();
        ksl.add(ks);
        k1.setKsiezniczki(ksl);
        j.start();
        ks.start();

        //kop.run();
    }
}
