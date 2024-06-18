
-- ===========Travaux à réaliser pour la période 4===========

-- -----------------Les requètes et les vues-----------------

-- Quand le nombre de ligne selectionner par la requète est supérieur à 5 je n'en afficherai que 5, comme dans les tp, pour des question de lisibilité.

-- Question 1 : jointure interne : Quelles sont le nom des gares de la commune GUINGAMP
SELECT DISTINCT UPPER(nomGare)
FROM Gare
JOIN Commune ON idCommune = laCommune
WHERE UPPER(nomCommune) = 'GUINGAMP';
/*
GUINGAMP
GOURLAND
*/
-- 2 rows returned 

-- Question 2 : auto-jointure : Quelles sont le nom des communes qui ont au moins deux gares 
SELECT DISTINCT UPPER(nomCommune)
FROM Gare G1, Gare G2, Commune
WHERE G1.laCommune = G2.laCommune
AND G1.codeGare != G2.codeGare
AND G1.laCommune = idCommune;
/*
CALLAC
GUINGAMP
PLOURIVO
PONT-MELVEZ
PONTRIEUX
*/
-- 13 rows returned

-- Question 3 : jointure externe : Afficher les nom des communes commencant par C et leurs gares si elles en ont une.
SELECT DISTINCT UPPER(nomCommune), codeGare, UPPER(nomGare), estFret, estVoyageur
FROM Commune
LEFT JOIN Gare ON laCommune = idCommune
WHERE UPPER(nomCommune) LIKE ("C%");
/*
CALANHEL				
CALLAC	    87473546	CALLAC	    0	1
CALLAC	    87473587	LES MAIS	0	1
CALORGUEN				
CAMLEZ				
*/
-- 85 rows returned 

-- Question 4 : jointure externe : Afficher le nom des communes qui n'ont pas de communes voisines 
SELECT DISTINCT UPPER(nomCommune)
FROM Commune
LEFT JOIN Voisinage ON idCommune = commune
WHERE communeVoisine IS NULL;
/*
ILE-DE-BREHAT
BEAUSSAIS-SUR-MER
AUDIERNE
ILE-DE-BATZ
ILE-DE-SEIN
*/
-- 12 rows returned

-- Question 5 : sous-requête (avec IN et NOT IN) : Quelles sont le nom des communes qui ont une commune voisine dont le nom commance par A
SELECT DISTINCT UPPER(nomCommune)
FROM Commune
WHERE idCommune IN( SELECT DISTINCT commune
                    FROM Voisinage
                    WHERE communeVoisine IN (   SELECT DISTINCT idCommune
                                                FROM Commune
                                                WHERE UPPER(nomCommune) LIKE ("A%")
                                            )
                  );
/*
LE BODEO
COETMIEUX
CORSEUL
LAMBALLE-ARMOR
MERLEAC
*/
-- 89 row returned

-- Question 6 : sous-requête (avec IN et NOT IN) : Quelle sont les 5 premiers communes triée par nom par ordre alphabetique croissant qui n'ont pas de gares 
SELECT *
FROM Commune
WHERE idCommune NOT IN (SELECT DISTINCT laCommune
                        FROM Gare)
ORDER BY UPPER(nomCommune) ASEC
LIMIT 5;
/*
35001	ACIGNE	    35
56001	ALLAIRE	    56
22001	ALLINEUC	22
35002	AMANLIS	    35
56002	AMBON	    56
*/
-- 5 rows returned

-- Question 7 : sous-requête (avec EXISTS et NOT EXISTS) : Quelle est le dépatrement de la dernière gare triée par odre alphabétique des nom des gares 
SELECT *
FROM Departement
WHERE EXISTS (  SELECT * 
                FROM Commune
                WHERE leDepartement = idDep
                AND EXISTS (SELECT *
                            FROM (  SELECT *
                                    FROM Gare
                                    ORDER BY UPPER(nomGare) DESC
                                    LIMIT 1) AS a
                            WHERE laCommune = idCommune
                           )
             );
/*
22	COTES-D'ARMOR	6196596
*/
-- 1 row returned

