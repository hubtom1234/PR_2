public interface Miejsce
{
    public void dodajDobro(String nazwa);

    public void oddajDobra(String nazwa, int ilosc, String kto) throws InterruptedException;

    public boolean sprobujZabracDobra(String nazwa, int ilosc);
}
