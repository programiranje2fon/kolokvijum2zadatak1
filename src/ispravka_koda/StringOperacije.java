package ispravka_koda;

public class StringOperacije {

	public static void pronadjiPalindrome(String[] niz) {
		for (int i = 0; i < niz.length; i++) {
			boolean palindrom = true;
			String s = niz[i].replace(" ", "");
			for (int j = 0; j < s.length() / 2; j++)
				if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
					palindrom = !palindrom;
					break;
				}
			if (palindrom)
				System.out.println(niz[i]);
		}
	}
}
