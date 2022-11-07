import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Poliklinika {
	private Lekar[] lekari;
	
	public Poliklinika(String lekariFajl,String pacijentiFajl) throws IOException{
		ucitajLekare();
		ucitajPacijente();
	}
	
	public void ucitajLekare() throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("res/lekari.txt"));
		
		String ime,prezime,specijalizacija;
		int brojLekara=Integer.parseInt(in.readLine().trim());
		
		lekari=new Lekar[brojLekara];
		
		for(int i=0;i<lekari.length;i++) {
			ime=in.readLine().trim();
			prezime=in.readLine().trim();
			specijalizacija=in.readLine().trim();
			if(specijalizacija.equals("pedijatar")) {
				lekari[i]=new Pedijatar(ime,prezime);
			}
			else if(specijalizacija.equals("pulmolog")) {
				lekari[i]=new Pulmolog(ime, prezime);
			}
			
		
		}
		in.close();
	}

	public void ucitajPacijente() throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("res/pacijenti.txt"));
		
		String ime,prezime;
		int brojPacijenata=0;
		int godine;
		
		brojPacijenata=Integer.parseInt(in.readLine().trim()); 
		
		for(int i=0;i<brojPacijenata;i++) {
			ime=in.readLine().trim();
			prezime=in.readLine().trim();
			godine=Integer.parseInt(in.readLine().trim());
			
			Pacijent pacijent=new Pacijent(ime,prezime,godine);
			
			Random rand=new Random();
			
			lekari[rand.nextInt(lekari.length)].prihvati(pacijent);
		}
		in.close();
	}
	
	public Pulmolog najmanjaPlata() {
		Pulmolog najmanji=null;
		for(int i=0;i<lekari.length;i++) {
			if(lekari[i] instanceof Pulmolog) {
				if(najmanji==null || lekari[i].plata() < najmanji.plata()) {
					najmanji=(Pulmolog)lekari[i]; //kastujemo
				} 
			}
		}
		return najmanji;
	}
	
	public Pedijatar najstarijiPacijenti() {
		double prosek = Double.MIN_VALUE;
		
		Pedijatar najstariji = null;
		
		for(int i = 0; i < this.lekari.length; i++) {
			
			double trenutniProsek = 0;
			if(this.lekari[i] instanceof Pedijatar) {
				if(this.lekari[i].getBrojPacijenata() > 0) {
					for(int j = 0; j < this.lekari[i].getBrojPacijenata(); j++) {
						trenutniProsek += this.lekari[i].getPacijenti()[j].getBrojGodina();
					}
					trenutniProsek /= this.lekari[i].getBrojPacijenata();
					if(trenutniProsek > prosek) {
						prosek = trenutniProsek;
						najstariji = (Pedijatar) this.lekari[i];
					}
				}
			}
		}
		return najstariji;
	}

	@Override
	public String toString() {
		String rezultat= "Poliklinika: ";
		rezultat+= "\n";
		for(int i=0;i<lekari.length;i++) {
			rezultat+= lekari[i].toString()+"\n";
		}
		return rezultat;
	}
	
	
}

