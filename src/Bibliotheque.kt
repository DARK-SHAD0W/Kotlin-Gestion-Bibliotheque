import interfaces.Consultable
import interfaces.Empruntable
import modeles.Media

// Classe qui gère la collection de médias et les emprunts en cours
class Bibliotheque {
    private val medias = mutableListOf<Media>()
    private val emprunts = mutableListOf<Media>()

    // Ajoute un média à la bibliothèque
    fun ajouterMedia(media: Media) {
        medias.add(media)
    }

    // Tente d'emprunter un média : vérifie le type et l'état avant d'agir
    fun emprunter(media: Media) {
        if (media !is Empruntable) {
            println("'${media.titre}' ne peut pas être emprunté.")
            return
        }
        if (media in emprunts) {
            println("'${media.titre}' est déjà en cours d'emprunt.")
            return
        }
        if ((media as Empruntable).emprunter()) {
            emprunts.add(media)
        }
    }

    // Tente de retourner un média : vérifie qu'il est bien emprunté
    fun retourner(media: Media) {
        if (media !in emprunts) {
            println("'${media.titre}' n'est pas en cours d'emprunt.")
            return
        }
        if ((media as Empruntable).retourner()) {
            emprunts.remove(media)
        }
    }

    // Consulte un média sur place : vérifie que le type le permet
    fun consulter(media: Media) {
        if (media !is Consultable) {
            println("'${media.titre}' ne peut pas être consulté sur place.")
            return
        }
        (media as Consultable).consulter()
    }

    // Affiche tous les médias actuellement empruntés
    fun afficherEmprunts() {
        println("\nEmprunts en cours:")
        if (emprunts.isEmpty()) {
            println("  Aucun emprunt en cours.")
            return
        }
        emprunts.forEach { it.afficher() }
    }
}
