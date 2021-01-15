import java.util.Scanner;

 

/**
 * Beispielcode für den Fahrkartenautomaten
 *
 * @author Hafezi
 */
class Fahrkartenautomat {

 

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        float zuZahlenderBetrag = 0;
        float eingezahlterGesamtbetrag;
        float eingeworfeneMuenze;
        float rueckgabebetrag;
        float eingegebenerBetrag;
        float anzahlTickets;
        
        // zuZahlenderbetrag, eingezahlterGesamtbetrag, eingeworfeneMuenze, rueckgabebetrag, eingegebenerBetrag und anzahlTickets sind die Variablen (d auch) mit Dateityp: float

 


                

 

        System.out.print("fälliger Betrag: ");
        zuZahlenderBetrag = tastatur.nextFloat(); // Wert für "zuZahlenderBetrag" wird festgelegt durch die Eingabe
        System.out.print("Ticketanzahl: ");
        anzahlTickets = tastatur.nextFloat(); // Wert für "anzahlTickets" wird festgelegt durch die Eingabe

 

   
        eingezahlterGesamtbetrag = (float) 0.00; // Wert wird auf Null gesetzt
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag*anzahlTickets) { // eine Schleife in der festgelegt ist, so lange der "eingezahlterGesamtbetrag" kleiner als das Produkt von "zuZahlenderBetrag" und "anzahlTickets" beginnt die Schleife immer wieder von neu
            float d = zuZahlenderBetrag*anzahlTickets - eingezahlterGesamtbetrag; // d ist auch eine Variable mit Dateityp float // von "zuZahlenderBetrag*anzahlTickets" wir der mit der Tastatur eingetippte Betrag "eingezahlterGesamtbetrag" abgezogen und das Restgeld(wenn vorhanden = eingezahlter Betrag > gesamtBetrag) wird ausgegeben und das Ticket wird gedruckt, weil die Bedingung erfüllt ist
            System.out.printf( "%.2f\n" ,     d);
            System.out.print("Eingabe (mind. 5Ct, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextFloat(); // Wert für das eingeworfene Geld kann festgelegt werden
            eingezahlterGesamtbetrag += eingeworfeneMuenze; // Der Gesamtbetrag mit 0,0 der am Anfang festgelegt wurde, wird jetzt mit dem Geld/Wert addiert, welcher eingetragen wurde
        }
       
        
        System.out.println("\nFahrschein");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

 

        
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag*anzahlTickets;
        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag beträgt: " + rueckgabebetrag + " EURO"); // hier wird der Rückgabebetrag angezeigt, welcher davor ausgerechnet wurde
            System.out.println("wird ausgezahlt:");

 

            while (rueckgabebetrag >= 2.00) 
            {
                System.out.println("2 Euro");
                rueckgabebetrag -= 2.00;
            }
            while (rueckgabebetrag >= 1.00) 
            {
                System.out.println("1 Euro");
                rueckgabebetrag -= 1.00;
            }
            while (rueckgabebetrag >= 0.50) 
            {
                System.out.println("50 Cent");
                rueckgabebetrag -= 0.50;
            }
            while (rueckgabebetrag >= 0.20) 
            {
                System.out.println("20 Cent");
                rueckgabebetrag -= 0.20;
            }
            while (rueckgabebetrag >= 0.10) 
            {
                System.out.println("10 Cent");
                rueckgabebetrag -= 0.10;
            }
            while (rueckgabebetrag >= 0.05)
            {
                System.out.println("5 Cent");
                rueckgabebetrag -= 0.05;
            }
        }

 

        System.out.println("\nVergessen Sie nicht, den/die Fahrschein/e\n" +
                "vor Fahrtantritt entwerten zu lassen!\n" +
                "Wir wünschen Ihnen eine gute Fahrt.");
    }
}
