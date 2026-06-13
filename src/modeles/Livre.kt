package modeles

import interfaces.Consultable
import interfaces.Empruntable

// Sous-classe livre : empruntable et consultable sur place
class Livre(
    titre: String,
    val auteur: String,
    val editeur: String,
    dateDeParution: String
) : Media(titre, dateDeParution), Empruntable, Consultable {

    private var estEmprunte = false

    override fun emprunter(): Boolean {
        if (estEmprunte) {
            println("Le livre '$titre' est déjà emprunté.")
            return false
        }
        estEmprunte = true
        println("Le livre '$titre' de '$auteur' a été emprunté.")
        return true
    }

    override fun retourner(): Boolean {
        if (!estEmprunte) {
            println("Le livre '$titre' n'est pas en cours d'emprunt.")
            return false
        }
        estEmprunte = false
        println("Le livre '$titre' de '$auteur' a été retourné.")
        return true
    }

    override fun consulter() {
        println("Le livre '$titre' est consulté sur place.")
    }

    // Affichage formaté pour la liste des emprunts
    override fun afficher() {
        println("- Livre: Titre = '$titre', Auteur = '$auteur', Éditeur = '$editeur', Date de parution = '$dateDeParution'")
    }
}
