#!/bin/bash

# Set the source and class directories
src_dir="../src"
class_dir="../class"
lib_dir="../lib"

javac -cp "$lib_dir" -d "$class_dir" $(find $src_dir -type f -name "*.java")