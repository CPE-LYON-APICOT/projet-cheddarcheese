# Pitch du projet

- Un jeu similaire à Overcooked.
- Le but sera de répondre à des commandes de repas (composées de 2 à 4 ingrédients) dans un restaurant.
- Pour répondre à ces commandes, le joueur doit se déplacer dans la cuisine et cuisiner le repas demandé en déplacant des ingredients, en les coupants, les cuire mais aussi nettoyer les assietes et faire la plonge.
- Chaque "action" de cuisine est simple, soit elle requiert de déplacer un objet soit de déposer un objet et d'attendre (plonge four etc).
- Chaque joueur peut se déplacer, tenir 1 et 1 seul objet à la fois sur lui et intéragir avec les objets de cuisine (plonge four planche à découper etc).
- Il y aura une touche clavier pour prendre/déposer un ingrédient/assiete et une touche pour intéragir avec les objets de cuisine.

Fonctionalités : 
- Map avec dispotion des tables de cuisine, caisses, four etc...
- Personnage qui bouge
- Personnage qui prend des objets et les pose
- Poubelle pour objets
- Interaction avec les plans de coupe, four etc
- Assietes à laver et à utiliser pour mettre des ingredients dessus (pour servir)
- Mélanger des objets pour en faire un autre aliment
- Commandes des clients à compléter 
- Limite de temps pour commande et partie
- Menu avant partie

## TODO : Décrivez votre projet
Montrez qu'il mobilise des techniques de POO avancée

Par exemple pour les ingrédients on a une classe abstraite Ingredient avec des sous-classes qui hérite d'ingrédient (Champignons, Fromage, Tomates...)
Par exemple pour certains ingrédients on aura des interfaces spécifiques comme EstCommerstibleCru ou PeutEtreCuit

Comment allez-vous utiliser les patrons de conception ?

Notre Singleton est notre personage
Notre Décorateur permet de spécifier nos meubles de la cuisine (Ce bloc est une table, un four, une poubelle...)
Notre bridge pourrait servir pour les couleurs de blocs et items de la map
Notre Flyweight pour la génération des blocs et ingrédients pour une meilleure opti (Comme on a plusieurs choses pareil)

Comment allez-vous utiliser l'architecture MVC ?

Modèle pour les classes objets, vue pour les panels et controllers pour gérer les évenements

@annotation pour les ingredietns et leurs états

Faire la map pour la prochaine fois