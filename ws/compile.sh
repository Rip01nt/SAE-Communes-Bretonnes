#!/bin/bash

# Set the source and class directories
src_dir="../src"
class_dir="../class"
lib_dir="../lib"

# Compile each Java file in the source directory
for file in "$src_dir"/*.java; do
    # Extract the file name without the extension
    filename=$(basename "$file" .java)
    
    # Compile the file, specifying the classpath to include the lib directory
    javac -cp "$lib_dir" -d "$class_dir" "$file"
done