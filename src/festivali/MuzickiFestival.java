package festivali;

import java.io.Serializable;

import festivali.izuzeci.MuzickiFestivalException;

public class MuzickiFestival implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String naziv;
	private String mesto;
	private String pobednik;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.isEmpty()) {
			throw new MuzickiFestivalException("Naziv festivala ne moze biti null ili prazan string.");
		}
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		if (mesto == null || mesto.isEmpty()) {
			throw new MuzickiFestivalException("Mesto odrzavanja festivala ne moze biti null ili prazan string.");
		}
		this.mesto = mesto;
	}

	public String getPobednik() {
		return pobednik;
	}

	public void setPobednik(String pobednik) {
		if (pobednik == null || pobednik.isEmpty()) {
			throw new MuzickiFestivalException("Pobednik festivala ne moze biti null ili prazan string.");
		}
		this.pobednik = pobednik;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MuzickiFestival))
			return false;

		MuzickiFestival ff = (MuzickiFestival) obj;

		return this.naziv.equals(ff.naziv) && this.mesto.equals(ff.mesto);
	}
}
