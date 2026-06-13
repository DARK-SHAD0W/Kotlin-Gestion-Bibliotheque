package modeles

import interfaces.Consultable

// Sous-classe magazine : consultable sur place uniquement
class Magazine(
    titre: String,
    dateDeParution: String,
    val numero: String
) : Media(titre, dateDeParution), Consultable {

    override fun consulter() {
        println("Le magazine '$titre', numéro '$numero' ($dateDeParution) est consulté sur place.")
    }

    override fun afficher() {
        println("- Magazine: Titre = '$titre', Numéro = '$numero', Date = '$dateDeParution'")
    }
}
