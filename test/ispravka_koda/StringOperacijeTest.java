package ispravka_koda;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringOperacijeTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));		
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void metoda_pronadjiPalindrome() {
		String[] niz = new String[] { "OKO", "I JOGURT UJUTRU GOJI", "RUDAR", "ZUTO", "ANA VOLI MILOVANA" };

		String ocekivaniIspis = "OKO\n" +
				"I JOGURT UJUTRU GOJI\n" + 
				"ANA VOLI MILOVANA\n";
		
		StringOperacije.pronadjiPalindrome(niz);
		
		assertEquals("NE ispisuju se reci koji su palindromi", ocekivaniIspis, outContent.toString());
	}
}
