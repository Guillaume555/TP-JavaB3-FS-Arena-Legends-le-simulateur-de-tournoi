README - Arena Legends

Pour tester :
- Main.java : menu de la partie 1
- StatsArene.java : partie 2
- Combattant.java : parties 3 et 4
- Tournoi.java : partie 5 (tournoi complet + 100 tournois)

Partie 1 - Pourquoi un do...while pour le menu ?
Le do...while execute le code au moins une fois avant de verifier la condition. Pour un menu c'est pratique parce qu'on doit l'afficher au moins une fois avant de savoir ce que l'utilisateur choisit. Avec un while normal il faudrait donner une valeur bidon a choix juste pour rentrer dans la boucle.

Partie 2 - Difference entre int[] b = a; et copier case par case
int[] b = a; ne copie pas le tableau, ca copie juste la reference. a et b pointent sur le meme tableau donc si on modifie b, a change aussi.
Exemple :
int[] a = {1, 2, 3};
int[] b = a;
b[0] = 99;   -> a[0] vaut aussi 99
Si on copie case par case dans un new int[a.length], on a un vrai nouveau tableau et modifier la copie ne change pas a.

Partie 3 - Pourquoi un setPv casserait l'encapsulation ?
Meme avec une verif des bornes, setPv permettrait de changer les pv sans passer par les regles du jeu. Par exemple on pourrait remettre des pv a un combattant KO alors qu'il ne doit plus pouvoir etre soigne, ou lui enlever des pv sans tenir compte de sa defense. C'est pour ca que les pv changent seulement avec subirDegats et soigner.

Partie 4 - Pourquoi subirDegatsBruts est en protected ?
En private le Mage ne pourrait pas l'utiliser. En public n'importe qui pourrait faire des degats en ignorant la defense. Protected permet aux sous-classes de l'utiliser sans l'ouvrir a tout le monde.

Partie 4 - Combattant c = new Mage(...); c.attaquer(x);
C'est le attaquer du Mage qui est appele. Le type declare c'est Combattant, c'est ce que le compilateur verifie. Le type reel c'est Mage, c'est l'objet cree avec new. A l'execution Java utilise le type reel pour choisir la methode, c'est le polymorphisme.

Partie 5 - Quelle classe gagne le plus ?
Sur 100 tournois : Guerrier 100, Mage 0, Voleur 0.
C'est pas du tout equilibre, le Guerrier gagne a chaque fois.
Le Mage est fort au debut avec ses sorts mais apres 3 sorts il n'a plus de mana. Il tape attaque / 2 et en enlevant la defense ca fait presque rien (contre Torvald qui a 8 de def il ne fait plus que 1 degat). Et il recupere que 15 de mana donc il lui faut 2 tours pour refaire un sort.
Le Voleur a peu de pv et sa defense est faible, l'esquive et la double frappe ne suffisent pas. En plus il n'esquive pas les sorts du Mage.
Le Guerrier lui tape toujours pareil et en plus sa rage double les degats tous les 5 coups.
Ca depend aussi des stats que j'ai donnees aux combattants : mes guerriers ont plus de pv et de def. Pour equilibrer on pourrait donner plus de mana au Mage ou en recuperer plus, ou donner plus de pv au Voleur.

Pas encore fait : les pieges des parties 2 a 5 (distance, historiqueDegats, Paladin, getParticipants).