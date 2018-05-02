# Gliding Stickmen (Otm-Harjoitustyö)

## Lyhyt kuvaus
Ohjelma on varsinkin tällä hetkellä glorified kivi-paperi-sakset, mutta jos jää aikaa niin teen siitä vähän järkevämmän. Se on tappelu peli jossa erän voittaa yhdellä osumalla ja kummallakin on 3 erillaista hyökkäystä (jotka toimivat kuin kivi-paperi-sakset).

## Releases
[viikko 5 release](https://github.com/Etsku520/otm-harjoitustyo/releases/tag/viikko5)

[viikko 6 release](https://github.com/Etsku520/otm-harjoitustyo/releases/tag/viikko6)

## Dokumentaatio
[vaatimusmäärittely](https://github.com/Etsku520/otm-harjoitustyo/blob/master/documentation/m%C3%A4%C3%A4rittelydokumentti.md)

[tuntikirjanpito](https://github.com/Etsku520/otm-harjoitustyo/blob/master/documentation/tuntikirjanpito.md)

[arkkitehtuuri](https://github.com/Etsku520/otm-harjoitustyo/blob/master/documentation/arkkitehtuuri.md)

[käyttöohjeet](https://github.com/Etsku520/otm-harjoitustyo/blob/master/documentation/K%C3%A4ytt%C3%B6ohje.md)

## Komentorivitoiminnot
### Testsaus
Testit toimii tällä:

    mvn test
  
Ja jacoco testikattavuusraportti tulee komennolla

    mvn jacoco:report
    
Jos checkstyle toimii niin se onnistuu komennolla

    mvn jxr:jxr checkstyle:checkstyle
    
### Jar
jar tiedoston tekeminen onnistuu komennolla

    mvn package
