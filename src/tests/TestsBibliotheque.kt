package tests

import modeles.*

// Tests de validation des cas limites et de la gestion des erreurs
fun testerCasErreurs() {
    println("\n=== TESTS DE VALIDATION ===\n")

    val bibliotheque = Bibliotheque()
    val dvd = DVD("Inception", 8880, "Action", "2010-01-01")
    val livre = Livre("1984", "George Orwell", "Gallimard", "1972-01-01")
    val magazine = Magazine("National Geographic", "2024-10-28", "10")

    // Test 1 : emprunter un média déjà emprunté
    println("-- Test 1 : emprunter un DVD déjà emprunté --")
    bibliotheque.emprunter(dvd)
    bibliotheque.emprunter(dvd)

    // Test 2 : retourner un média qui n'est pas emprunté
    println("\n-- Test 2 : retourner un livre qui n'a pas été emprunté --")
    bibliotheque.retourner(livre)

    // Test 3 : emprunter un média non-Empruntable (Magazine)
    println("\n-- Test 3 : tenter d'emprunter un magazine --")
    bibliotheque.emprunter(magazine)

    // Test 4 : consulter un média non-Consultable (DVD)
    println("\n-- Test 4 : tenter de consulter un DVD sur place --")
    bibliotheque.consulter(dvd)

    // Test 5 : afficher les emprunts quand la liste est vide après retour
    println("\n-- Test 5 : afficher les emprunts après retour de tous les médias --")
    bibliotheque.retourner(dvd)
    bibliotheque.afficherEmprunts()

    println("\n=== FIN DES TESTS ===")
}
