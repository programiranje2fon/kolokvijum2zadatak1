package festivali;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import festivali.izuzeci.MuzickiFestivalException;
import test.TestUtil;

public class MuzickiFestivalTest {

	private MuzickiFestival instance;

	@Before
	public void setUp() throws Exception {
		instance = new MuzickiFestival();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut naziv", TestUtil.doesFieldExist(MuzickiFestival.class, "naziv"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan", TestUtil.hasFieldModifier(MuzickiFestival.class, "naziv", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_mesto() {
		assertTrue("U klasi nije definisan atribut mesto", TestUtil.doesFieldExist(MuzickiFestival.class, "mesto"));
	}
	
	@Test
	public void atribut_mesto_vidljivost() {
		assertTrue("Atribut mesto nije privatan", TestUtil.hasFieldModifier(MuzickiFestival.class, "mesto", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_pobednik() {
		assertTrue("U klasi nije definisan atribut pobednik", TestUtil.doesFieldExist(MuzickiFestival.class, "pobednik"));
	}
	
	@Test
	public void atribut_pobednik_vidljivost() {
		assertTrue("Atribut pobednik nije privatan", TestUtil.hasFieldModifier(MuzickiFestival.class, "pobednik", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setNaziv() throws Exception {
		instance.setNaziv("Arsenal Fest");
		String naziv = (String) TestUtil.getFieldValue(instance, "naziv");
		assertEquals("Nakon poziva metode setNaziv(String) sa prosledjenim argumentom \"Arsenal Fest\", vrednost atributa naziv se nije promenila na tu vrednost", "Arsenal Fest", naziv);
	}
	
	@Test(expected = MuzickiFestivalException.class)
	public void metoda_setNaziv_null() throws Exception {
		instance.setNaziv(null);
	}
	
	@Test(expected = MuzickiFestivalException.class)
	public void metoda_setNaziv_prazanString() throws Exception {
		instance.setNaziv("");
	}
	
	@Test
	public void metoda_getNaziv() {
		String naziv = (String) TestUtil.getFieldValue(instance, "naziv");

		assertEquals("Metoda getNaziv ne vraca vrednost atributa naziv", naziv, instance.getNaziv());
	}
	
	@Test
	public void metoda_setMesto() throws Exception {
		instance.setMesto("Kragujevac");
		String mesto = (String) TestUtil.getFieldValue(instance, "mesto");
		assertEquals("Nakon poziva metode setMesto(String) sa prosledjenim argumentom \"Kragujevac\", vrednost atributa mesto se nije promenila na tu vrednost", "Kragujevac", mesto);
	}
	
	@Test(expected = MuzickiFestivalException.class)
	public void metoda_setMesto_null() throws Exception {
		instance.setMesto(null);
	}
	
	@Test(expected = MuzickiFestivalException.class)
	public void metoda_setMesto_prazanString() throws Exception {
		instance.setMesto("");
	}
	
	@Test
	public void metoda_getMesto() {
		String mesto = (String) TestUtil.getFieldValue(instance, "mesto");
		
		assertEquals("Metoda getMesto() ne vraca vrednost atributa mesto", mesto, instance.getMesto());
	}
	
	@Test
	public void metoda_setPobednik() throws Exception {
		instance.setPobednik("ABC");
		String pobednik = (String) TestUtil.getFieldValue(instance, "pobednik");
		assertEquals("Nakon poziva metode setPobednik(String) sa prosledjenim argumentom \"ABC\", vrednost atributa pobednik se nije promenila na tu vrednost", "ABC", pobednik);
	}
	
	@Test(expected = MuzickiFestivalException.class)
	public void metoda_setPobednik_null() throws Exception {
		instance.setPobednik(null);
	}
	
	@Test(expected = MuzickiFestivalException.class)
	public void metoda_setPobednik_prazanString() throws Exception {
		instance.setPobednik("");
	}
	
	@Test
	public void metoda_getPobednik() {
		String pobednik = (String) TestUtil.getFieldValue(instance, "pobednik");
		
		assertEquals("Metoda getPobednik() ne vraca vrednost atributa naziv", pobednik, instance.getPobednik());
	}
	
	@Test
	public void metoda_equals_nijeDobraKlasa() {
		assertFalse("Metoda equals() ne vraca false ako se prosledi objekat druge klase.", instance.equals(new Object()));
	}
	
	@Test
	public void metoda_equals_isti() {
		instance.setNaziv("Aresenal Fest");
		instance.setMesto("Kragujevac");
		
		MuzickiFestival mf1 = new MuzickiFestival();
		mf1.setNaziv("Aresenal Fest");
		mf1.setMesto("Kragujevac");
		
		assertEquals("Metoda equals() ne vraca vrednost true za prosledjen festival sa istim nazivom i mestom.", mf1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitNaziv() {
		instance.setNaziv("Aresenal Fest");
		instance.setMesto("Kragujevac");
		
		MuzickiFestival mf1 = new MuzickiFestival();
		mf1.setNaziv("Exit");
		mf1.setMesto("Kragujevac");
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjen festival sa razlicitim nazivom.", mf1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitoMesto() {
		instance.setNaziv("Aresenal Fest");
		instance.setMesto("Kragujevac");
		
		MuzickiFestival mf1 = new MuzickiFestival();
		mf1.setNaziv("Aresenal Fest");
		mf1.setMesto("Bor");
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjen festival sa razlicitim mestom.", mf1, instance);
	}
	
}
