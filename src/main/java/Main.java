import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Krolestwo k1=new Krolestwo("Super Krolestwo");
        Krolestwo k2=new Krolestwo("Lepsze Krolestwo");
       // Jubiler j=new Jubiler(k1,1,2);
       // Kopalnia kop=new Kopalnia(k1,1,2,3);
       // Ksiezniczka ks=new Ksiezniczka(k1,1,2);
        //ArrayList<Ksiezniczka> ksl=new ArrayList<Ksiezniczka>();
       // ksl.add(ks);
       // k1.setKsiezniczki(ksl);
       // j.start();
        //ks.start();

        ArrayList<Wojsko> wojsko1=new ArrayList<Wojsko>();
        ArrayList<Wojsko> wojsko2=new ArrayList<Wojsko>();
        for(int i=0; i<100;i++)
        {
            wojsko1.add(new Wojsko(k1,21,i));
            wojsko2.add(new Wojsko(k2,37,i));
        }
        k1.setWojsko(wojsko1);
        k2.setWojsko(wojsko2);
        while(k1.getWojsko().size()>0||k2.getWojsko().size()>0)
        {
            for(int i=0;i<k1.getWojsko().size();i++)
            {
                k1.getWojsko().get(i).walka(k2);
            }
        }
        //kop.run();
    }
}