-- Question 8 : sous-requête (avec EXISTS et NOT EXISTS) : Quelle sont les communes qui n'ont pas de gare
SELECT * 
FROM Commune
WHERE NOT EXISTS(   SELECT *
                    FROM Gare
                    WHERE laCommune = idCommune);
/*
22001	ALLINEUC	        22
22002	ANDEL	            22
22003	AUCALEUC    	    22
22004	BEGARD	            22
22005	BELLE-ISLE-EN-TERRE	22
*/
-- 1087 rows returned 

-- Question 9 : fonction de groupe sans regroupement : Quelle est la différence entre la moyenne des prix moyens des logement en 2019 et le prix moyens des logement de Vannes en 2019
SELECT moyTot - moyVannes
FROM (  SELECT AVG(prixMoyen) AS moyTot
        FROM DonneesAnnuelles
        WHERE lAnnee = 2019) AS a, 
     (  SELECT prixMoyen AS moyVannes
        FROM DonneesAnnuelles, Commune
        WHERE lAnnee = 2019
        AND laCommune = idCommune
        AND UPPER(nomCommune) = 'VANNES')AS b;
/*
-57345.467923177086
*/
-- 1 row returned 
-- Avec ce résultat négatif je peut en déduit que le cout du logement a Vannes en 2019 etait supérieurs a la moyenne des coût des logement de la bretagne en 2019

-- Question 10 : fonction de groupe sans regroupement : Quelles est le nombre de gare présente dans le département 56
SELECT COUNT(codeGare)
FROM Gare, Commune
WHERE laCommune = idCommune
AND leDepartement = 56;
/*
21
*/
-- 1 row selected 

-- Question 11 : regroupement avec fonction de groupe : Combien y a t'il de gare par département 
SELECT DISTINCT UPPER(nomDep), COUNT(codeGare) AS nbGare
FROM Departement, Commune, Gare
WHERE idDep = leDepartement
AND idCommune = laCommune
GROUP BY idDep; 
/*
COTES-D'ARMOR	43
FINISTERE	    24
ILLE-ET-VILAINE	49
MORBIHAN	    21
*/
-- 4 rows returned

-- Question 12 : regroupement avec fonction de groupe : Quelle est le nombre de maison vendu en 2019 par département 
SELECT DISTINCT UPPER(nomDep), SUM(nbMaison) AS nbMaison
FROM Departement, Commune, DonneesAnnuelles
WHERE leDepartement = idDep
AND idCommune = laCommune
AND lAnnee = 2019
GROUP BY idDep;
/*
COTES-D'ARMOR	8420
FINISTERE	    11505
ILLE-ET-VILAINE	9583
MORBIHAN	    9748
*/
-- 4 rows returned

-- Question 13 : regroupement et restriction (avec HAVING) : Quelle est le nom des communes ayant le plus de gares
SELECT DISTINCT UPPER(nomCommune), COUNT(codeGare) AS nbGare
FROM Gare, Commune
WHERE idCommune = laCommune
GROUP BY laCommune
HAVING COUNT(codeGare) = (  SELECT MAX(nbGare)
                            FROM (  SELECT COUNT(codeGare) AS nbGare
                                    FROM Gare
                                    GROUP BY laCommune
                                 ) AS a
                         );
/*
SAINT-PIERRE-QUIBERON	4
*/
-- 1 row returned

-- Question 14 : regroupement et restriction (avec HAVING) : Quelle est l'année avec le plus haut prix moyen du m²
SELECT DISTINCT lAnnee, AVG(prixM2Moyen)
FROM DonneesAnnuelles
GROUP BY lAnnee
HAVING AVG(prixM2Moyen) = ( SELECT MAX(prix)
                            FROM (  SELECT AVG(prixM2Moyen) AS prix
                                    FROM DonneesAnnuelles
                                    GROUp BY lAnnee
                                 ) AS a
                          );
/*
2021	1829.2743061592496
*/
-- 1 row returned

