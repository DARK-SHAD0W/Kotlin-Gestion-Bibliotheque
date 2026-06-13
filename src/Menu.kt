import modeles.*

fun lancerMenu() {
    val bibliotheque = initData()

    println("╔══════════════════════════════════════════╗")
    println("║   Bienvenue à la Bibliothèque d'Ahmed !  ║")
    println("╚══════════════════════════════════════════╝")

    while (true) {
        println("\n  1. Lancer les tests de succès")
        println("  2. Lancer les tests d'erreurs")
        println("  3. Gérer la bibliothèque")
        println("  4. Simulation complète automatique")
        println("  0. Quitter")
        print("\nVotre choix : ")

        when (readln().trim()) {
            "1" -> testerSucces()
            "2" -> testerErreurs()
            "3" -> menuBibliotheque(bibliotheque)
            "4" -> simulationComplete()
            "0" -> { println("\nAu revoir !"); return }
            else -> println("Choix invalide, veuillez réessayer.")
        }
    }
}

private fun menuBibliotheque(bibliotheque: Bibliotheque) {
    while (true) {
        println("\n  === Gestion de la Bibliothèque ===")
        println("  1. Ajouter un média")
        println("  2. Consulter un média sur place")
        println("  3. Emprunter un média")
        println("  4. Retourner un média")
        println("  5. Afficher les médias")
        println("  0. Retour au menu principal")
        print("\nVotre choix : ")

        when (readln().trim()) {
            "1" -> menuAjouterMedia(bibliotheque)
            "2" -> menuConsulterMedia(bibliotheque)
            "3" -> menuEmprunterMedia(bibliotheque)
            "4" -> menuRetournerMedia(bibliotheque)
            "5" -> menuAfficherMedias(bibliotheque)
            "0" -> return
            else -> println("Choix invalide, veuillez réessayer.")
        }
    }
}

private fun menuAjouterMedia(bibliotheque: Bibliotheque) {
    println("\n  Type de média à ajouter :")
    println("  1. Livre")
    println("  2. Magazine")
    println("  3. Journal")
    println("  4. Enregistrement Audio")
    println("  5. DVD")
    println("  0. Annuler")
    print("\nVotre choix : ")

    val media = when (readln().trim()) {
        "1" -> saisirLivre()
        "2" -> saisirMagazine()
        "3" -> saisirJournal()
        "4" -> saisirEnregistrementAudio()
        "5" -> saisirDVD()
        "0" -> return
        else -> { println("Choix invalide."); return }
    }
    bibliotheque.ajouterMedia(media)
    println("  Média ajouté avec succès !")
}

private fun saisirLivre(): Livre {
    print("  Titre         : "); val titre = readln().trim()
    print("  Auteur        : "); val auteur = readln().trim()
    print("  Éditeur       : "); val editeur = readln().trim()
    print("  Date parution : "); val date = readln().trim()
    return Livre(titre, auteur, editeur, date)
}

private fun saisirMagazine(): Magazine {
    print("  Titre         : "); val titre = readln().trim()
    print("  Numéro        : "); val numero = readln().trim()
    print("  Date parution : "); val date = readln().trim()
    return Magazine(titre, date, numero)
}

private fun saisirJournal(): Journal {
    print("  Titre         : "); val titre = readln().trim()
    print("  Date parution : "); val date = readln().trim()
    return Journal(titre, date)
}

private fun saisirEnregistrementAudio(): EnregistrementAudio {
    print("  Titre         : "); val titre = readln().trim()
    print("  Durée (sec)   : "); val duree = readln().trim().toIntOrNull() ?: 0
    print("  Genre         : "); val genre = readln().trim()
    print("  Date parution : "); val date = readln().trim()
    return EnregistrementAudio(titre, duree, genre, date)
}

private fun saisirDVD(): DVD {
    print("  Titre         : "); val titre = readln().trim()
    print("  Durée (sec)   : "); val duree = readln().trim().toIntOrNull() ?: 0
    print("  Genre         : "); val genre = readln().trim()
    print("  Date parution : "); val date = readln().trim()
    return DVD(titre, duree, genre, date)
}

private fun menuConsulterMedia(bibliotheque: Bibliotheque) {
    while (true) {
        println("\n  Type de média à consulter :")
        println("  1. Livre")
        println("  2. Magazine")
        println("  3. Journal")
        println("  0. Annuler")
        print("\nVotre choix : ")

        when (readln().trim()) {
            "1" -> {
                val liste = bibliotheque.getMedias().filterIsInstance<Livre>()
                val choix = listerEtChoisir(liste, "livre")
                if (choix != null) bibliotheque.consulter(choix)
            }
            "2" -> {
                val liste = bibliotheque.getMedias().filterIsInstance<Magazine>()
                val choix = listerEtChoisir(liste, "magazine")
                if (choix != null) bibliotheque.consulter(choix)
            }
            "3" -> {
                val liste = bibliotheque.getMedias().filterIsInstance<Journal>()
                val choix = listerEtChoisir(liste, "journal")
                if (choix != null) bibliotheque.consulter(choix)
            }
            "0" -> return
            else -> println("Choix invalide, veuillez réessayer.")
        }
    }
}

