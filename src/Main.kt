import modeles.*
import tests.testerCasErreurs

// Point d'entrée : simulation des opérations de la bibliothèque
fun main() {

    // --- Simulation du résultat attendu (PDF) ---
    val bibliotheque = Bibliotheque()

    val magazine = Magazine("National Geographic", "2024-10-28", "10")
    val journal = Journal("Le Monde", "28/10/2024")
    val enregistrementAudio = EnregistrementAudio("Beethoven - Symphonie No.9", 960, "Classical", "1967-01-01")
    val dvd = DVD("Inception", 8880, "Action", "2010-01-01")
    val livre = Livre("1984", "George Orwell", "Gallimard", "1972-01-01")

    bibliotheque.emprunter(dvd)
    bibliotheque.emprunter(livre)
    bibliotheque.consulter(magazine)
    bibliotheque.consulter(journal)
    bibliotheque.emprunter(enregistrementAudio)

    bibliotheque.afficherEmprunts()

    bibliotheque.retourner(dvd)
    bibliotheque.retourner(livre)
    bibliotheque.afficherEmprunts()

    // --- Démonstration avec la bibliothèque complète (initData) ---
    println("\n=== BIBLIOTHÈQUE COMPLÈTE ===")
    val bibliothequeComplete = initData()

    val avatar = DVD("Avatar: La Voie de l'eau", 11460, "Sci-Fi", "2022-12-14")
    val proustLivre = Livre("À la recherche du temps perdu", "Marcel Proust", "Gallimard", "1913-11-14")
    val wired = Magazine("Wired", "2024-09-01", "32")
    val figaro = Journal("Le Figaro", "2024-10-28")

    bibliothequeComplete.ajouterMedia(avatar)
    bibliothequeComplete.ajouterMedia(proustLivre)
    bibliothequeComplete.ajouterMedia(wired)
    bibliothequeComplete.ajouterMedia(figaro)

    bibliothequeComplete.emprunter(avatar)
    bibliothequeComplete.emprunter(proustLivre)
    bibliothequeComplete.consulter(wired)
    bibliothequeComplete.consulter(figaro)
    bibliothequeComplete.afficherEmprunts()

    // --- Tests de validation des cas limites ---
    testerCasErreurs()
}
