package Paket1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {

	static ArrayList<Automobil> oglas = new ArrayList<Automobil>();

	public static void main(String[] args) {

		Automobil a1 = new Automobil();
		a1.setNaziv("Opel");
		a1.setCena(1000);
		a1.setGodiste(1985);
		a1.setOprema(new String[] { "cd", "dvd", "alarm", "abs", "servo" });

		Automobil a2 = new Automobil();
		a2.setNaziv("Bmw");
		a2.setCena(15200);
		a2.setGodiste(2011);
		a2.setOprema(new String[] { "alarm", "airbag", "klima", "esp", "gps" });

		Automobil a3 = new Automobil();
		a3.setNaziv("Toyota");
		a3.setCena(8900);
		a3.setGodiste(2011);
		a3.setOprema(new String[] { "esp", "parking cam", "felne", "zimske gume", "dvd" });

		Automobil a4 = new Automobil();
		a4.setNaziv("Audi");
		a4.setGodiste(2014);
		a4.setCena(32750);
		a4.setOprema(new String[] { "alarm", "airbag", "gps", "auto-pilot", "parking senzor" });
		
		Automobil a5 = new Automobil();
		a5.setNaziv("Honda");
		a5.setGodiste(2014);
		a5.setCena(27800);
		a5.setOprema(new String[] { "dvd", "maglenke", "tempomat", "putni racunar", "proximity senzor" });

		oglas.add(a1);
		oglas.add(a2);
		oglas.add(a3);
		oglas.add(a4);
		oglas.add(a5);

		// Glavni loop
		int menuItem = -1;

		while (menuItem != 0) {
			menuItem = menu();
			switch (menuItem) {
			case 1:
				prikaziSveOglase();
				break;
			case 2:
				filterGodina();
				break;
			case 3:
				prikaziOglasDetaljno();
				break;
			case 4:
				izmenaOglasa();
				break;
			case 5:
				filterCena();
				break;
			case 6:
				filterOprema();
				break;
			case 7:
				izmeniOpremu();
				break;
			case 8:
				dodajOpremu();
				break;
			case 0:
				break;
			default:
				System.out.println("Nepostojeci unos.");
				break;
			}
		}

	}

	// Ako je izbor broj 1
	private static void prikaziSveOglase() {
		System.out.println("\n## Svi oglasi ##\n");
		for (Automobil auto : oglas) {
			System.out.println(auto.getId() + " " + auto.getNaziv() + " " + auto.getCena() + " e");
		}
	}

	// Funkcija broj 2
	private static void filterGodina() {
		System.out.println("\n## Filter po godini ##");
		Set<Integer> set = new HashSet<Integer>();
		for (Automobil auto : oglas) {
			set.add(auto.getGodiste());
		}

		int izbor;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Odaberite jedno od godista: " + set);
		izbor = input.nextInt();

		if (!set.contains(izbor)) {
			System.out.println("Ne postoji navedeno godiste");
		} else {
			for (Automobil auto : oglas) {
				if (auto.getGodiste() == izbor)
					System.out.println(auto.getId() + " " + auto.getNaziv() + " " + auto.getGodiste() + " "
							+ auto.getCena() + " e");
			}
		}

	}

	// Funkcija broj 3
	private static void prikaziOglasDetaljno() {

		System.out.println("\n## Svi oglasi - Detaljan prikaz ##\n");
		for (Automobil auto : oglas) {
			System.out.println(auto.getId() + " " + auto.getNaziv() + " " + auto.getCena() + " e");
		}
		int izbor;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Prikazi detaljan prikaz za oglas broj: ");
		izbor = input.nextInt();

		for (Automobil auto : oglas) {
			if (auto.getId() != izbor)
				continue;
			else
				System.out.println(auto.getId() + " " + auto.getNaziv() + " " + auto.getCena() + " e "
						+ Arrays.toString(auto.getOprema()));
		}

	}

	// Funkcija broj 4
	private static void izmenaOglasa() {
		System.out.println("\n## Izmeni oglas ##\n");
		int izbor;
		Scanner input = new Scanner(System.in);
		System.out.println("1.Izmeni kategoriju");
		System.out.println("2.Izmeni opremu");
		izbor = input.nextInt();
		switch (izbor) {
		case 1:
			function_4_1();
			break;
		case 2:
			function_4_2();
			break;
		default:
			System.out.println("Nepostojeca naredba.");
			break;
		}

	}

	// Funkcija broj 5
	private static void filterCena() {
		System.out.println("\n## Filter po ceni ##\n");
		int izbor;
		Scanner input = new Scanner(System.in);
		System.out.println("1.Cena od-do");
		System.out.println("2.Cena veca od ");
		System.out.println("3.Cena manja od ");

		izbor = input.nextInt();

		switch (izbor) {
		case 1:
			function_5_1();
			break;
		case 2:
			function_5_2();
			break;
		case 3:
			function_5_3();
			break;
		default:
			System.out.println("Nepostojeca komanda.");
			break;
		}

	}

	// Funkcija broj 6
	private static void filterOprema() {
		System.out.println("\n## Pretrazi po opremi ##\n");
		Set<String> set = new HashSet<String>();

		System.out.println("Odaberite jedan od pojmova: ");
		for (Automobil auto : oglas) {
			for (int i = 0; i < auto.getOprema().length; i++)
				set.add(auto.getOprema()[i]);
		}

		System.out.println(set);

		Scanner input = new Scanner(System.in);
		String match = input.nextLine();
		for (Automobil auto : oglas) {
			for (int i = 0; i < auto.getOprema().length; i++)
				if(match.equalsIgnoreCase(auto.getOprema()[i]))
					System.out.println(auto.getNaziv() + " " + Arrays.toString(auto.getOprema()));
		}
		
	}

	// Funkcija broj 7
	private static void izmeniOpremu() {
		System.out.println("\n## Izmeni kompletnu opremu ##\n");
		
		int izbor;
		Scanner input = new Scanner(System.in);
		for (Automobil auto : oglas) {
			System.out.println(
					auto.getId() + ". " + auto.getNaziv() + " " + auto.getGodiste() + " " + auto.getCena() + " e");

		}

		System.out.println("\nOdaberite broj modela za izmenu opreme: ");
		izbor = input.nextInt();
		for (Automobil auto : oglas) {
			if (auto.getId() != izbor) {
				continue;
			} else {
				System.out.println("Unesite novu opremu i potvrdite, za prekid unesite 0");
				Scanner inputOprema = new Scanner(System.in);
				ArrayList<String> komplet = new ArrayList<>();
				String oprema = ""; 
				
				while(!oprema.equals("0")) {
					oprema = inputOprema.nextLine();
					if(oprema.equals("0"))
						continue;
					komplet.add(oprema);
					System.out.println("Ubaceno " + oprema);
				}
				
				String[] opreme = new String[komplet.size()];
				opreme = komplet.toArray(opreme);
				auto.setOprema(opreme);

			}
		}
	}

	// Dugme broj 8
	private static void dodajOpremu() {
		System.out.println("\n## Dodaj opremu ##\n");
		
		int izbor;
		String novaOprema; 
		Scanner input = new Scanner(System.in);
		Scanner inputOprema = new Scanner(System.in);

		for (Automobil auto : oglas) {
			System.out.println(
					auto.getId() + ". " + auto.getNaziv() + " " + auto.getGodiste() + " " + auto.getCena() + " e");
		}

		System.out.println("\nOdaberite broj modela za dodavanje opreme: ");
		izbor = input.nextInt();
		for (Automobil auto : oglas) {
			if (auto.getId() != izbor) {
				continue;
			} else {
				System.out.println("Trenutna oprema : " + Arrays.toString(auto.getOprema()));
				System.out.println("\nUnesite dodatnu opremu i potvrdite");
				novaOprema = inputOprema.nextLine();
				String[] noviNizOpreme = new String[auto.getOprema().length + 1];
           
				// ovde neki loop 
				
				for (int i = 0; i < noviNizOpreme.length -1; i++) {
					noviNizOpreme[i] = auto.getOprema()[i];
				}
				
				noviNizOpreme[noviNizOpreme.length-1] = novaOprema;
				
                auto.setOprema(noviNizOpreme);
				
				System.out.println("Trenutna oprema : " + Arrays.toString(auto.getOprema()));
				
			}
		}	
	}

	// Funkcija 4.1
	private static void function_4_1() {

		int izbor;
		Scanner input = new Scanner(System.in);
		for (Automobil auto : oglas) {
			System.out.println(
					auto.getId() + ". " + auto.getNaziv() + " " + auto.getGodiste() + " " + auto.getCena() + " e");

		}

		System.out.println("\nOdaberite broj modela za izmenu: ");
		izbor = input.nextInt();

		for (Automobil auto : oglas) {
			if (auto.getId() != izbor) {
				continue;
			} else {
				System.out.println("1.Izmeni naslov");
				System.out.println("2.Izmeni cenu");
				System.out.println("3.Izmeni godiste");
				int noviIzbor;
				Scanner input2 = new Scanner(System.in);
				noviIzbor = input2.nextInt();
				switch (noviIzbor) {
				case 1:
					System.out.println("Unesite novi naslov");
					Scanner inputNaslov = new Scanner(System.in);
					String novNaslov = inputNaslov.nextLine();
					auto.setNaziv(novNaslov);
					break;
				case 2:
					System.out.println("Unesite novu cenu");
					Scanner inputCena = new Scanner(System.in);
					double novaCena = inputCena.nextDouble();
					auto.setCena(novaCena);
					break;
				case 3:
					System.out.println("Unesite novo godiste");
					Scanner inputGod = new Scanner(System.in);
					int novoGod = inputGod.nextInt();
					auto.setGodiste(novoGod);
					break;
				default:
					System.out.println("Nepoznata komanda");
					break;

				}
			}

		}
	}

	// Funkcija 4.2
	private static void function_4_2() {
		int izbor;
		Scanner input = new Scanner(System.in);
		for (Automobil auto : oglas) {
			System.out.println(auto.getId() + ". " + auto.getNaziv() + " " + Arrays.toString(auto.getOprema()));

		}

		System.out.println("\nOdaberite broj modela za izmenu: ");
		izbor = input.nextInt();

		for (Automobil auto : oglas) {
			if (auto.getId() != izbor) {
				continue;
			} else {
				// Ovde bi verovatno mogao neki loop -- while getOprema[].length
				// < 5 --
				Scanner input2 = new Scanner(System.in);
				System.out.println("Unesite novu opremu: ");
				String oprema1 = input2.nextLine();
				String oprema2 = input2.nextLine();
				String oprema3 = input2.nextLine();
				String oprema4 = input2.nextLine();
				String oprema5 = input2.nextLine();

				auto.setOprema(new String[] { oprema1, oprema2, oprema3, oprema4, oprema5 });

			}

		}

	}

	// Funkcija 5.1
	private static void function_5_1() {
		System.out.println("Unesite donju granicu: ");
		Scanner inLowCost = new Scanner(System.in);
		double low = inLowCost.nextDouble();
		System.out.println("Unesite gornju granicu: ");
		Scanner inHighCost = new Scanner(System.in);
		double high = inHighCost.nextDouble();

		for (Automobil auto : oglas) {
			if (auto.getCena() >= low && auto.getCena() <= high) {
				System.out.println(
						auto.getId() + " " + auto.getNaziv() + " " + auto.getGodiste() + " " + auto.getCena() + " e");
			}
		}
	}

	// Funkcija 5.2
	private static void function_5_2() {
		System.out.println("Unesite minimalnu cenu vozila: ");
		Scanner input = new Scanner(System.in);
		double cena = input.nextDouble();

		for (Automobil auto : oglas) {
			if (auto.getCena() >= cena) {
				System.out.println(
						auto.getId() + " " + auto.getNaziv() + " " + auto.getGodiste() + " " + auto.getCena() + " e");
			}
		}

	}

	// Funkcija 5.3
	private static void function_5_3() {
		System.out.println("Unesite maksimalnu cenu vozila: ");
		Scanner input = new Scanner(System.in);
		double cena = input.nextDouble();

		for (Automobil auto : oglas) {
			if (auto.getCena() <= cena) {
				System.out.println(
						auto.getId() + " " + auto.getNaziv() + " " + auto.getGodiste() + " " + auto.getCena() + " e");
			}
		}
	}

	// Funkcija menu koja vraca izbor nazad u loop
	private static int menu() {

		int choice;
		Scanner input = new Scanner(System.in);
		System.out.println("\n## Glavni Meni ##\n");
		System.out.println("0. Ugasiti program");
		System.out.println("1. Prikaz svih oglasa");
		System.out.println("2. Ispis oglasa po godini proizvodnje");
		System.out.println("3. Ispis oglasa detaljno");
		System.out.println("4. Izmena oglasa");
		System.out.println("5. Ispis oglasa po ceni");
		System.out.println("6. Ispis oglasa po opremi");
		System.out.println("7. Izmeni opremu");
		System.out.println("8. Dodaj Opremu");
		System.out.println();
		System.out.println("Unesite izbor: ");

		if (input.hasNextInt()) {
			choice = input.nextInt();

		} else {
			System.out.println("\nMorate uneti broj.");
			choice = -1;
		}

		return choice;
	}

}

class Automobil {

	static int idCounter;

	private int id, godiste;
	private double cena;
	private String naziv;
	private String[] oprema;

	Automobil() {
		idCounter++;
		id = idCounter;
	}

	public int getId() {
		return id;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String[] getOprema() {
		return oprema;
	}

	public void setOprema(String[] oprema) {
		this.oprema = oprema;
	}

}
