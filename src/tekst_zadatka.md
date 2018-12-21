# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javnu klasu **MuzickiFestivalException** u paketu **festivali.izuzeci** koja predstavlja neproveravani izuzetak i ima:
- Javni konstruktor koji kao parametar prima poruku greške i poziva odgovarajući konstruktor nadklase prosleđujući mu parametar.

Napraviti javnu klasu **MuzickiFestival** u paketu **festivali** koja može da bude serijalizovana i ima:
- Privatni atribut **naziv**.
- Privatni atribut **mesto**.
- Privatni atribut **pobednik** koji predstavlja ime izvođača koji je pobedio na festivalu.
- Odgovarajuće **javne get i set metode** za ove atribute. Nedozvoljene vrednosti za naziv, mesto i pobednik su NULL i prazan String. U slučaju unosa nedozvoljenih vrednosti, baciti izuzetak klase MuzičkiFestivalException sa odgovarajućom porukom.
- Redefinisanu **equals** metodu klase Object. Metoda prvo proverava da li je uneti objekat klase **MuzickiFestival**, pa ako nije, vraća FALSE. Metoda vraća true ako su naziv i mesto jednaki nazivu i mestu unetog festivala, a inače false.

Napraviti javni interfejs **Arhiviranje** u paketu **festivali** koji ima:
- Metodu **ucitajFestivaleIzFajla** koja kao ulaz dobija naziv fajla i ne vraća ništa.
- Metodu **objediniArhive** koja kao ulazne parametre dobija listu String vrednosti koje predstavljaju nazive fajlova odakle će se isčitavati podaci i kao drugi parametar naziv fajla u koji će se sačuvati podaci. Metoda ne vraća ništa.

Napraviti javnu klasu **ArhivaFestivala** u paketu **festivali** koja ima:
- Privatni atribut **festivali** koji je lista objekata klase **MuzickiFestival**. Listu odmah inicijalizovati.
- Javnu metodu **upisiFestivaleUcesnika** koja kao ulazni parametar prima ime izvođača i naziv fajla u koji serijalizuje podatke o svim muzičkim festivalima iz liste na kojima je taj izvođač pobedio. Ako je lista prazna, ova metoda bi trebalo da baci PROVERAVANI izuzetak sa odgovarajućom porukom.
- Javnu metodu **ucitajFestivaleIzFajla** koja kao parametar dobija naziv tekstualnog fajla iz kojeg učitava podatke o muzičkim festivalima i dodaje ih u listu. Podaci o svakom festivalu su dati u posebnom redu u sledećem formatu: &lt;naziv&gt;#&lt;mesto&gt;#&lt;pobednik&gt;. U slučaju pojavljivanja nekog izuzetka, samo uhvatiti izuzetak i ne raditi ništa (ne ispisivati čak ni poruku izuzetka).
- Javnu metodu **objediniArhive** koja kao ulazni parametar dobija listu String vrednosti čiji svaki element predstavlja naziv nekog fajla. U svakom od ovih fajlova se nalaze serijalizovani podaci više muzičkih festivala, i može da se desi da se neki festivali pojavljuju u više fajlova istovremeno. Metoda bi trebalo da objedini sve podatke iz ovih fajlova i da ih serijalizuje u fajl čiji naziv se prosleđuje kao drugi parametar, ali tako da ne bude duplih unosa.

# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja kao parametar dobija niz String vrednosti i pronalazi i ispisuje na ekranu svaki String iz ovog niza koji predstavlja palindrom (izraz koji se čita isto i sa leva na desno i sa desna na levo bez obzira na prazna mesta tj. blanko znakove; npr. "OKO", "ABBA" ili "ANA VOLI MILOVANA").  Na primer, ako metoda kao ulaz dobije niz sa pet String vrednosti {"OKO", "I JOGURT UJUTRU GOJI", "RUDAR", "ZUTO", "ANA VOLI MILOVANA"}, konačan izlaz na ekranu treba da bude:

	OKO
	I JOGURT UJUTRU GOJI
	ANA VOLI MILOVANA

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti klasu **StringOperacije** u paketu **ispravka_koda**, prekucati u nju kod koji je dat i uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Napraviti test klasu i, koristeći njenu **main** metodu, pozvati metodu **pronadjiPalindrome()** i proveriti njen rad.

	public class StringOperacije {
		public static void pronadjiPalindrome(String[] niz) {
			for (int i = 0; i < niz.length; i++) {				
				boolean palindrom = true;
				String s = niz[i].replace(" ", "");
				for (int j = 0; j < s.length() / 2; j++)
					if (s.charAt(j) == s.charAt(s.length() - j))
						palindrom = !palindrom;
				if (palindrom) System.out.println(niz[i]);
			}
		}
	}