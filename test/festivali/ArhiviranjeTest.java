package festivali;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import test.TestUtil;

public class ArhiviranjeTest {

	@Test
	public void metoda_ucitajFestivaleIzFajla() {
		assertTrue("U interfejsu nije definisana metoda ucitajFestivaleIzFajla(String)", TestUtil.doesMethodExist(Arhiviranje.class, "ucitajFestivaleIzFajla", new Class<?>[]{String.class}));
	}
	
	@Test
	public void metoda_objediniArhive() {
		assertTrue("U interfejsu nije definisana metoda objediniArhive(List)", TestUtil.doesMethodExist(Arhiviranje.class, "objediniArhive", new Class<?>[]{List.class, String.class}));
	}
}
