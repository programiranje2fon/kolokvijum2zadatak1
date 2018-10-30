package festivali;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class ArhivaFestivala implements Arhiviranje {

	private List<MuzickiFestival> festivali = new LinkedList<>();

	public void upisiFestivaleUcesnika(String izvodjac) throws Exception {
		if (festivali.isEmpty()) {
			throw new Exception("Ne postoje uneti festivali.");
		}

		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("osvojeni_festivali.out")))) {

			for (MuzickiFestival muzickiFestival : festivali) {
				if (muzickiFestival.getPobednik().equals(izvodjac)) {
					out.writeObject(muzickiFestival);
				}
			}
			out.close();
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}

	@Override
	public void ucitajFestivaleIzFajla(String nazivFajla) {
		try (BufferedReader br = new BufferedReader(new FileReader(nazivFajla))) {
			String s;
			
			while ((s = br.readLine()) != null) {
				String[] delovi = s.split("|");
				
				String naziv = delovi[0];
				String mesto = delovi[1];
				String pobednik = delovi[2];

				MuzickiFestival f = new MuzickiFestival();
				f.setNazivF(naziv);
				f.setMesto(mesto);
				f.setPobednik(pobednik);

				festivali.add(f);
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void objediniArhive(List<String> spisakFajlova) {
		List<MuzickiFestival> objedinjeniFestivali = new LinkedList<>();

		// posto se u listi 'spisakFajlova' nalaze nazivi fajlova u kojima se
		// nalaze podaci o festivalima, prolazimo kroz sve nazive fajlova, 
		// pristupamo svakom fajlu, iscitavamo podatke o festivalima iz njega 
		// i smestamo u listu 'objedinjeniFestivali'
		for (String nazivFajla : spisakFajlova) {
			try (ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(nazivFajla)))) {

				try {
					while (true) {
						MuzickiFestival o = (MuzickiFestival) (in.readObject());

						if (!objedinjeniFestivali.contains(o)) {
							objedinjeniFestivali.add(o);
						}
					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
				System.out.println("Greska: " + e.getMessage());
			}
		}

		// upisivanje objedinjene liste festivala u fajl cela_arhiva.out
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("cela_arhiva.out")))) {

			for (MuzickiFestival muzickiFestival : objedinjeniFestivali) {
				out.writeObject(muzickiFestival);
			}
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}
}
