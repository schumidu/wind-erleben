printf 'Neuer Programmzyklus\n'
if ./killpayara.sh
then
    printf "kill erfolgreich\n"
else
    printf "kill nicht erfolgreich\n"
fi
docker compose down
sleep 1
if ./gradlew clean war
then
    printf "clean war erfolgreich\n"
else
    printf "clean war fehlgeschlagen\n"
fi
docker compose up -d
if ./payara6/bin/asadmin start-domain
then
    printf "payara start erfolgreich\n"
else
    printf "payara start mit Fehler\n"
fi
sleep 1
if ./redeploy.sh
then
    printf "redeploy successfull"
else
    printf "Fehler bei redeploy"
fi
sleep 1
printf '\n\n\n'