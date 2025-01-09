public class Ticket {
    private Personen Personen;
    private Vliegtuig Vliegtuig;
    private int ticketNummer;

    public Ticket (Personen personen, Vliegtuig Vliegtuig, int ticketNummer) {
        this.Personen = personen;
        this.Vliegtuig = Vliegtuig;
        this.ticketNummer = ticketNummer;
    }
    public Personen getPersonen() {
        return Personen;
    }
    public Vliegtuig getVliegtuig() {
        return Vliegtuig;

    }

    public int getTicketNummer() {
        return ticketNummer;
    }

    public void setTicketNummer(int ticketNummer) {
        this.ticketNummer = ticketNummer;
    }

    public void setPersonen(Personen personen) {
        Personen = personen;
    }

    public void setVliegtuig(Vliegtuig vliegtuig) {
        Vliegtuig = vliegtuig;
    }
}

