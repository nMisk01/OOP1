
public class Pulmolog extends Lekar{
	public Pulmolog(String ime,String prezime) {
		super(ime,prezime,100);
	}
	
	public int plata() {
		int plata=0;
		for(int i=0;i<getPacijenti().length;i++) {
			plata=getBrojPacijenata()*500;
		}
		return plata;
	}
}
