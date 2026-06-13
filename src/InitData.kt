import modeles.*

// Initialise une bibliothèque riche avec des médias variés (FR/EN, anciens/récents, connus/inconnus)
fun initData(): Bibliotheque {
    val bibliotheque = Bibliotheque()

    // DVDs : mix films français, anglais, classiques et récents
    bibliotheque.ajouterMedia(DVD("Inception", 8880, "Sci-Fi", "2010-07-16"))
    bibliotheque.ajouterMedia(DVD("Le Fabuleux Destin d'Amélie Poulain", 7260, "Romance", "2001-04-25"))
    bibliotheque.ajouterMedia(DVD("Pulp Fiction", 9360, "Thriller", "1994-10-14"))
    bibliotheque.ajouterMedia(DVD("Intouchables", 6720, "Comédie dramatique", "2011-11-02"))
    bibliotheque.ajouterMedia(DVD("Parasite", 7860, "Thriller", "2019-05-30"))
    bibliotheque.ajouterMedia(DVD("2001 : L'Odyssée de l'espace", 8580, "Sci-Fi", "1968-04-02"))
    bibliotheque.ajouterMedia(DVD("Oppenheimer", 10800, "Biopic", "2023-07-21"))
    bibliotheque.ajouterMedia(DVD("La Haine", 5460, "Drame", "1995-05-31"))
    bibliotheque.ajouterMedia(DVD("Mad Max: Fury Road", 7080, "Action", "2015-05-15"))
    bibliotheque.ajouterMedia(DVD("Le Dîner de Cons", 5400, "Comédie", "1998-04-15"))

    // Livres : auteurs français et anglais, classiques et modernes
    bibliotheque.ajouterMedia(Livre("1984", "George Orwell", "Gallimard", "1972-01-01"))
    bibliotheque.ajouterMedia(Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", "1943-04-06"))
    bibliotheque.ajouterMedia(Livre("Dune", "Frank Herbert", "Robert Laffont", "1984-01-01"))
    bibliotheque.ajouterMedia(Livre("L'Étranger", "Albert Camus", "Gallimard", "1942-06-01"))
    bibliotheque.ajouterMedia(Livre("Harry Potter à l'école des sorciers", "J.K. Rowling", "Gallimard Jeunesse", "1998-10-09"))
    bibliotheque.ajouterMedia(Livre("Sapiens", "Yuval Noah Harari", "Albin Michel", "2015-10-22"))
    bibliotheque.ajouterMedia(Livre("Voyage au bout de la nuit", "Louis-Ferdinand Céline", "Gallimard", "1932-01-01"))
    bibliotheque.ajouterMedia(Livre("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "1925-04-10"))
    bibliotheque.ajouterMedia(Livre("Les Misérables", "Victor Hugo", "Le Livre de Poche", "1862-01-01"))
    bibliotheque.ajouterMedia(Livre("Atomic Habits", "James Clear", "Penguin Random House", "2018-10-16"))

    // Magazines : français et anglais, thèmes variés
    bibliotheque.ajouterMedia(Magazine("National Geographic", "2024-10-01", "353"))
    bibliotheque.ajouterMedia(Magazine("Le Point", "2024-09-15", "2719"))
    bibliotheque.ajouterMedia(Magazine("Time", "2024-10-07", "204"))
    bibliotheque.ajouterMedia(Magazine("Science & Vie", "2024-08-01", "1271"))
    bibliotheque.ajouterMedia(Magazine("Wired", "2024-09-01", "32"))
    bibliotheque.ajouterMedia(Magazine("Paris Match", "2024-10-10", "3885"))

    // Journaux : français et anglais, généralistes et spécialisés
    bibliotheque.ajouterMedia(Journal("Le Monde", "2024-10-28"))
    bibliotheque.ajouterMedia(Journal("The Guardian", "2024-10-28"))
    bibliotheque.ajouterMedia(Journal("L'Équipe", "2024-10-28"))
    bibliotheque.ajouterMedia(Journal("The New York Times", "2024-10-27"))
    bibliotheque.ajouterMedia(Journal("Le Figaro", "2024-10-28"))

    // Enregistrements Audio : classique, jazz, électronique, variété
    bibliotheque.ajouterMedia(EnregistrementAudio("Beethoven - Symphonie No.9", 960, "Classique", "1967-01-01"))
    bibliotheque.ajouterMedia(EnregistrementAudio("Daft Punk - Homework", 4440, "Électronique", "1997-01-20"))
    bibliotheque.ajouterMedia(EnregistrementAudio("Miles Davis - Kind of Blue", 2820, "Jazz", "1959-08-17"))
    bibliotheque.ajouterMedia(EnregistrementAudio("Édith Piaf - Non, je ne regrette rien", 195, "Variété française", "1960-11-10"))
    bibliotheque.ajouterMedia(EnregistrementAudio("Pink Floyd - The Dark Side of the Moon", 2532, "Rock", "1973-03-01"))
    bibliotheque.ajouterMedia(EnregistrementAudio("Stromae - Racine Carrée", 3120, "Électronique", "2013-08-16"))

    return bibliotheque
}
