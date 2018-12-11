package festivali;

import java.util.List;

public interface Arhiviranje {

	void ucitajFestivaleIzFajla(String nazivFajla);
	
	void objediniArhive(List<String> spisakFajlova, String fajlZaUpis);
}
