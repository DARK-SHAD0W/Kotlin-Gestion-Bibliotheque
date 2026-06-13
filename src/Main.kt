import modeles.*
import tests.testerSucces
import tests.testerErreurs

// Point d'entrée : init → simulation PDF → tests de succès → tests d'erreurs
fun main() {

    // 1. Simulation exacte du résultat attendu (PDF)
    println("=== SIMULATION (PDF) ===\n")

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

    // 2. Initialisation de la bibliothèque complète avec données variées
    println("\n=== BIBLIOTHÈQUE COMPLÈTE (initData) ===")
    val bibliothequeComplete = initData()

    val avatar = DVD("Avatar: La Voie de l'eau", 11460, "Sci-Fi", "2022-12-14")
    val proust = Livre("À la recherche du temps perdu", "Marcel Proust", "Gallimard", "1913-11-14")
    val lePoint = Magazine("Le Point", "2024-09-15", "2719")
    val nyt = Journal("The New York Times", "2024-10-27")

    bibliothequeComplete.ajouterMedia(avatar)
    bibliothequeComplete.ajouterMedia(proust)
    bibliothequeComplete.ajouterMedia(lePoint)
    bibliothequeComplete.ajouterMedia(nyt)

    bibliothequeComplete.emprunter(avatar)
    bibliothequeComplete.emprunter(proust)
    bibliothequeComplete.consulter(lePoint)
    bibliothequeComplete.consulter(nyt)
    bibliothequeComplete.afficherEmprunts()

    // 3. Tests de succès : toutes les fonctionnalités nominales
    testerSucces()

    // 4. Tests d'erreurs : tous les cas limites et comportements invalides
    testerErreurs()
}