private fun menuEmprunterMedia(bibliotheque: Bibliotheque) {
    while (true) {
        println("\n  Type de média à emprunter :")
        println("  1. Livre")
        println("  2. Enregistrement Audio")
        println("  3. DVD")
        println("  0. Annuler")
        print("\nVotre choix : ")

        when (readln().trim()) {
            "1" -> {
                val liste = bibliotheque.getMedias().filterIsInstance<Livre>()
                val choix = listerEtChoisir(liste, "livre")
                if (choix != null) bibliotheque.emprunter(choix)
            }
            "2" -> {
                val liste = bibliotheque.getMedias().filterIsInstance<EnregistrementAudio>()
                val choix = listerEtChoisir(liste, "enregistrement audio")
                if (choix != null) bibliotheque.emprunter(choix)
            }
            "3" -> {
                val liste = bibliotheque.getMedias().filterIsInstance<DVD>()
                val choix = listerEtChoisir(liste, "DVD")
                if (choix != null) bibliotheque.emprunter(choix)
            }
            "0" -> return
            else -> println("Choix invalide, veuillez réessayer.")
        }
    }
}

private fun menuRetournerMedia(bibliotheque: Bibliotheque) {
    while (true) {
        println("\n  Type de média à retourner :")
        println("  1. Livre")
        println("  2. Enregistrement Audio")
        println("  3. DVD")
        println("  0. Annuler")
        print("\nVotre choix : ")

        when (readln().trim()) {
            "1" -> {
                val liste = bibliotheque.getEmprunts().filterIsInstance<Livre>()
                val choix = listerEtChoisir(liste, "livre emprunté")
                if (choix != null) bibliotheque.retourner(choix)
            }
            "2" -> {
                val liste = bibliotheque.getEmprunts().filterIsInstance<EnregistrementAudio>()
                val choix = listerEtChoisir(liste, "enregistrement audio emprunté")
                if (choix != null) bibliotheque.retourner(choix)
            }
            "3" -> {
                val liste = bibliotheque.getEmprunts().filterIsInstance<DVD>()
                val choix = listerEtChoisir(liste, "DVD emprunté")
                if (choix != null) bibliotheque.retourner(choix)
            }
            "0" -> return
            else -> println("Choix invalide, veuillez réessayer.")
        }
    }
}

private fun menuAfficherMedias(bibliotheque: Bibliotheque) {
    while (true) {
        println("\n  Afficher :")
        println("  1. Tous les médias")
        println("  2. Emprunts en cours")
        println("  3. Filtrer par type")
        println("  0. Retour")
        print("\nVotre choix : ")

        when (readln().trim()) {
            "1" -> {
                val tous = bibliotheque.getMedias()
                if (tous.isEmpty()) println("  Aucun média dans la bibliothèque.")
                else tous.forEach { it.afficher() }
            }
            "2" -> bibliotheque.afficherEmprunts()
            "3" -> menuFiltrerParType(bibliotheque)
            "0" -> return
            else -> println("Choix invalide, veuillez réessayer.")
        }
    }
}

private fun menuFiltrerParType(bibliotheque: Bibliotheque) {
    println("\n  Type de média :")
    println("  1. Livres")
    println("  2. Magazines")
    println("  3. Journaux")
    println("  4. DVDs")
    println("  5. Enregistrements Audio")
    println("  0. Retour")
    print("\nVotre choix : ")

    val medias = bibliotheque.getMedias()
    val filtre: List<Media> = when (readln().trim()) {
        "1" -> medias.filterIsInstance<Livre>()
        "2" -> medias.filterIsInstance<Magazine>()
        "3" -> medias.filterIsInstance<Journal>()
        "4" -> medias.filterIsInstance<DVD>()
        "5" -> medias.filterIsInstance<EnregistrementAudio>()
        "0" -> return
        else -> { println("Choix invalide."); return }
    }
    if (filtre.isEmpty()) println("  Aucun média de ce type.")
    else filtre.forEach { it.afficher() }
}

private fun <T : Media> listerEtChoisir(liste: List<T>, label: String): T? {
    if (liste.isEmpty()) { println("  Aucun $label disponible."); return null }
    liste.forEachIndexed { i, m -> println("  ${i + 1}. ${m.titre}") }
    println("  0. Retour")
    print("\nVotre choix : ")
    val choix = readln().trim().toIntOrNull() ?: return null
    return if (choix in 1..liste.size) liste[choix - 1] else null
}
