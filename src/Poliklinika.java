import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Poliklinika {
	private Lekar[] lekari;
	
	public Poliklinika(String lekariFajl,String pacijentiFajl) throws IOException{
	
	
		BufferedReader inLekari=new BufferedReader(new FileReader("res/lekari.txt"));
		
		String ime,prezime,specijalizacija;
		int brojLekara=Integer.parseInt(inLekari.readLine().trim());
		
		lekari=new Lekar[brojLekara];
		
		for(int i=0;i<lekari.length;i++) {
			ime=inLekari.readLine().trim();
			prezime=inLekari.readLine().trim();
			specijalizacija=inLekari.readLine().trim();
			if(specijalizacija.equals("pedijatar")) {
				lekari[i]=new Pedijatar(ime,prezime);
			}
			else if(specijalizacija.equals("pulmolog")) {
				lekari[i]=new Pulmolog(ime, prezime);
			}
			
		
		}
		inLekari.close();
	

		BufferedReader inPacijenti=new BufferedReader(new FileReader("res/pacijenti.txt"));
		
		String imeP,prezimeP;
		int brojPacijenata=0;
		int godine;
		
		brojPacijenata=Integer.parseInt(inPacijenti.readLine().trim()); 
		
		for(int i=0;i<brojPacijenata;i++) {
			imeP=inPacijenti.readLine().trim();
			prezimeP=inPacijenti.readLine().trim();
			godine=Integer.parseInt(inPacijenti.readLine().trim());
			
			Pacijent pacijent=new Pacijent(imeP,prezimeP,godine);
			
			Random rand=new Random();
			
			lekari[rand.nextInt(lekari.length)].prihvati(pacijent);
		}
		inPacijenti.close();
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

