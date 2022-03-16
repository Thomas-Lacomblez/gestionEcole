# gestionEcole


# Sommaire

1. [Prérequis](#prérequis)
2. [Lancer l'application](#app)
4. [Tester notre application](#test)


# prérequis

- Docker
- Docker-compose

# lancer Jenkins

exécuter la commande `docker-compose up -d` dans un terminal à la racine du projet.


# Uitliser le jenkinsfile

Sur le tableau de bord Jenkins, cliquez sur Nouvel élément. Saisissez ensuite un nom d'élément, par exemple «gestionEcole pipeline» et sélectionnez le projet «Pipeline». Cliquez ensuite sur OK.

![Création de pipeline](https://geekflare.com/wp-content/uploads/2019/11/jenkinspipeline2.png)

Cliquez sur l'onglet Pipeline et placez le contenu du jenkinsfile (Groovy Code) présent dans le repository ici.

Une fois que vous avez le code dans l'onglet Pipeline, cliquez sur Apply puis sur Save. Enfin, cliquez sur "Build now" pour lancer un build de la pipeline Jenkins que vous venez de créer.

![Lancement d'un build](https://geekflare.com/wp-content/uploads/2019/11/jenkinspipeline4.png)
