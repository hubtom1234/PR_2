import lombok.Getter;
import lombok.Setter;

public class Krolestwo implements Runnable{
    @Getter
    @Setter
    private String nazwa;
    @Getter
    @Setter
    private Ksiezniczka ksiezniczka;
    @Getter
    @Setter
    private Jubiler jubiler;
    @Getter
    @Setter
    private Krol krol;
    @Getter
    @Setter
    private Wojsko wojsko;
    @Getter
    @Setter
    private Drwal drwal;
    @Getter
    @Setter
    private Toolsmith toolsmith;
    @Getter
    @Setter
    private Weaponsmith weaponsmith;
    @Getter
    @Setter
    private Kopalnia kopalnia;

    public Krolestwo(String nazwa)
    {
        this.nazwa = nazwa;
        this.drwal = new Drwal(this, 10 ,5);
        this.jubiler = new Jubiler(this, 0);
        this.kopalnia = new Kopalnia(this, 10, 5 , 2);
    }

    @Override
    public void run()
    {
        Thread kopalniaWatek = new Thread(kopalnia);
        kopalniaWatek.start();

        Thread drwalWatek = new Thread(drwal);
        drwalWatek.start();

        Thread jubilerWatek = new Thread(jubiler);
        jubilerWatek.start();
    }
}
