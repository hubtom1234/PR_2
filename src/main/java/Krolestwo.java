import java.util.ArrayList;

public class Krolestwo {
    private ArrayList<Ksiezniczka> ksiezniczki;
    private ArrayList<Jubiler> jubilerzy;
    private ArrayList<Krol> krolowie;
    private ArrayList<Wojsko> wojsko;
    private ArrayList<Drwal> drwal;
    private ArrayList<Toolsmith> toolsmith;
    private ArrayList<Weaponsmith> weaponsmith;
    private ArrayList<Kopalnia> kopalnia;
    public Krolestwo()
    {

    }
    public ArrayList<Ksiezniczka> getKsiezniczki() {
        return ksiezniczki;
    }

    public ArrayList<Drwal> getDrwal() {
        return drwal;
    }

    public ArrayList<Jubiler> getJubilerzy() {
        return jubilerzy;
    }

    public ArrayList<Krol> getKrolowie() {
        return krolowie;
    }

    public ArrayList<Toolsmith> getToolsmith() {
        return toolsmith;
    }

    public ArrayList<Weaponsmith> getWeaponsmith() {
        return weaponsmith;
    }

    public ArrayList<Wojsko> getWojsko() {
        return wojsko;
    }
    public ArrayList<Kopalnia> getKopalnia() {
        return kopalnia;
    }

    public void setKsiezniczki(ArrayList<Ksiezniczka> ks)
    {
        this.ksiezniczki=ks;
    }
    public void setJubilerzy(ArrayList<Jubiler> j)
    {
        this.jubilerzy=j;
    }
    public void setKrolowie(ArrayList<Krol> k)
    {
        this.krolowie=k;
    }
    public void setWojsko(ArrayList<Wojsko> w)
    {
        this.wojsko=w;
    }
    public void setDrwal(ArrayList<Drwal> d)
    {
        this.drwal=d;
    }
    public void setToolsmith(ArrayList<Toolsmith> t)
    {
        this.toolsmith=t;
    }
    public void setWeaponsmith(ArrayList<Weaponsmith> w)
    {
        this.weaponsmith=w;
    }
}
