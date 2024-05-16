
# Retro-conception

**Binome 1 : [BORJA Loris]**
**Binome 2 : [REINA-HIOT Tom]**

Complétez ce document pour décrire votre projet, les difficultés rencontrées, les design patterns mis en oeuvre, les améliorations possibles, et en quoi la POO vous a été utile.

> **Faites le avec sérieux, ce document ainsi que votre code seront évalués.**
Si vous considérez que votre code est quasi-parfait, je vais chercher les erreurs et en trouver, et cela vous pénalisera.
Si vous êtes critique envers vous-même et que vous expliquez correctement vos difficultés, vous serez "à moitié" pardonné.

Ce n'est pas grave de ne pas avoir été au bout de ce que vous vouliez faire, comportez vous comme un ingénieur qui doit rendre des comptes à son client, et qui doit expliquer pourquoi il n'a pas pu tout faire.
Pour rappel le client n'est pas un developpeur (sinon il ne vous aurait pas payé une fortune pour le faire à sa place), vous devez lui expliquer de manière simple et claire les problèmes rencontrés, en vous justifiant 
>Imaginez que vous avez codé Mortal Kombat 
Ne dites pas "je n'ai pas eu le temps de tout faire", mais plutôt "j'ai préféré me concentrer sur la création des spectaculaires "Finish Him" des personnages car c'est un élément essentiel du gameplay, cependant la difficulté dynamique en fonction de la maîtrise du joueur n'a pas pu être implémentée à temps, compte tenu que les critères de maîtrises sont difficilement modélisables, toutefois nous pourrions envisager d'implémenter que plus le combat dure longtemps, plus les coups portés sont puissants, ce qui est rapide à implémenter et lors d'une mise à jour, nous pourrions remplacer ce système par quelque chose de plus élaboré"

Aussi, en entreprise, vous serez confronté à des programmes très mal codés, et vous allez galérer à les comprendre, vous risquez d'essayer de les corriger et tomber dans les mêmes ecueils que les développeurs précédents.
Pour cela, il est courrant de tenir un jour un Document d'Architecture Technique (DAT) qui explique comment fonctionne le programme, et comment le reprendre ainsi qu'un document de réversibilité qui explique comment reprendre le code de quelqu'un d'autre.
(C'est obligatoire pour les marchés publics de prévoir une réversibilité, c'est à dire que le client peut vous dégager et une autre entreprise doit pouvoir reprendre votre code sans difficulté)
Dans ces documents, il ne s'agit pas de cacher la poussière sous le tapis, il faut être honnête et proposer une vision d'ensemble de votre code, et expliquer pourquoi vous avez fait des choix, et pourquoi vous n'avez pas fait d'autres choix, il est souvent question de compromis (on fait un truc pas ouf pour gagner du temps, mais la qualité du code en pâtit, etc.)
> Vous pouvez dire : "Pour la gestion des collisions, nous utilisons une librairie tierce, toutefois celle-ci ne gère que les collisions entre des rectangles, au fur et à mesure des itérations, des ennemis de grande taille et de forme complexe sont apparus, toutefois, nous avons conservé une hitbox rectangulaire, en résulte que le joueur peut être touché alors que visuellement, il n'est pas en contact avec l'ennemi ; nous avions également envisagé de créer plusieurs hitbox de tailles différentes sur un même ennemi afin de mieux coller à la forme de celui-ci, toutefois, les performances du jeu ont étés trop dégradées"

---
# Partie "Client" (pas trop technique) :

## Objectif du projet

[Décrivez ici l'objectif initial du projet, ne cherchez pas à le minorer si vous n'avez pas tout fini, décrivez ce que vous avez voulu faire]

Notre projet est inspiré du jeu Overcooked, et simule une cuisine en 2D "Rétro" ou l'objectif est de réaliser des burgers en effectuant des actions simples, comme par exemple couper des tomates, faire cuire un steak et construire le burger. Le joueur apparait sur une map de cuisine, composée de "Blocs" Table, Sol ect... et peut se déplacer avec les touches "ZQSD". L'inventaire du joueur est limité par un seul objet et il peut interagir avec les blocs et items avec les touches "LM". On peut voir l   a recette à réaliser en bas de l'écran du joueur.

## Résultat

[Avez vous atteint votre objectif ?]

Nous avons atteind notre objectif initial qui était de pouvoir générer une cuisine selon un shéma voulu, de pouvoir ce déplacer à travers celle-ci en ayant la possibiliter de manipuler des ingrédients, de les transformer et de les assembler pour créer une recette. Actuellement dans le jeu, les ingrédients disponibles sont salade, tomate, steak et pain.

