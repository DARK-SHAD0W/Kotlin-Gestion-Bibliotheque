package modeles

// Classe abstraite de base pour tous les types de médias
abstract class Media(val titre: String, val dateDeParution: String) {
    abstract fun afficher()
}
