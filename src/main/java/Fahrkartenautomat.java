import java.util.Scanner;

/**
 * Beispielcode für den Fahrkartenautomaten
 *
 * @author Hafezi
 */
class Fahrkartenautomat {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        // Achtung!!!!
        // Hier wird deutlich, warum double nicht für Geldbeträge geeignet ist.
        // =======================================
        float zuZahlenderBetrag;
        float eingezahlterGesamtbetrag;
        float eingeworfeneMuenze;
        float rueckgabebetrag;
        // Die Eingabe erfolgt anwenderfreudlich mit Dezimalpunkt: just testing
        float eingegebenerBetrag;
        float anzahlTickets;



        // Den zu zahlenden Betrag ermittelt normalerweise der Automat
        // aufgrund der gewählten Fahrkarte(n).
        // -----------------------------------
        System.out.print("Zu zahlender Betrag (Euro): ");
        zuZahlenderBetrag = tastatur.nextFloat();
        System.out.print("Anzahl der Tickets : ");
        anzahlTickets = tastatur.nextFloat();

        // Geldeinwurf
        // -----------
        eingezahlterGesamtbetrag = (float) 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag*anzahlTickets) {
            float d = zuZahlenderBetrag*anzahlTickets - eingezahlterGesamtbetrag;
            System.out.printf( "%.2f\n" ,     d);
            System.out.print("Eingabe (mind. 5Ct, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextFloat();
            eingezahlterGesamtbetrag += eingeworfeneMuenze;
        }

        // Fahrscheinausgabe
        // -----------------
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // Rückgeldberechnung und -Ausgabe
        // -------------------------------
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag*anzahlTickets;
        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " EURO");
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) // 2 EURO-Münzen
            {
                System.out.println("2 Euro");
                rueckgabebetrag -= 2.0;
            }
            while (rueckgabebetrag >= 1.0) // 1 EURO-Münzen
            {
                System.out.println("1 Euro");
                rueckgabebetrag -= 1.0;
            }
            while (rueckgabebetrag >= 0.5) // 50 CENT-Münzen
            {
                System.out.println("50 Cent");
                rueckgabebetrag -= 0.5;
            }
            while (rueckgabebetrag >= 0.2) // 20 CENT-Münzen
            {
                System.out.println("20 Cent");
                rueckgabebetrag -= 0.2;
            }
            while (rueckgabebetrag >= 0.1) // 10 CENT-Münzen
            {
                System.out.println("10 Cent");
                rueckgabebetrag -= 0.1;
            }
            while (rueckgabebetrag >= 0.05)// 5 CENT-Münzen
            {
                System.out.println("5 Cent");
                rueckgabebetrag -= 0.05;
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" +
                "vor Fahrtantritt entwerten zu lassen!\n" +
                "Wir wünschen Ihnen eine gute Fahrt.");
    }
}