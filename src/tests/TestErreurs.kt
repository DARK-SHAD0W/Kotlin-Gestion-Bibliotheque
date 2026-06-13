import modeles.*

// Tests couvrant tous les cas d'erreur et limites de la bibliothèque
fun testerErreurs() {
    println("\n=== TESTS D'ERREURS ===\n")

    val bibliotheque = Bibliotheque()

    val dvd = DVD("Inception", 8880, "Action", "2010-01-01")
    val livre = Livre("1984", "George Orwell", "Gallimard", "1972-01-01")
    val magazine = Magazine("National Geographic", "2024-10-28", "10")
    val audio = EnregistrementAudio("Daft Punk - Homework", 4440, "Électronique", "1997-01-20")

    bibliotheque.ajouterMedia(dvd)
    bibliotheque.ajouterMedia(livre)
    bibliotheque.ajouterMedia(magazine)
    bibliotheque.ajouterMedia(audio)

    // Test 1 : emprunter un DVD déjà emprunté
    println("-- Test 1 : emprunter un DVD déjà emprunté --")
    bibliotheque.emprunter(dvd)
    bibliotheque.emprunter(dvd)

    // Test 2 : retourner un livre jamais emprunté
    println("\n-- Test 2 : retourner un livre jamais emprunté --")
    bibliotheque.retourner(livre)

    // Test 3 : emprunter un Magazine (non-Empruntable)
    println("\n-- Test 3 : tenter d'emprunter un magazine --")
    bibliotheque.emprunter(magazine)

    // Test 4 : consulter un DVD sur place (non-Consultable)
    println("\n-- Test 4 : tenter de consulter un DVD sur place --")
    bibliotheque.consulter(dvd)

    // Test 5 : consulter un EnregistrementAudio sur place (non-Consultable)
    println("\n-- Test 5 : tenter de consulter un enregistrement audio sur place --")
    bibliotheque.consulter(audio)

    // Test 6 : retourner le même média deux fois
    println("\n-- Test 6 : retourner le DVD deux fois de suite --")
    bibliotheque.retourner(dvd)
    bibliotheque.retourner(dvd)

    println("\n=== FIN DES TESTS D'ERREURS ===")
}
