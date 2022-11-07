import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		Poliklinika poliklinika=new Poliklinika("res/lekari.txt","res/pacijenti.txt");
		
		System.out.println(poliklinika);
		System.out.println("*****************|-----------------------------------|**************");
		System.out.println("*Pulmolog sa najmanjom platom je: *");
		System.out.println(poliklinika.najmanjaPlata());
		System.out.println("*****************|-----------------------------------|**************");
		System.out.println("*Pedijatar sa najstarijim pacijentima je: *");
		System.out.println(poliklinika.najstarijiPacijenti());
		System.out.println("*****************|-----------------------------------|**************");
		
	}
	
	
	
}
