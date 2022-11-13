
public class Pedijatar extends Lekar {
	public Pedijatar(String ime,String prezime) {
		super(ime,prezime,200);
	}
	
	public int plata() {
		int brojMladjih=0;
		int ostali=0;
		int ukupno=0;
		int plata=0;
		for(int i=0;i<getPacijenti().length;i++) {
			if(getPacijenti()[i].getBrojGodina()<5) {brojMladjih++;} //brojimo mladje od 5
			else ostali++; //brojimo ostale
			if(getPacijenti()[i].getBrojGodina()>18) {ostali--;} //oduzimamo punoletne 
		}
		plata=(brojMladjih*300)+(brojMladjih*100);
		ukupno=ostali*300+plata;
		return ukupno;
	}
	
	@Override
	public boolean prihvati(Pacijent p) {
		if(p.getBrojGodina()>18) {return false;}
		
		return super.prihvati(p);
	}
}
