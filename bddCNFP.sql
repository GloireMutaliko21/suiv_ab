 drop database gestionetsuividesabonnes;

CREATE DATABASE gestionetsuividesabonnes;
use gestionetsuividesabonnes;


CREATE TABLE ABONNES(
	ID_ABONNE int not null auto_increment,
	NOM_POSTNOM_AB varchar (60) not null,
	PRENOM_AB varchar(30) not null,
	SEXE varchar (10),
	ADRESSE text not null,
	TELEPHONE varchar (20) not null,
	MAIL text not null,
	PROFESSION varchar(15) not null,
	PHOTO longblob not null,
	primary key (ID_ABONNE)
	);

CREATE TABLE livres(
	NUM_LIVRE int not null auto_increment primary key ,
	CODE_LIVRE varchar(10) not null,
	TITRE text not null,
	AUTEUR varchar(60) not null,
	NOMBRE_PAGES int not null,
	MAISON_EDITION varchar(20) not null,
	VILLE_EDITION varchar(20) not null,
	ANNEE_EDITION int not null,
	NUM_EXEMPLAIRE int not null
	);

CREATE TABLE ordinateurs(
	NUM_ORDI int not null auto_increment primary key,
	CODE_ORDI int not null,
	MARQUE varchar (30) not null,
	EMPLACEMENT varchar(30) not null, 
	PHOTO longblob not null
	);

CREATE TABLE frequentations_bibliotheque(
	NUM_FREQUENTATION int not null auto_increment primary key,
	DATE_FREQUENTATION date not null,
	HEURE_ENTREE datetime not null,
	HEURE_SORTIE datetime not null,
	MOTIF_FREQ varchar (30) not null,
	OBSERVATION varchar (30) not null,
	ID_LIVRE int not null,
	ID_ABONNE int not null,
	foreign key (ID_LIVRE) references livres(NUM_LIVRE),
	foreign key (ID_ABONNE) references ABONNES(ID_ABONNE)
	);

CREATE TABLE frequentationsCcyberCafe(
	NUM_FREQUENTATION int not null auto_increment primary key,
	DATE_FREQUENTATION date not null,
	HEURE_ENTREE datetime not null,
	HEURE_SORTIE datetime not null,
	MOTIF_FREQ varchar (30) not null,
	OBSERVATION varchar (30) not null,
	CODE_ORDI int not null,
	ID_ABONNE int not null,
	foreign key (ID_ABONNE) references ABONNES(ID_ABONNE)
	);

CREATE TABLE  percepteurs(
	id_percepteur int not null auto_increment primary key,
	USER_NAME varchar(15) not null, 
	PASSWORD varchar(15) not null,
	FONCTION varchar(25) not null,
	PHOTO longblob not null
	);


CREATE TABLE paiement(
	NUM_PAIEMENT int not null auto_increment primary key,
	date_paiement date not null,
	montant varchar(15) not null,
	type_abonnement varchar(10) not null,
	date_expiration date not null, 
	id_abonne int not null,
	id_percepteur int not null,
	foreign key (id_percepteur) references percepteurs(id_percepteur),
	foreign key (ID_ABONNE) references ABONNES(ID_ABONNE)
	);

CREATE TABLE tarif_etudiant(
	id_tarif int not null auto_increment primary key,
	intitule varchar(20) not null,
	montant int not null
	);

CREATE TABLE tarif_enseignant(
	id_tarif int not null auto_increment primary key,
	intitule varchar(20) not null,
	montant int not null
	);

CREATE TABLE tarif_autre(
	id_tarif int not null auto_increment primary key,
	intitule varchar(20) not null,
	montant int not null
	);
