package modeles

import interfaces.Empruntable

// Sous-classe enregistrement audio : empruntable uniquement
class EnregistrementAudio(
    titre: String,
    val duree: Int,
    val genre: String,
    dateDeParution: String
) : Media(titre, dateDeParution), Empruntable {

    private var estEmprunte = false

    override fun emprunter(): Boolean {
        if (estEmprunte) {
            println("L'enregistrement audio '$titre' est déjà emprunté.")
            return false
        }
        estEmprunte = true
        println("L'enregistrement audio '$titre' a été emprunté.")
        return true
    }

    override fun retourner(): Boolean {
        if (!estEmprunte) {
            println("L'enregistrement audio '$titre' n'est pas en cours d'emprunt.")
            return false
        }
        estEmprunte = false
        println("L'enregistrement audio '$titre' a été retourné.")
        return true
    }

    override fun afficher() {
        println("- Enregistrement Audio: Titre = '$titre', Durée = '$duree' minutes, Genre = '$genre'")
    }
}
