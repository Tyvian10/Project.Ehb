import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private ArrayList<Vlucht> vluchten = new ArrayList<>();
    private ArrayList<Personen> passagiers = new ArrayList<>();
    private ArrayList<Personeel> Personeelsleden = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>(); // Toevoeging van tickets lijst

    public static void main(String[] args) {
        // Start het keuzemenu
        Main main = new Main();
        main.startMenu();
    }

    public Main() {
        // Constructor voor eventuele initiële instellingen
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean doorgaan = true;

        while (doorgaan) {
            System.out.println("===== Keuzemenu =====");
            System.out.println("1. Nieuwe passagier");
            System.out.println("2. Nieuwe vlucht aanmaken");
            System.out.println("3. Personeel toewijzen aan vlucht");
            System.out.println("4. Beschikbare vluchten");
            System.out.println("5. Personeelsleden aanmaken");
            System.out.println("6. Boarding op vlucht");
            System.out.println("7. Ticket maken");
            System.out.println("0. Afsluiten");
            System.out.print("Maak een keuze: ");

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    maakPassagierAan();
                    break;
                case 2:
                    maakVluchtAan();
                    break;
                case 3:
                    personeelToewijzenAanVlucht();
                    break;
                case 4:
                    toonBeschikbareVluchten();
                    break;
                case 5:
                    maakPersoneelAan();
                    break;
                case 6:
                    // TODO: Implementatie voor boarding op vlucht
                    break;

                case 7:
                    maakTicketAan();
                    break;
                case 0:
                    System.out.println("Programma wordt afgesloten...");
                    doorgaan = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }

            System.out.println();
        }

        scanner.close();
    }

    public void maakPassagierAan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Maak Passagier Aan =====");
        System.out.print("Voer je naam in: ");
        String naam = scanner.nextLine();

        System.out.print("Voer je leeftijd in: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Voer je adres in: ");
        String address = scanner.nextLine();

        Personen persoon = new Personen(naam, age, address);
        passagiers.add(persoon);

        System.out.println("Passagier toegevoegd!");
    }

    public void toonPassagiers() {
        System.out.println("===== Lijst van Passagiers =====");
        if (passagiers.isEmpty()) {
            System.out.println("Er zijn momenteel geen passagiers opgeslagen.");
        } else {
            for (Personen passagier : passagiers) {
                System.out.println("Naam: " + passagier.getName() + ", Leeftijd: " + passagier.getAge() + ", Adres: " + passagier.getAddress());
            }
        }
    }

    public void maakVluchtAan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Nieuwe Vlucht Aanmaken =====");
        System.out.print("Voer de bestemming van de vlucht in: ");
        String bestemming = scanner.nextLine();

        System.out.print("Voer de vluchtcode in: ");
        int vluchtCode = scanner.nextInt();
        scanner.nextLine(); // Verwijder newline-karakter

        System.out.print("Voer het vertrekpunt in: ");
        String vertrekpunt = scanner.nextLine();

        System.out.print("Hoeveel zitplaatsen economy: ");
        int plaatsenEconomy = scanner.nextInt();

        System.out.print("Hoeveel zitplaatsen business: ");
        int plaatsenBusiness = scanner.nextInt();

        // Maak een vliegtuig aan
        Vliegtuig vliegtuig = new Vliegtuig(plaatsenEconomy, plaatsenBusiness);

        // Maak een vlucht aan
        Vlucht nieuweVlucht = new Vlucht(vluchtCode, bestemming, plaatsenEconomy, plaatsenBusiness, vliegtuig, vertrekpunt);
        vluchten.add(nieuweVlucht);

        System.out.println("Vlucht toegevoegd!");
    }

    public void toonBeschikbareVluchten() {
        System.out.println("===== Beschikbare Vluchten =====");
        if (vluchten.isEmpty()) {
            System.out.println("Er zijn momenteel geen vluchten beschikbaar.");
        } else {
            for (Vlucht vlucht : vluchten) {
                System.out.println("Vluchtcode:" + vlucht.getVluchtCode() + ", Van: " + vlucht.getVertrekPunt() + ", Naar: " + vlucht.getEindBestemming());
            }
        }
    }

    public void maakPersoneelAan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Maak Personeelslid Aan =====");
        System.out.print("Voer de naam van het personeelslid in: ");
        String name = scanner.nextLine();

        System.out.print("Voer de leeftijd van het personeelslid in: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Voer de rol van het personeelslid in (bijv. Piloot, Stewardess): ");
        String rol = scanner.nextLine();

        Personeel nieuwPersoneelslid = new Personeel(name, age, rol);
        Personeelsleden.add(nieuwPersoneelslid);

        System.out.println("Personeelslid toegevoegd!");
    }

    public void personeelToewijzenAanVlucht() {
        Scanner scanner = new Scanner(System.in);

        // Toon de beschikbare vluchten
        toonBeschikbareVluchten();

        System.out.print("Kies een vluchtcode om personeel toe te wijzen: ");
        int gekozenVluchtCode = scanner.nextInt();
        scanner.nextLine();  // Verwijder newline-karakter

        // Zoek de vlucht met de gekozen vluchtcode
        Vlucht gekozenVlucht = null;
        for (Vlucht vlucht : vluchten) {
            if (vlucht.getVluchtCode() == gekozenVluchtCode) {
                gekozenVlucht = vlucht;
                break;
            }
        }

        if (gekozenVlucht != null) {
            // Toon de beschikbare personeelsleden
            System.out.println("===== Beschikbare Personeelsleden =====");
            for (int i = 0; i < Personeelsleden.size(); i++) {
                Personeel persoon = Personeelsleden.get(i);
                System.out.println(i + 1 + ". " + persoon.getName() + " - " + persoon.getRol());
            }

            System.out.print("Kies een personeelslid om toe te voegen aan de vlucht: ");
            int gekozenPersoneelIndex = scanner.nextInt();
            scanner.nextLine();  // Verwijder newline-karakter

            if (gekozenPersoneelIndex > 0 && gekozenPersoneelIndex <= Personeelsleden.size()) {
                Personeel gekozenPersoneel = Personeelsleden.get(gekozenPersoneelIndex - 1);
                gekozenVlucht.voegPersoneelToe(gekozenPersoneel);
            } else {
                System.out.println("Ongeldige keuze.");
            }
        } else {
            System.out.println("Vlucht niet gevonden.");
        }
    }

    public void maakTicketAan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Maak Ticket Aan =====");

        // Toon beschikbare passagiers
        if (passagiers.isEmpty()) {
            System.out.println("Er zijn geen passagiers beschikbaar.");
            return;
        }

        System.out.println("Kies een passagier:");
        for (int i = 0; i < passagiers.size(); i++) {
            Personen passagier = passagiers.get(i);
            System.out.println((i + 1) + ". Naam: " + passagier.getName() + ", Leeftijd: " + passagier.getAge() + ", Adres: " + passagier.getAddress());
        }
        int passagierKeuze = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Valideer de keuze van passagier
        if (passagierKeuze < 1 || passagierKeuze > passagiers.size()) {
            System.out.println("Ongeldige keuze!");
            return;
        }

        Personen gekozenPassagier = passagiers.get(passagierKeuze - 1);

        // Toon beschikbare vluchten
        if (vluchten.isEmpty()) {
            System.out.println("Er zijn geen vluchten beschikbaar.");
            return;
        }

        System.out.println("Kies een vlucht:");
        for (int i = 0; i < vluchten.size(); i++) {
            Vlucht vlucht = vluchten.get(i);
            System.out.println((i + 1) + ". Vluchtcode: " + vlucht.getVluchtCode() + ", Van: " + vlucht.getVertrekPunt() + " naar: " + vlucht.getEindBestemming());
        }
        int vluchtKeuze = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Valideer de keuze van vlucht
        if (vluchtKeuze < 1 || vluchtKeuze > vluchten.size()) {
            System.out.println("Ongeldige keuze!");
            return;
        }

        Vlucht gekozenVlucht = vluchten.get(vluchtKeuze - 1);

        // Genereer een uniek ticketnummer (bijvoorbeeld op basis van de huidige grootte van de tickets lijst)
        int ticketNummer = tickets.size() + 1;

        // Maak het ticket aan en voeg het toe aan de ticketlijst
        Ticket nieuwTicket = new Ticket(gekozenPassagier, gekozenVlucht.getVliegtuig(), ticketNummer);
        tickets.add(nieuwTicket);

        System.out.println("Ticket aangemaakt! Ticketnummer: " + ticketNummer);

        // Vraag of de gebruiker het ticket wil afdrukken naar een bestand
        System.out.print("Wilt u het ticket afdrukken naar een bestand? (ja/nee): ");
        String keuze = scanner.nextLine();

        if (keuze.equalsIgnoreCase("ja")) {
            try {
                // Maak een nieuw bestand om het ticket op te slaan
                File bestand = new File("Ticket_" + ticketNummer + ".txt");
                PrintWriter writer = new PrintWriter(bestand);

                // Schrijf de ticketinformatie naar het bestand
                writer.println("===== Ticket Informatie =====");
                writer.println("Ticketnummer: " + ticketNummer);
                writer.println("Naam passagier: " + gekozenPassagier.getName());
                writer.println("Leeftijd: " + gekozenPassagier.getAge());
                writer.println("Adres: " + gekozenPassagier.getAddress());
                writer.println("Vluchtcode: " + gekozenVlucht.getVluchtCode());
                writer.println("Bestemming: " + gekozenVlucht.getEindBestemming());
                writer.println("Vertrekpunt: " + gekozenVlucht.getVertrekPunt());
                writer.println("Vliegtuig (Economy): " + gekozenVlucht.getVliegtuig().getPlaatsenEconomy() + " plaatsen");


                // Sluit de schrijver
                writer.close();

                System.out.println("Ticket is succesvol opgeslagen als " + bestand.getName());
            } catch (IOException e) {
                System.out.println("Er is een fout opgetreden bij het opslaan van het ticket.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Ticket niet afgedrukt.");
        }
    }
}
