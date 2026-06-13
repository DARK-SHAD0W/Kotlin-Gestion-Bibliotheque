import modeles.*

fun simulationComplete() {
    println("\n╔══════════════════════════════════════════╗")
    println("║    SIMULATION COMPLÈTE AUTOMATIQUE       ║")
    println("╚══════════════════════════════════════════╝\n")

    val bibliotheque = Bibliotheque()
    val dvd      = DVD("Inception", 8880, "Action", "2010-07-21")
    val livre    = Livre("1984", "George Orwell", "Gallimard", "1949-06-08")
    val audio    = EnregistrementAudio("Daft Punk - Random Access Memories", 3720, "Électronique", "2013-05-17")
    val magazine = Magazine("National Geographic", "2024-06-01", "353")
    val journal  = Journal("Le Monde", "2024-06-13")

    bibliotheque.ajouterMedia(dvd)
    bibliotheque.ajouterMedia(livre)
    bibliotheque.ajouterMedia(audio)
    bibliotheque.ajouterMedia(magazine)
    bibliotheque.ajouterMedia(journal)

    println("Bibliothèque initialisée avec ${bibliotheque.getMedias().size} médias.")
    afficherEtat(bibliotheque)

    etape("1", "Emprunter un DVD", dvd) { bibliotheque.emprunter(dvd) }
    afficherEtat(bibliotheque)

    etape("2", "Emprunter un Livre", livre) { bibliotheque.emprunter(livre) }
    afficherEtat(bibliotheque)

    etape("3", "Consulter un Magazine sur place", magazine) { bibliotheque.consulter(magazine) }
    afficherEtat(bibliotheque)

    etape("4", "Consulter un Journal sur place", journal) { bibliotheque.consulter(journal) }
    afficherEtat(bibliotheque)

    etape("5", "Emprunter un Enregistrement Audio", audio) { bibliotheque.emprunter(audio) }
    afficherEtat(bibliotheque)

    etape("6", "[ERREUR] Emprunter un Magazine (non-Empruntable)", magazine) { bibliotheque.emprunter(magazine) }
    afficherEtat(bibliotheque)

    etape("7", "[ERREUR] Emprunter le DVD déjà emprunté", dvd) { bibliotheque.emprunter(dvd) }
    afficherEtat(bibliotheque)

    etape("8", "[ERREUR] Consulter un DVD sur place (non-Consultable)", dvd) { bibliotheque.consulter(dvd) }
    afficherEtat(bibliotheque)

    etape("9", "Retourner le DVD", dvd) { bibliotheque.retourner(dvd) }
    afficherEtat(bibliotheque)

    etape("10", "Retourner le Livre", livre) { bibliotheque.retourner(livre) }
    afficherEtat(bibliotheque)

    etape("11", "Retourner l'Enregistrement Audio", audio) { bibliotheque.retourner(audio) }
    afficherEtat(bibliotheque)

    etape("12", "[ERREUR] Retourner un Livre jamais emprunté", livre) { bibliotheque.retourner(livre) }
    afficherEtat(bibliotheque)

    println("\n=== FIN DE LA SIMULATION ===")
    print("\nAppuyez sur Entrée pour revenir au menu...")
    readln()
}

private fun etape(numero: String, description: String, media: Media, action: () -> Unit) {
    println("\n▶ Étape $numero : $description")
    media.afficher()
    action()
}

private fun afficherEtat(bibliotheque: Bibliotheque) {
    val tous = bibliotheque.getMedias()
    val empruntes = bibliotheque.getEmprunts()
    println("\n  ┌── État (${empruntes.size}/${tous.size} emprunté(s)) ──────────────────────────────────┐")
    tous.forEach { media ->
        print(if (media in empruntes) "  [EMPRUNTÉ] " else "  [DISPO]    ")
        media.afficher()
    }
    println("  └────────────────────────────────────────────────────────────────────────┘")
}
