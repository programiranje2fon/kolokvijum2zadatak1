package festivali;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class ArhivaFestivalaTest {

	private ArhivaFestivala instance;

	@Before
	public void setUp() throws Exception {
		instance = new ArhivaFestivala();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_festivali() {
		assertTrue("U klasi nije definisan atribut festivali", TestUtil.doesFieldExist(ArhivaFestivala.class, "festivali"));
	}
	
	@Test
	public void atribut_festivali_vidljivost() {
		assertTrue("Atribut festivali nije privatan", TestUtil.hasFieldModifier(ArhivaFestivala.class, "festivali", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_upisiFestivaleUcesnika() throws Exception {
		@SuppressWarnings("unchecked")
		List<MuzickiFestival> festivali = (List<MuzickiFestival>) TestUtil.getFieldValue(instance, "festivali");

		MuzickiFestival mf1 = new MuzickiFestival();
		mf1.setNaziv("Arsenal Fest");
		mf1.setMesto("Kragujevac");
		mf1.setPobednik("Van Gogh");
		
		MuzickiFestival mf2 = new MuzickiFestival();
		mf2.setNaziv("Exit");
		mf2.setMesto("Novi Sad");
		mf2.setPobednik("Goblini");
		
		MuzickiFestival mf3 = new MuzickiFestival();
		mf3.setNaziv("Sabacki letnji festival");
		mf3.setMesto("Sabac");
		mf3.setPobednik("Van Gogh");
		
		festivali.add(mf1);
		festivali.add(mf2);
		festivali.add(mf3);
		
		String nazivFajla = "fajl.out";
		
		instance.upisiFestivaleUcesnika("Van Gogh", nazivFajla);
		
		@SuppressWarnings("unchecked")
		List<MuzickiFestival> listaFestivala = (List<MuzickiFestival>) ucitajIzFajla(nazivFajla);
		
		assertTrue("Za arhivu festivala sa sledecim festivalima: 'Arsenal Fest/Kragujevac/Van Gogh', 'Exit/Novi Sad/Goblini' i 'Sabacki letnji festival/Sabac/Van Gogh', za prosledjeni prvi argument 'Van Gogh', metoda nije upisala u fajl prvi i treci festival", listaFestivala.size() == 2 && listaFestivala.contains(mf1) && listaFestivala.contains(mf3));
	
		// brisemo kreirani fajl
		new File(nazivFajla).delete();
	}
	
	@Test
	public void metoda_ucitajFestivaleIzFajla() throws Exception {
		// upisi u fajl
		String sadrzajFajla = 
				"Arsenal Fest#Kragujevac#Van Gogh\n" + 
				"Exit#Novi Sad#Goblini";
	
		String nazivFajla = "fajl1.txt";
		try (PrintWriter out = new PrintWriter(nazivFajla)) {
			out.print(sadrzajFajla);
		} catch (Exception e) {
			throw e;
		}
		
		MuzickiFestival mf1 = new MuzickiFestival();
		mf1.setNaziv("Arsenal Fest");
		mf1.setMesto("Kragujevac");
		mf1.setPobednik("Van Gogh");
		
		MuzickiFestival mf2 = new MuzickiFestival();
		mf2.setNaziv("Exit");
		mf2.setMesto("Novi Sad");
		mf2.setPobednik("Goblini");
		
		instance.ucitajFestivaleIzFajla(nazivFajla);
		
		@SuppressWarnings("unchecked")
		List<MuzickiFestival> festivali = (List<MuzickiFestival>) TestUtil.getFieldValue(instance, "festivali");
		
		MuzickiFestival prvi = festivali.get(0);
		assertTrue("Kada se metodi prosledi naziv fajla sa sadrzajem: \"Arsenal Fest#Kragujevac#Van Gogh\nExit#Novi Sad#Goblini\", naziv prvog festivala se ne ucita ispravno.", mf1.getNaziv().equals(prvi.getNaziv()));
		assertTrue("Kada se metodi prosledi naziv fajla sa sadrzajem: \"Arsenal Fest#Kragujevac#Van Gogh\nExit#Novi Sad#Goblini\", mesto prvog festivala se ne ucita ispravno.", mf1.getMesto().equals(prvi.getMesto()));
		assertTrue("Kada se metodi prosledi naziv fajla sa sadrzajem: \"Arsenal Fest#Kragujevac#Van Gogh\nExit#Novi Sad#Goblini\", pobednik prvog festivala se ne ucita ispravno.", mf1.getPobednik().equals(prvi.getPobednik()));

		MuzickiFestival drugi = festivali.get(1);
		assertTrue("Kada se metodi prosledi naziv fajla sa sadrzajem: \"Arsenal Fest#Kragujevac#Van Gogh\nExit#Novi Sad#Goblini\", naziv drugog festivala se ne ucita ispravno.", mf2.getNaziv().equals(drugi.getNaziv()));
		assertTrue("Kada se metodi prosledi naziv fajla sa sadrzajem: \"Arsenal Fest#Kragujevac#Van Gogh\nExit#Novi Sad#Goblini\", mesto drugog festivala se ne ucita ispravno.", mf2.getMesto().equals(drugi.getMesto()));
		assertTrue("Kada se metodi prosledi naziv fajla sa sadrzajem: \"Arsenal Fest#Kragujevac#Van Gogh\nExit#Novi Sad#Goblini\", pobednik drugog festivala se ne ucita ispravno.", mf2.getPobednik().equals(drugi.getPobednik()));
	
		// brisemo kreirani fajl
		new File(nazivFajla).delete();
	}
	
	@Test
	public void metoda_objediniArhive() throws Exception {
		String nazivFajla1 = "fajl1.out";
		String nazivFajla2 = "fajl2.out";
		String nazivFajla3 = "fajl3.out";

		MuzickiFestival mf1 = new MuzickiFestival();
		mf1.setNaziv("Arsenal Fest");
		mf1.setMesto("Kragujevac");
		mf1.setPobednik("Van Gogh");
		
		MuzickiFestival mf2 = new MuzickiFestival();
		mf2.setNaziv("Exit");
		mf2.setMesto("Novi Sad");
		mf2.setPobednik("Goblini");
		
		// upisi u prvi fajl prvi i drugi festival
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(nazivFajla1)))) {

			out.writeObject(mf1);
			out.writeObject(mf2);
		} catch (Exception e) {
			throw e;
		}

		MuzickiFestival mf3 = new MuzickiFestival();
		mf3.setNaziv("Sabacki letnji festival");
		mf3.setMesto("Sabac");
		mf3.setPobednik("Van Gogh");
		
		// upisi u drugi fajl drugi i treci festival
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(nazivFajla2)))) {

			out.writeObject(mf2);
			out.writeObject(mf3);
		} catch (Exception e) {
			throw e;
		}
		
		instance.objediniArhive(Arrays.asList(nazivFajla1, nazivFajla2), nazivFajla3);
		
		@SuppressWarnings("unchecked")
		List<MuzickiFestival> arhiviraniFestivali = (List<MuzickiFestival>) ucitajIzFajla(nazivFajla3);
		
		assertEquals("Kada imamo dva fajla sa ukupno 4 festivala, gde se jedan festival ponavlja u oba fajla, metoda objediniArhive() nije u novi fajl dodala 3 objekta", 3, arhiviraniFestivali.size());
		assertTrue("Kada imamo dva fajla sa ukupno 4 festivala, gde se jedan festival ponavlja u oba fajla, metoda objediniArhive() nije u novi fajl dodala prvi festival is prvog fajla", arhiviraniFestivali.contains(mf1));
		assertTrue("Kada imamo dva fajla sa ukupno 4 festivala, gde se jedan festival ponavlja u oba fajla, metoda objediniArhive() nije u novi fajl dodala festival koji je zajednicki za oba fajla", arhiviraniFestivali.contains(mf2));
		assertTrue("Kada imamo dva fajla sa ukupno 4 festivala, gde se jedan festival ponavlja u oba fajla, metoda objediniArhive() nije u novi fajl dodala drugi festival is drugog fajla", arhiviraniFestivali.contains(mf3));
		
		// brisemo kreirane fajlove
		new File(nazivFajla1).delete();
		new File(nazivFajla2).delete();
		new File(nazivFajla3).delete();
	}
	
	private List<?> ucitajIzFajla(String nazivFajla) {
		List<Object> lista = new LinkedList<>();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nazivFajla))) {
			try {
				while (true) {
					Object t = (in.readObject());
					lista.add(t);
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
		return lista;
	}
	
}