PREMIERE RECETTE :
- Prendre une tranche de pain dans le conteuneur à pain en interagissant avec "L", le prendre avec "M" et le déposer sur une table.

Ensuite dans n'importe quel ordre il faut :
- Ajouter de la salade en interagissant avec "L" dans le conteneur à salade et le placer sur le pain avec "M".
- Prendre une tomate dans le conteneur de tomates avec "L", la prendre avec "M" puis la déposer sur la planche à découper avec "M" puis interagir avec avec "L" pour découper la tomate. Une fois qu'elle est découpée la prendre avec "M" et ensuite la déposer sur le pain avec "M".
- Prendre un steak dans le conteneur de steak avec "L" et "M", le déposer sur la plaque de cuisson avec "M". Interagir avec "L" pour cuire le steak et une fois cuit, le prendre et le déposer sur le pain avec "M"

Enfin il faut de nouveau prendre une tranche de pain dans le conteneur à pain avec "L" et "M" et le déposer sur tous les ingrédients qu'on a ajouté. On obtient un magnifique burger !

DEUXIEME RECETTE :
- Prendre une tranche de pain dans le conteuneur à pain en interagissant avec "L", le prendre avec "M" et le déposer sur une table.
- Prendre une tomate dans le conteneur de tomates avec "L", la prendre avec "M" puis la déposer sur une plaque de cuisson avec "L". Interagir avec "L" pour cuire la tomate et une fois cuite, la prendre et la déposer sur le pain avec "M".
- Prendre de nouveau une tranche de pain dans le conteneur à pain avec "L" et "M" et le déposer sur tous les ingrédients qu'on a ajouté.

### Améliorations possibles

[Décrivez ici les améliorations que vous auriez pu apporter si vous aviez eu plus de temps]

