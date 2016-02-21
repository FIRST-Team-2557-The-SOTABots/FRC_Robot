#!/bin/bash

cd "$(dirname "$0")"
cd ../..

./gradlew --offline deploy
