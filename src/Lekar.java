import java.util.Arrays;

public abstract class Lekar {
	private String ime;
	private String prezime;
	private Pacijent[] pacijenti;
	private int brojPacijenata;
	private int maxPacijenata;
	
	public Lekar(String ime,String prezime,int maxPacijenata) {
		this.ime=ime;
		this.prezime=prezime;
		this.pacijenti=new Pacijent[maxPacijenata];
		this.brojPacijenata=0;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public Pacijent[] getPacijenti() {
		return pacijenti;
	}

	public int getBrojPacijenata() {
		return brojPacijenata;
	}

	public int getMaxPacijenata() {
		return maxPacijenata;
	}
	
	public boolean prihvati(Pacijent p) {
		//if(p.getBrojGodina()>18) {return false;}
		
		if(getBrojPacijenata()<pacijenti.length) {
			for(int i=getBrojPacijenata();i<pacijenti.length;i++) {
				pacijenti[brojPacijenata++]=p;
				return true;
			}
		}
		return false;
	}
	
	public abstract int plata();

	@Override
	public String toString() {
		String rezultat= "Lekar [ime=" + getIme() + ", prezime=" + getPrezime() + " " +getClass().toString()+"\n"; 
		rezultat+="Pacijenti: ";
			for(int i=0;i<getBrojPacijenata();i++) {
				rezultat+=getPacijenti()[i].toString()+"\n";			
			}	
		return rezultat;
	}
	
	
}
