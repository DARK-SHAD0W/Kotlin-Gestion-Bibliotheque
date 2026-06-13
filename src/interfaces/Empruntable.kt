package interfaces

// Interface pour les médias pouvant être empruntés
interface Empruntable {
    fun emprunter(): Boolean  // retourne true si l'emprunt réussit
    fun retourner(): Boolean  // retourne true si le retour réussit
}
