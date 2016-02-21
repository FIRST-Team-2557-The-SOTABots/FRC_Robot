cd /d %~dp0
cd ../..

gradlew --offline deploy
pause