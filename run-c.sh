#!/bin/bash
set -e
cd src/main/c
gcc -o main -Ofast main.c
chmod +x main
./main
rm main
cd ../../..

