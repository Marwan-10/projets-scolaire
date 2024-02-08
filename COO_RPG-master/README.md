# COO_RPG

### Data steampunk :
    classe disponible:
        - cyborg ( capacité spécial : superforce -> boost la force pendant 3 tour, Surcharge electromagnétique -> freeze les enemi pour 2 tour, jour férié : 2 tour sans pouvoir attaqué puis one shoot tout le monde dans la salle)

        - humain (capacité spéciale : force du désespoir -> 1 chance sur 2 que les enemies ai pitié et laisse le joueur passé utilisable que sur les salle pair, géo : pas besoin de munition pendant 3 tours, Thémistocle : augmente x2 l'esquive)

        - automate (capacité spéciale : réparation : regen 3pv 1 fois par salle maximun, Optimus prime : se transforme en voiture et tue 1 enemie dans la salle aléatoirement 1 chance sur 2 de marcher que sur les salle impair, Cannibale: ponctionne 1pv pour avoir 2munitions)
    Monstre :
        - automate  : pv = 10pv force = 6 (n'attaque que 1 fois par tour : si le tour est pair) , bobine tesla * 2 de degats, 30xp
        - désosseur : pv = 5pv force = 2  ( mousquet * 2 de dgt ), 10xp
        - wraith    : pv = 3   force = 7  ( lance écrou * 2 de dgt, 1/3 absorbe 1/4 des pv du joueurs), 20xp


    stat à ajouter : mana !!!

        - cyborg : 3 / 3 / 3 / 3
        - humain : 2 / 4 / 2 / 4
        - automate : 4 / 2 / 4 / 2


    objet disponible :
        - huile
        - fromage

        - bobine tesla tier fer / or / diamant
        - mousquet     tier fer / or / diamant
        - lance écrou  tier fer / or / diamant

        armure improvisé
        armure basique
        armure supérieur

        munition : écrou / poudre

    Looting table :

        huile: salle 0 -> 5 : 1 chance sur 2 salle 5 -> x, 1 chance sur 5
        fromage: salle 0 -> 5 : 1 chance sur 2 salle 5 -> x, 1 chance sur 5

        arme:
        tier fer : salle 1, 1/3 d'avoir 1 des 3 armes
        tier or : salle 5, 1/3 d'avoir 1 des 3 armes de rang supérieur
        tier diamant : salle 10, 1/3 d'avoir 1 des 3 armes de rang supérieur

        écrou:  1 chance sur 3 par salle
        poudre: 1 chance sur 3 par salle

        armure improvisé: 1/5 dans chaque pièce --> 1 chance 4 pour chacune des 4 pièces
        armure basique:   pas avant la salle 5 , 1/5 dans chaque pièce --> 1 chance 4 pour chacune des 4 pièces
        armure supérieur: pas avant la salle 10 , 1/5 dans chaque pièce --> 1 chance 4 pour chacune des 4 pièces


### Data médievale :

    classe disponible:
        - barbare (capacité spéciale : cri de guere -> boost la force pendant 3 tours, frénésie: boost énormément la force au détriment de la dextérité sur 1 coup utilisable 1 fois par salle, coup de boule : fait 10 de dgt mais perd 1 d'intelligence )

        - archer  (capacité spéciale : frappe divine -> touche tout les enemies de la salle avec ses flèches dgts / 2 , flêche gelé : freeze l'enemie pour 2 tour, sniper: fleche critique à x4 de dgt)

        - sorcier (avada kadabra : pétrifie les enemie pour 2 tours, lecture : endort les enemies dans la salle 1 chance sur 2 que sa fonctionne en salle pair, covidé : fait fuir les enemie de la salle dans la salle d'après)

        stat à ajouter : mana !!!

        - barbare : 4 / 2 / 4 / 2
        - archer : 2 / 4 / 3 / 3
        - sorcier : 1 / 3 / 2 / 5

    objet disponible :
        - poulet  -> regen 2pv
        - potion de vie -> regen 4pv

        - épée              fer / or / diamant
        - arbalète          fer / or / diamant
        - baguette magique  fer / or / diamant

        - armure cuir
        - armure or
        - armure netherite

        munition : flèche / mana

    Monstre :
        - dragon : pv = 10pv force = 6 (n'attaque que 1 fois par tour : si le tour est pair), baguette magique * 2 de dgt  30xp drop
        - mercenaire : pv = 5pv force = 2  ( arbalète * 2 de dgt)                                                           10xp drop
        - rat enragé : pv = 3   force = 7  ( épée * 2 de dgt, 1/3 de voler un item de type nourriture de type consomable) 15xp drop



    looting table :
        plus le numéro de salle est important, plus les items intéressant sont présent, l'ordre est important !!!

        poulet : salle 0 -> 5 : 1 chance sur 2 salle 5 -> x, 1 chance sur 5
        potion de vie : salle 0 -> 5 : 1 chance sur 5   salle 5 -> x, 1 chance sur 4

        arme:
        tier fer : salle 1
        tier or : salle 5
        tier diamant : salle 10

        flêche : 1 chance sur 3 par salle
        mana : 1 chance sur 4 par salle

        armure  cuir  : 1/5 dans chaque pièce --> 1 chance 4 pour chacune des 4 pièces
        armure or     : pas avant la salle 5 , 1/5 dans chaque pièce --> 1 chance 4 pour chacune des 4 pièces
        armure netherite: pas avant la salle 10 , 1/5 dans chaque pièce --> 1 chance 4 pour chacune des 4 pièces




        max élément par coffre : 3


intelligence pour calculer les dgts magique et taux de réussite attaque magique
dextérité  : réussite attaque physique

salle 1 = 1.0
salle 2 : 1.1 multiplicateur dgt


CAPACITE utilisable 1 fois par salle sauf celle spécifié salle pair / impair