-- Question 15 : division (division normale et division exacte) : Afficher les gares qui sont dans toutes les communes 
SELECT *
FROM Gare G1
WHERE NOT EXISTS (SELECT idCommune
                  FROM Commune
                  EXCEPT 
                  SELECT laCommune
                  FROM Gare G2
                  WHERE G2.codeGare = G1.codeGare);
/*
*/
-- 0 row returned

-- Question 16 : division (division normale et division exacte) : Afficher les Communes qui sont dans tous et exactement tous les département 
SELECT * 
FROM Commune C1
WHERE NOT EXISTS (SELECT idDep
                  FROM Departement
                  EXCEPT
                  SELECT leDepartement
                  FROM Commune C2
                  WHERE C2.idCommune = C1.idCommune)
AND NOT EXISTS (SELECT leDepartement 
                FROM Commune C2
                WHERE C1.idCommune = C2.idCommune
                EXCEPT
                SELECT idDep
                FROM Departement);
/*
*/
-- 0 row returned 


-- Question 17 : vue (pour gérer des contraintes à proposer) : Une Commune ne peut etre sa propre voisine 
CREATE OR REPLACE VIEW vue_communeVoisines
AS 
SELECT DISTINCT UPPER(nomCommune)
FROM Commune
JOIN Voisinage ON idCommune = commune
WHERE commune = communeVoisine;

SELECT * FROM vue_communeVoisines;
/*
*/
-- 0 row returned donc aucune commune n'est son propre voisin

-- Question 18 : vue (pour gérer des contraintes à proposer) : Tout les prix ou nombre doivent etre positifs
CREATE OR REPLACE VIEW vue_prixPositif
AS
SELECT *
FROM DonneesAnnuelles
WHERE prixM2Moyen < 0
OR prixMoyen < 0 
OR surfaceMoy < 0
OR nbMaison < 0
OR nbAppart < 0
OR depensesCulturellesTotales < 0
OR budgetTotal < 0
OR population < 0;

SELECT * FROM vue_prixPositif;
/*
2018	22001	3	0	80966.7	650.333	123.333	-1	-1	-1
2018	22002	15	0	162488	1856.6	96.5333	-1	-1	-1
2018	22003	10	0	203500	1742	115.2	-1	-1	-1
2018	22004	70	1	105038	1185.46	92.8028	-1	-1	-1
2018	22005	20	0	88159	840.25	100.5	-1	-1	-1
*/
-- 4349 rows returned
-- Avec cette contrainte on voit que les informations de 2018 ne sont pas valides

-- Question 19 : vue (pour gérer des informations dérivables à proposer) : Crée une vue qui donne l'information du département de chaque gare 
CREATE OR REPLACE VIEW vue_gareDepartement
AS
SELECT DISTINCT codeGare, nomGare, estFret, estVoyageur, laCommune, idDep AS leDepartement, nomDep AS nomDepartement
FROM Gare, Commune, Departement
WHERE laCommune = idCommune
AND leDepartement = idDep;

SELECT * FROM vue_gareDepartement;
/*
87159947	KER-LANN	    0	1	35047	35	ILLE-ET-VILAINE
87322347	TRAOU-NEZ	    0	1	22233	22	COTES-D'ARMOR
87334490	CESSON-SEVIGNE	0	1	35051	35	ILLE-ET-VILAINE
87334508	LA POTERIE	    0	1	35238	35	ILLE-ET-VILAINE
87471003	RENNES	        1	1	35238	35	ILLE-ET-VILAINE
*/
-- 137 rows returned

-- Question 20 : vue (pour gérer des informations dérivables à proposer) : Crée une vue qui donne le nombre de voisin de chaque commune 
CREATE OR REPLACE VIEW vue_nbVoisin
AS
SELECT idCommune, nomCommune, COUNT(communeVoisine) AS nbVoisin
FROM Commune, Voisinage
WHERE idCommune = commune
GROUP BY commune;

SELECT * FROM vue_nbVoisin;
/*
22001	ALLINEUC	        4
22002	ANDEL	            2
22003	AUCALEUC	        4
22004	BEGARD	            7
22005	BELLE-ISLE-EN-TERRE	5
*/
-- 1195 rows returned 

