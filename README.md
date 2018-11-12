# M2_Calculatrice_UE_ConceptionObjet

## Projet lié aux UE : Conception Objet et Interopérabilité


### Analyse syntaxique

#### Introduction

Grace à la DTD on peut faire une analyse suntaxique qui permet.

Cela permet par exemple d'exclure des cas comme par exemple : 

1/ si il manque une opérande à une opération.

2/ La gestion des ids et des réferance  

#### Détection des erreurs syntaxique

On peut fournir un objet à Dom qui permet de gérer les erreurs.
Cette objet possède des methodes pour différancier trois type d'érreurs :

1/ fatal
2/ warnning
3/ error

Toutes ces méthode sont appelé avec en paramètre un SAXParseException.

Cette objet permet de determiner le type d'erreur, et sa localisation avec la ligne et la colonne.

### Analyse semantique

#### Introduction

Après l'analyse syntaxique on doit maintenant analiser les differantes instruction : 
1/ declaration
2/ affecations

Pour l'affectation il faut créer l'expression lier à l'affectation.
Pour cela jutilise un visiteur qui va resoudre en pronfondeur l'arbre de l'expression
Exemple : 
   +
 /   \
4     *
     / \
   4.3  5

Après avoir fait le lien entre toutes les expression il faut maintenant analyser les differantes erreur semantique possible comme : 

1/ Affection entre deux type different
2/ non de varriable deja utilisé
3/ Operation impssible -> ex String * integer
4/ utilisation d'une varriable non declarer
5/ utilisation d'une varriable non declarer

Chaque objet representent une instruction possède une liste d'exption.

Si celle ci est vide cela veut dire qu'au moin l'une des expections lister ci dessus à été declancher.

#### Détection des erreurs syntaxique

Pour l'analise j'utilise un visiteur qui possède :
1/ une table des symboles
2/ une table des affectation

ce 
