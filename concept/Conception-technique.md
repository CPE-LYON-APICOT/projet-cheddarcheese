
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

Notre projet est inspiré du jeu Overcooked, et simule une cuisine en 2D "Rétro" ou l'objectif est de réaliser des burgers en effectuant des actions simples, comme par exemple couper des tomates, faire cuire un steak et construire le burger. Le joueur apparait sur une map de cuisine, composée de "Blocs" Table, Sol ect... et peut se déplacer avec les touches "ZQSD". L'inventaire du joueur est limité par un seul objet et il peut interagir avec les blocs et items avec les touches "LM".

## Résultat

[Avez vous atteint votre objectif ?]

Nous avons atteind notre objectif initial qui était de pouvoir générer une cuisine selon un shéma voulu, de pouvoir ce déplacer à travers celle-ci en ayant la possibiliter de manipuler des ingrédients, de les transformer et de les assembler pour créer une recette. Actuellement dans le jeu, les ingrédients disponibles sont salade, tomate, steak et pain.

Pour gagner la partie il faut en premier :
- Prendre une tranche de pain dans le conteuneur à pain en interagissant avec "L", le prendre avec "M" et le déposer sur une table.

Ensuite dans n'importe quel ordre il faut :
- Ajouter de la salade en interagissant avec "L" dans le conteneur à salade et le placer sur le pain avec "M".
- Prendre une tomate dans le conteneur de tomates avec "L", la prendre avec "M" puis la déposer sur la planche à découper avec "M" puis interagir avec avec "L" pour découper la tomate. Une fois qu'elle est découpée la prendre avec "M" et ensuite la déposer sur le pain avec "M".
- Prendre un steak dans le conteneur de steak avec "L" et "M", le déposer sur la plaque de cuisson avec "M". Interagir avec "L" pour cuire le steak et une fois cuit, le prendre et le déposer sur le pain avec "M"

Enfin il faut de nouveau prendre une tranche de pain dans le conteneur à pain avec "L" et "M" et le déposer sur tous les ingrédients qu'on a ajouté. On obtient un magnifique burger !

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
- Les magnifiques sprites déssinés à la main.

### Faiblesses du code

[C'est ici que vous me dites ce que vous savez que vous avez mal fait, expliquez pourquoi vous avez fait ce choix (manque de temps, manque de compétence, trop pénible à faire, etc.)]

******

### Difficultés rencontrées

#### 1. [Génération dynamique des ... pour ...]

[Expliquez ici la difficulté rencontrée et comment vous l'avez contournée]

- Génération de la map

On a eu de légères difficultés à générer la map, car on avait des problèmes de séparateurs, comment gérer le fait qu'un chiffre est récupéré après l'autre.

Voilà le code qui récupère la map :

```java
InputStream is = getClass().getResourceAsStream("Map/"+mapName+".txt");
BufferedReader br = new BufferedReader(new InputStreamReader(is));

int c = 0;
int r = 0;

while(c < sizeY && r < sizeX){
    String line = br.readLine();

    while(c < 9) {
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

#### 2. [Gestion des collisions]

[Exemple : Nous n'avons pas réussi à gérer les collisions, PARCE QUE, mes objets n'héritaient pas d'une classe commune, car nos objets héirtaient de ... et nos personnages de ...]

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
Player character = new Player(spriteC, playerPane, mapTiles, (Inventory)mapTiles[8][8]);
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
        } catch (InstantiationException | IllegalAccessException | InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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

Il est aussi très facile à lire, les fichiers sont séparés, avec peu de contenu, ce qui permet de s'y retrouver et aussi si quelqun reprend notre code il ne sera pas trop compliqué de comprendre comment sont organisées les choses.

### Intêret de l'exercice

[Décrivez ici si vous avez compris un concept particulier que vous n'aviez pas compris en cours, inversement si vous pensiez qu'il était possible de faire qqchose mais que cela ne s'est pas passé comme prévu]

Pour ma part (Tom), les designs patterns étaient vraiment abstraits en cours, mais le projet a permis de m'éclairer un peu plus grâce à la pratique. De plus la notion d'interface m'était aussi assez étrangère, mais elle s'est révélée très utile et je pense avoir bien compris maintenant.

### Concluez

[Plus globalement, quel est votre ressenti sur ce projet
Minimum 5 lignes]

Très intérréssant et ludique. Le fait de pouvoir choisir le sujet de notre projet est pour nous un grand facteur de motivation sur l'envie d'apprendre à programmer en POO.

De plus, on trouve que la POO et les designs patterns sont vraiment utiles comme décrits sur les points ci dessus, malgré parfois la difficulté de comprendre le fonctionnement des patterns qui se révèlent parfois assez abstraits et compliqué a visualiser.

Enfin, le fait de pouvoir coder/tester visuellement en direct est aussi un facteur de motivation qui nous pousse à faire que "yes sa marche !".

De ce projet on en garde un bon souvenir, qu'on va précieusement archivé pour peut être plus tard s'en servir pour s'aider sur d'autres projets en POO.