+ de recettes
+ de machines
+ temps limite de préparation de la recette
+ maps générées aléatoirement, ou juste des différentes maps
+ un deuxième joueur (C'est chaud !)

---
# Partie "Développeur" (plus technique) :

### Implémentations remarquables

[Si pendant votre implémentation, vous trouvez que vous pouvez être particulièrment fiers d'une partie de votre code, décrivez là ici ; par exemple si vous avez généré une carte de manière procédurale, ou à l'aide d'un fichier]

- Génération d'une map à partir d'un fichier texte.
- Annotations de code (Modularité) qui permettent de créer facilement et rapidement des ingrédients, des recettes et des blocs.
- Affichage de la recette demandée.
- Les magnifiques sprites dessinés à la main.

### Faiblesses du code

[C'est ici que vous me dites ce que vous savez que vous avez mal fait, expliquez pourquoi vous avez fait ce choix (manque de temps, manque de compétence, trop pénible à faire, etc.)]

- Génération de la map : pour l'instant, créer une map rectangulaire cause des soucis et l'inventaire est forcémment à la case en bas à droite pour rendre plus simple au niveau du code.
- Il n'y as pas de vérification si la map est correcte en terme d'emplacement, si un emplacement joueur est défini et si les outils sont accessible. (Question de temps)
- Définir une map trop grande (au dela de 14x14) peut causer des soucis au niveau de l'affichage où la map serait trop grande pour l'écran : cela est due au fait que chaque case est définie selon des pixels.
  
- Comme par exemple dans Bin, certaines Tiles appellent des méthodes du gameManager en demandant ce dernier en paramêtre, ce qui a été mis en place pour gagner du temps au niveau du projet.
- L'inventaire est une Tile qui contient un objet, et non pas juste un réel inventaire. Cela peut causer des soucis au niveau de l'affichage mais faire de cette façon est plus simple à coder.
- La gridView de la map et autres liés à javaFx on été générés depuis App pour que cela soit plus simple à mettre en place.
  
- Nous vérifions la collision de bloc avec le chemin du sprite de la Tile en fâce : cela peut causer des soucis si on est ammené à modifier le nom de cette sprite.
- Certains sprites sont liées au nom de classes et donc présententes le même problème. Ce choix à été fait pour simplifier le lien entre un objet et une sprite.

- La gestion des collisions se base sur des coordonées en int donc des mouvements relativements sacadées, car mettre en place des coordonées en double rendrerait bien plus complexe la gestion des collisions et nécéssiterait la mise en place d'une "Hitbox" pour le joueur.

- La gestion de beaucoup de sprites se base sur la récupération de ces derniers par un chemin "sprites/" + nom + ".png" mais cela peut causer des soucis si le sprite n'est pas en png.
- Aussi, pour les différentes Tiles de la map, le chemin des sprites est écrit en dur dans le code, ce qui nécéssite de modifier le code de cette partie si une sprite change de nom. Eventuellement on aurait pu envisager une manière plus propre de définir les sprites de chaque Tile, mais cela nous aurais pris plus de temps et aurait augmenté la complexité du code.

### Difficultés rencontrées

#### 1. [Génération dynamique des ... pour ...]

[Expliquez ici la difficulté rencontrée et comment vous l'avez contournée]

- Génération de la map

On a eu de légères difficultés à générer la map, car on avait des problèmes de séparateurs, comment gérer le fait qu'un chiffre est récupéré après l'autre.
Donc nous utilisons un split, qui prend une ligne du fichier txt et la converti en un array de nombres.

Voilà le code qui récupère la map :

```java
InputStream is = getClass().getResourceAsStream("Map/"+mapName+".txt");
BufferedReader br = new BufferedReader(new InputStreamReader(is));

int c = 0;
int r = 0;

while(c < sizeY && r < sizeX){
    String line = br.readLine();

while(c < sizeX) {
    String values[] = line.split("\\s+");
    int val = Integer.parseInt(values[c]);

    mapTiles[c][r] = val;
        c++;
    }
    if(c == sizeY){
        c = 0;
        r++;
    }
}
br.close();
```

- Affichage des sprites

L'affichage à été un peu compliqué à réaliser, il fallait manipuler des "Images" et des "ImagesView".

```java
public ImageView createNewSprite(String path) {
    Image image = new Image(getClass().getResourceAsStream(path));
    ImageView imageView = new ImageView();
    imageView.setImage(image);
    return imageView;
}
```

Un autre point de difficultés avec les sprites etait de pouvoir modifier le sprite facilement sans faire trop d'appels de méthodes.

#### 2. [Gestion des collisions]

[Exemple : Nous n'avons pas réussi à gérer les collisions, PARCE QUE, mes objets n'héritaient pas d'une classe commune, car nos objets héirtaient de ... et nos personnages de ...]

Dans un premier temps, nous avons tenter de mettre en place des coordonées de joueur en double, ce qui aurait permit au joueur d'exister entre deux cases, mais il etait assez compliqué de calculer si le joueur entrait en collision avec un mur ou autre, car les coordonées du joueur ne correspondaient pas à celles du sprite entier mais seulement aux coordonées du point en haut à droite du sprite.
Donc nous sommes revenus vers des coordonées simples (int), sacrifiant la fluidité de mouvement mais permettant de s'assurer du bon fonctionnement du système de collisions.

La gestion des collisions est effectuée en verifiant que la case en face du joueur à comme sprite "floor". Si c'est du sol, le joueur peut avancer.

```java
private void collisionCheck(double nXpos, double nYpos) {
    int tileX = (int) (nXpos / 64); 
    int tileY = (int) (nYpos / 64); 

    if(tileset[tileX][tileY].getPath() == "sprites/floor.png") {
        xPos = nXpos;
        yPos = nYpos;
    }
}
```

#### 3. [Autre]

Au niveau de la nourriture, l'une des difficultés, plutôt au niveau graphique, a été de faire apparaitre l'objet sur la map.
Pour cela on a du faire appeller une méthode au niveau du GameController plutôt qu'au niveau de l'objet lui même.

Il a fallu aussi trouver un moyen de mettre en place un "inventaire" et de gérer comment le joueur échange l'objet de l'inventaire avec ceux en jeux.
Ce qui nous as fait rencontrés des soucis au niveau graphique avec un inventaire qui visuellement ne se vide pas.

Au niveau des recettes, il y avait des difficultés au niveau de comment récupérer ces dernières pour en choisir, au hasard, l'une d'entre elles à afficher.
aussi les recettes ont du être lié à une base, qui est un ingrédient, et mettre en place un array qui contiendrait les ingrédients : Il n'y as pas de visuels pour les ingrédients ajoutés à une base.

### *Design Patterns* mis en oeuvre

#### 1. [Factory]
[Décrivez ici brièvement le design pattern utilisé et pourquoi]
[Ajouter éventuellement des exemples de code pour montrer l'élégence de votre solution, pour cela vous pouvez écrire en Markdown votre code.]

Un exemple de fabricateur dans notre code sont les aliments qui servent à nos recettes. On a par exemple une classe "Salad" qui hérite de la classe "Food".

```java
public class Food extends Item {

    public Food(int xPos, int yPos, String name) {
        super(xPos, yPos, name);
    }
}

public class Salad extends Food {
    public Salad(int xPos, int yPos) {
        super(xPos, yPos, "Salad");
    }
}
```

#### 2. [Singleton]

Notre singleton pattern est notre personnage :

```java
Player character = new Player(spriteC, playerPane, mapTiles, (Inventory)mapTiles[boardX-1][boardY-1]);
```

#### 3. [Decorator]

Notre décorateur permet d'ajouter des cases sur la map avec des comportements différents en utilisant simplement une interface, par exemple notre interface "InteractTile" permet d'ajouter un comportement sur une case (Qui peut être une machine, ou une autre case), comme par exemple poser-prendre un item, essayer de le transformer (De le cuire ou de le couper).

Exemple de la classe CookingPlate qui est une case "Machine" à qui on a donné un comportement :

```java
public class CookingPlate extends Machine implements InteractTile{
    public CookingPlate(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(GameManager gm) {
        try {
            if (holding instanceof Food) {
                Food transformedFood = TryTransform((Food) holding, this);
                holding = transformedFood;
            }
        } catch (InstantiationException | IllegalAccessException | InterruptedException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
```

---
# Partie pédagogique

### En quoi la POO vous a été utile

[Par exemple, expliquez que vous auriez éprouvé des difficultés à gérer les collisions si vous n'aviez pas utilisé la POO, ou que vous avez pu facilement ajouter des fonctionnalités à votre jeu grâce à la POO
Minimum 15 lignes (personnalisé en fonction de votre projet)]

On pense que sans POO ça aurait été très compliqué. De faire de l'objet, quelque soit le language, permet d'optimiser et de rendre le code plus facile à lire, à comprendre et surtout à modifier.

Par exemple dans notre jeu, on a la possibilité d'ajouter des éléments très rapidement grâce à nos design patterns et nos classes. Que l'élément soit une case, un comportement, ou un item, il est très facile d'en ajouter ou d'en supprimer selon nos besoins.
Pour la nourriture, la POO nous permet de différencier entre les ingrédients, les ingrédients modifiables, bases de recettes et recettes finie : L'héritage permet aussi de réduire le code, en faisant par exemple sorte que nos objets nourritures ait tous des méthodes en commun, ce qui a permis de faire plus simplement la mise en place des transformations (Machines) de nourriture, qui s'applique à plusieurs classes différentes mais qui partagent les méthodes importantes.

La notion de classes et interfaces permet aussi de donner une identité aux objets du jeu, nottament par exemple en opérant des vérifications si l'objet appartient à telle instance de classe, etc...

Il est aussi très facile à lire, les fichiers sont séparés, avec peu de contenu, ce qui permet de s'y retrouver et aussi si quelqun reprend notre code il ne sera pas trop compliqué de comprendre comment sont organisées les choses.

### Intêret de l'exercice

[Décrivez ici si vous avez compris un concept particulier que vous n'aviez pas compris en cours, inversement si vous pensiez qu'il était possible de faire qqchose mais que cela ne s'est pas passé comme prévu]

Pour ma part (Tom), les designs patterns étaient vraiment abstraits en cours, mais le projet a permis de m'éclairer un peu plus grâce à la pratique. De plus la notion d'interface m'était aussi assez étrangère, mais elle s'est révélée très utile et je pense avoir bien compris maintenant.

Pour ma part (Loris), le concept de designs patterns n'était pas trés simple au début, mais les utiliser dans un cas pratique (notamment Transformable de notre projet) a permit de bien mieux comprendre les designs patterns et leur utilisation.

### Concluez

[Plus globalement, quel est votre ressenti sur ce projet
Minimum 5 lignes]

Très intérréssant et ludique. Le fait de pouvoir choisir le sujet de notre projet est pour nous un grand facteur de motivation sur l'envie d'apprendre à programmer en POO.
De plus, on trouve que la POO et les designs patterns sont vraiment utiles comme décrits sur les points ci dessus, malgré parfois la difficulté de comprendre le fonctionnement des patterns qui se révèlent parfois assez abstraits et compliqué a visualiser.
Enfin, le fait de pouvoir coder/tester visuellement en direct est aussi un facteur de motivation qui nous pousse à faire que "yes sa marche !".
Cependant, on passe peut être trop de temps sur des soucis liés à la partie graphique, qui n'est pas l'objectif principal du projet.
De ce projet on en garde un bon souvenir, qu'on va précieusement archivé pour peut être plus tard s'en servir pour s'aider sur d'autres projets en POO.
