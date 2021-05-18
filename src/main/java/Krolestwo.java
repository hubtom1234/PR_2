import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Krolestwo {
    private ArrayList<Ksiezniczka> ksiezniczki = new ArrayList<>();
    private ArrayList<Jubiler> jubilerzy = new ArrayList<>();
    private ArrayList<Krol> krolowie = new ArrayList<>();
    private ArrayList<Wojsko> wojsko = new ArrayList<>();
    private ArrayList<Drwal> drwal = new ArrayList<>();
    private ArrayList<Toolsmith> toolsmith = new ArrayList<>();
    private ArrayList<Weaponsmith> weaponsmith = new ArrayList<>();
    private ArrayList<Kopalnia> kopalnia = new ArrayList<>();

}
