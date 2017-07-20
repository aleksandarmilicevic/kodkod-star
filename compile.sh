#!/bin/bash

mkdir -p ./bin
find src -type f -name "*java" | xargs javac -d bin -cp $(find lib -name "*jar" | xargs | sed 's/ /:/g'):/usr/lib/jvm/java-7-openjdk-amd64/lib/tools.jar 
