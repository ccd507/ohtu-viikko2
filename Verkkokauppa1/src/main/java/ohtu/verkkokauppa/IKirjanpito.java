package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface IKirjanpito {
    public void lisaaTapahtuma(String tapahtuma);
    public ArrayList<String> getTapahtumat();
}
