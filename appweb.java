import java.util.Scanner;

public class appweb {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cin;
        String nom;
        String prenom;
        String numeroCompte;
        double solde;

        final double PLAFOND_RETRAIT = 500.00;

        // Saisie des informations du client
        System.out.println("===== CREATION DU COMPTE BANCAIRE =====");

        System.out.print("Veuillez saisir le CIN : ");
        cin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Veuillez saisir le nom : ");
        nom = scanner.nextLine();

        System.out.print("Veuillez saisir le prenom : ");
        prenom = scanner.nextLine();

        System.out.print("Entrez le numero du compte : ");
        numeroCompte = scanner.nextLine();

        System.out.print("Entrez le solde initial (TND) : ");
        solde = scanner.nextDouble();

        // Menu principal
        int choix = -1;

        while (choix != 0) {

            System.out.println("\n========== MENU BANQUE ==========");
            System.out.println("1. Afficher les informations du client");
            System.out.println("2. Consulter le solde");
            System.out.println("3. Effectuer un depot");
            System.out.println("4. Effectuer un retrait");
            System.out.println("0. Quitter");

            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {

                case 1:
                    System.out.println("\n--- INFORMATIONS DU CLIENT ---");
                    System.out.println("Nom : " + nom);
                    System.out.println("Prenom : " + prenom);
                    System.out.println("CIN : " + cin);
                    System.out.println("Numero du compte : " + numeroCompte);
                    System.out.println("Solde actuel : " + solde + " TND");
                    System.out.println("Plafond maximal de retrait : "
                            + PLAFOND_RETRAIT + " TND");
                    break;

                case 2:
                    System.out.println("\n--- CONSULTATION DU SOLDE ---");
                    System.out.println("Votre solde est : " + solde + " TND");
                    break;

                case 3:
                    System.out.print("\nMontant du depot (TND) : ");
                    double depot = scanner.nextDouble();

                    if (depot > 0) {
                        solde = solde + depot;
                        System.out.println("Depot effectue avec succes.");
                        System.out.println("Nouveau solde : " + solde + " TND");
                    } else {
                        System.out.println("Montant invalide.");
                    }
                    break;

                case 4:
                    System.out.print("\nMontant du retrait (TND) : ");
                    double retrait = scanner.nextDouble();

                    if (retrait <= 0) {
                        System.out.println("Montant invalide.");
                    } else if (retrait > PLAFOND_RETRAIT) {
                        System.out.println("Retrait refuse : plafond maximal de "
                                + PLAFOND_RETRAIT + " TND.");
                    } else if (retrait > solde) {
                        System.out.println("Retrait refuse : solde insuffisant.");
                    } else {
                        solde = solde - retrait;
                        System.out.println("Retrait effectue avec succes.");
                        System.out.println("Nouveau solde : " + solde + " TND");
                    }
                    break;

                case 0:
                    System.out.println("Merci d'avoir utilise notre banque. Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez reessayer.");
                    break;
            }
        }

        scanner.close();
    }
}