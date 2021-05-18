import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Robotnik implements Runnable
{
    private Miejsce miejsce;
    private String dobro;
    private float czasWytwarzania;

    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            try
            {
                long czas = (long)(czasWytwarzania * 1000); //czas w ms
                Thread.sleep(czas);
                miejsce.dodajDobro(dobro);
            }
            catch (InterruptedException e){
                System.out.println("Pracownik zakończyl wytwarzanie " + dobro);
                break;
            }
        }
    }
}