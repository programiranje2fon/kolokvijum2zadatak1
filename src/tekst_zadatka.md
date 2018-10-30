# Zadatak 1

Napraviti javnu klasu **MuzickiFestivalException** u paketu **festivali.izuzeci** koja predstavlja neproveravani izuzetak i ima :
- Javni konstruktor koji kao parametar prima poruku greške i poziva odgovarajući konstruktor nadklase prosleđujući mu parametar.

Napraviti javnu klasu **MuzickiFestival** u paketu **festivali** koja može da bude serijalizovana i ima:
- Privatni atribut **naziv**.
- Privatni atribut **mesto**.
- Privatni atribut **pobednik** koji predstavlja ime izvođača koji je pobedio na festivalu.
- Odgovarajuće **javne get i set metode** za ove atribute. Nedozvoljene vrednosti za naziv, mesto i pobednika su null i prazan String. U slučaju unosa nedozvoljenih vrednosti, baciti izuzetak klase MuzičkiFestivalException sa odgovarajućom porukom.
- Redefinisanu **equals** metodu klase Object. Metoda prvo proverava da li je uneti objekat klase **MuzickiFestival**, pa ako nije, vraća FALSE. Metoda vraća true ako su naziv i mesto jednaki nazivu i mestu unetog festivala, a inače false.

Napraviti javni interfejs **Arhiviranje** u paketu **festivali** koji ima:
- Metodu **ucitajFestivaleIzFajla** koja kao ulaz dobija naziv fajla i ne vraća ništa.
- Metodu **objediniArhive** koja kao ulazni parametar dobija listu String vrednosti koje predstavljaju nazive fajlova i ne vraća ništa.

Napraviti javnu klasu **ArhivaFestivala** u paketu **festivali** koja ima:
- Privatni atribut **festivali** koji je lista objekata klase **MuzickiFestival**. Listu odmah inicijalizovati.
- Javnu metodu **upisiFestivaleUcesnika** koja kao ulazni parametar prima ime izvođača i u fajl "osvojeni_festivali.out" serijalizuje podatke o svim muzičkim festivalima iz liste na kojima je taj izvođač pobedio. Ako je lista prazna, ova metoda bi trebalo da baci PROVERAVANI izuzetak sa odgovarajućom porukom.
- Javnu metodu **ucitajFestivaleIzFajla** koja kao parametar dobija naziv tekstualnog fajla iz kojeg učitava podatke o muzičkim festivalima i dodaje ih u listu. Podaci o svakom festivalu su dati u posebnom redu u sledećem formatu: <naziv>|<mesto>|<pobednik>. U slučaju pojavljivanja nekog izuzetka, samo uhvatiti izuzetak i ne raditi ništa (ne ispisivati čak ni poruku izuzetka).
- Javnu metodu **objediniArhive** koja kao ulazni parametar dobija listu String vrednosti čiji svaki element predstavlja naziv nekog fajla. U svakom od ovih fajlova se nalaze serijalizovani podaci više muzičkih festivala, i može da se desi da se neki festivali pojavljuju u više fajlova istovremeno. Metoda bi trebalo da objedini sve podatke iz ovih fajlova i da ih serijalizuje u fajl "cela_arhiva.out", ali tako da ne bude duplih unosa.