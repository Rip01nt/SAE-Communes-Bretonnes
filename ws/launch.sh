#!/bin/bash

# Set the source and class directories
src_dir="../src"
class_dir="../class"
lib_dir="../lib"

java -cp "$lib_dir":../src/ressources:"$class_dir":../lib/mysql-connector-j-8.4.0.jar:../lib/mariadb-java-client-3.4.0.jar --module-path ../lib/javafx/lib --add-modules javafx.controls,javafx.fxml,javafx.media view.CommunesView
