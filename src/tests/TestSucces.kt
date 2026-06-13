import modeles.*

// Tests couvrant tous les cas de succès des opérations de la bibliothèque
fun testerSucces() {
    println("\n=== TESTS DE SUCCÈS ===\n")

    val bibliotheque = Bibliotheque()

    val livre = Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", "1943-04-06")
    val dvd = DVD("Pulp Fiction", 9360, "Thriller", "1994-10-14")
    val audio = EnregistrementAudio("Miles Davis - Kind of Blue", 2820, "Jazz", "1959-08-17")
    val magazine = Magazine("Science & Vie", "2024-08-01", "1271")
    val journal = Journal("The Guardian", "2024-10-28")

    bibliotheque.ajouterMedia(livre)
    bibliotheque.ajouterMedia(dvd)
    bibliotheque.ajouterMedia(audio)
    bibliotheque.ajouterMedia(magazine)
    bibliotheque.ajouterMedia(journal)

    // Test 1 : emprunter un livre avec succès
    println("-- Test 1 : emprunter un livre --")
    livre.afficher()
    bibliotheque.emprunter(livre)

    // Test 2 : emprunter un DVD avec succès
    println("\n-- Test 2 : emprunter un DVD --")
    dvd.afficher()
    bibliotheque.emprunter(dvd)

    // Test 3 : emprunter un enregistrement audio avec succès
    println("\n-- Test 3 : emprunter un enregistrement audio --")
    audio.afficher()
    bibliotheque.emprunter(audio)

    // Test 4 : afficher les emprunts en cours (3 médias)
    println("\n-- Test 4 : afficher les emprunts en cours --")
    bibliotheque.afficherEmprunts()

    // Test 5 : consulter un magazine sur place
    println("\n-- Test 5 : consulter un magazine sur place --")
    magazine.afficher()
    bibliotheque.consulter(magazine)

    // Test 6 : consulter un journal sur place
    println("\n-- Test 6 : consulter un journal sur place --")
    journal.afficher()
    bibliotheque.consulter(journal)

    // Test 7 : consulter un livre (Empruntable ET Consultable)
    println("\n-- Test 7 : consulter un livre sur place --")
    livre.afficher()
    bibliotheque.consulter(livre)

    // Test 8 : retourner un livre avec succès
    println("\n-- Test 8 : retourner un livre --")
    livre.afficher()
    bibliotheque.retourner(livre)

    // Test 9 : retourner un DVD avec succès
    println("\n-- Test 9 : retourner un DVD --")
    dvd.afficher()
    bibliotheque.retourner(dvd)

    // Test 10 : afficher les emprunts après retours partiels (1 restant)
    println("\n-- Test 10 : afficher les emprunts après retours partiels --")
    bibliotheque.afficherEmprunts()

    // Test 11 : retourner le dernier média emprunté
    println("\n-- Test 11 : retourner le dernier média emprunté --")
    audio.afficher()
    bibliotheque.retourner(audio)

    // Test 12 : afficher les emprunts quand la liste est vide
    println("\n-- Test 12 : afficher les emprunts quand vide --")
    bibliotheque.afficherEmprunts()

    println("\n=== FIN DES TESTS DE SUCCÈS ===")
}
