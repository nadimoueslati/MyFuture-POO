
public class CompteBancaire {

    private String numeroCompte;
    private double solde;
    private Client titulaire;

    private static int nombreComptes = 0;

    public CompteBancaire(String numeroCompte,
                          double soldeInitial,
                          Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.titulaire = titulaire;
        nombreComptes++;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public static int getNombreComptes() {
        return nombreComptes;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Depot effectue : " + montant + " TND");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Montant invalide.");
        } else if (montant > solde) {
            System.out.println("Solde insuffisant.");
        } else {
            solde -= montant;
            System.out.println("Retrait effectue : " + montant + " TND");
        }
    }

    public void virement(CompteBancaire destination, double montant) {
        if (destination == null || destination == this) {
            System.out.println("Compte destination invalide.");
        } else if (montant <= 0) {
            System.out.println("Montant invalide.");
        } else if (montant > solde) {
            System.out.println("Solde insuffisant pour le virement.");
        } else {
            solde -= montant;
            destination.solde += montant;
            System.out.println("Virement effectue : " + montant + " TND");
        }
    }

    public void afficherDetails() {
        System.out.println("Numero du compte : " + numeroCompte);
        System.out.print("Titulaire : ");
        titulaire.afficherClient();
        System.out.println("Solde : " + solde + " TND");
        System.out.println("-------------------------");
    }
}
