import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Krolestwo {
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
        this.nazwa=nazwa;
    }

}
