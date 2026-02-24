# Uppgift 2 - Beroenden

`Se den externa Draw.io-filen för underlaget för dessa svar på resoneringsfrågorna`


### Förord
I ett tidigt skedde (Labortation 2) bestämde vi oss för att använda *composition over inheritence.* Detta har lett till ett stort antal designövervägningar, som i vissa skeden av arbetet tagit väldigt lång tid. Med det sagt så har vi i slutändan en produkt där vi har hanterat de beroendena som krävs (från vad vi uppfattar) på ett koncist sätt.

#### Vilka beroenden är nödvändiga?
- Beorenden mellan fordon och resp. *kompositonsklasser* (exempelvis Scania och dess Flatbed)
- När vi använder *composition over inheritence* har vi inte möjligheten att parametrisera klasserna med exempelvis *invarians*. Vi har då valt att använda *interface inheritance* vid de tillfällena som skulle kräva denna funktionen. Detta innebär att beroendena till dessa interfaces är nödvändiga.
- Vi använder delegation i *"kompositionsträdet"* Saab-Car-Automobile. Detta gör att beroendena blir mindre mellan klasserna. Detta följer Law of Demeter eftersom om exempelvis Automobile byter namn på en metod, påverkar det inte hela trädet.

#### Vilka klasser är beroende av varandra som inte borde vara det?
I allmänhet har vi undivikt att ha dubbelsidiga beroenden. Från våran observation har vi endast ett - CarView och CarController. Nedan följer istället beroenden mellan klasser som antingen skulle kunna generaliseras eller liknande:

- CarController och Volvo240 - CarController har ett beroende till specifikt klassen Volvo240. Detta kan generaliseras.

#### Finns det starkare beroenden än nödvändigt?
- Ett beroende som är onödigt starkt är det faktumet att CarController är beroende av tre separata klasser *CarData, MiscData, TruckData*.

#### Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?
- Våran abstraktion försämras av otydliga variabelnamn samt namn till Interfaces. Exempelvis CarFeatures **extends VehicleFeatures** som genomgått många namnbyten för att fylla två syften samtidigt.
- Våra Interfaces "*CarFeatures, TruckFeatures mm*" bryter mot Single Responsibility Principle i den bemärkning att de gränssnitten står både för en Interface-hierarki - men också för att exempelvis en bil ska implementera viktiga rörelsemetoder. Detta skulle kunna delas upp med separata ansvarsområden.
- Vi följer inte OCP i när en ny verkstad ska läggas till. Då måste en ny `Tag` kommas på, som senare hanteras hårdkodat. Här finns *room for improvement*.
```
Analysera era klasser med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP).
Vilka ansvarsområden har era klasser?
Vilka anledningar har de att förändras?
På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?
```
# Uppgift 3
### DrawPanel
#### Vilka ansvarsområden har era klasser?
- **DrawPanel** har det övergripande ansvarsområdet att hantera framförallt grafiken och att uppdatera det grafiska gränssnittet specifikt för fordonsdelen av programmet. De ansvarsområden som DrawPanel mer specifikt har är:
    - **moveit()** - Flytta varje fordons bild baserat på hur mycket bilens x,y-position förändras
    - **Hantera rutan** - Konstruktorn för DrawPanel sätter bland annat bakgrundsfärg.
    - **Lägger till fordon i fordonslistorna** - Fordonslistorna som deklareras i *CarController* får nya element i form av bilar/truckar med tillhörande *bild och Point* som kopplas till dessa fordon. 
        - Här synkas också bilens faktiska x/y-position med bildens x/y postion.
    - **paintComponent** - Varje frame ritas varje bild ut via den här metoden.

#### Vilka anledningar har de att förändras?
- I den nuvarande konstruktionen av DrawPanel så bryter den mot Single Responsibility Principle i den bemärkelsen att den hanterar del av logiken för fordonslistorna. Detta skulle innebära en begränsning om man exempelvis vill ändra fordonslistan till en *map* eller liknande, då skulle man behöva vara och pilla i två olika klasser.

#### Var skulle dekompisition behöva tillämpas?
Funktionell dekomposition har absolut sin plats i DrawPanel. Det finns flera metoder som gör samma grej, exempelvis finns det metoden:
```py
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Updatera för alla i listan
        for (CarData carObj : cc.getCars()){
            g.drawImage(carObj.getImage(),carObj.getPoint().x,carObj.getPoint().y, null);
        }
        for (TruckData truckObj : cc.getTrucks()){
            g.drawImage(truckObj.getImage(),truckObj.getPoint().x,truckObj.getPoint().y, null);
        }
        for (MiscData miscObj : cc.getMiscs()){
            g.drawImage(miscObj.getImage(),miscObj.getPoint().x,miscObj.getPoint().y, null);
        }
    }
```
Denna metoden skulle kunna dels delas upp i delmetoder eftersom varje for-loop gör engefär samma sak. Utöver detta finns en till brist i den här listuppdelningen, men det kommer att adresseras i **CarController**-klassen.

## Carview

#### Ansvarsområden
CarViews ansvarsområde är i sin helhet att rita upp UI för att kunna använda bilarnas metoder. Dessa knappar är i sin tur kopplade till metoder i CarController där bilarna de facto påverkas. 

#### Förändring
Trots att det vid första anblick verkar som om CarView har två uppenbara ansvarsområden tycker vi att det känns rimligt att båda hanteras i en och samma klass. Detta på grund av att användningsområderna kan generaliseras som:
` Vad finns för knappar? - Vad ska dessa knappar göra?`

Vi uppelver att det skulle kännas ologiskt uppdelat om de två frågorna besvarades på olika ställen i koden. 

## Engine 
#### Användning:
Engine är en superklass till RegularEngine och TurboEngine. Engine används genom komposition via Automobile-klassen och är parametriserad, vilket gör att man kan välja vilken typ av motor en bil ska ha.

#### Beroenden:
Klassen Engine har inga externa beroenden utöver sina subklasser. RegularEngine och TurboEngine är beroende av sin superklass.

#### Single Responsibility Principle (SRP):
Engine har ett ansvar, och det är att lägga en gemensam grund för olika typer av subklasser. Detta gör det lättare att expandera och underhålla koden.

#### Separation of Concerns (SoC):
Klassen Engine fungerar självständigt och kan implementeras i flera sammanhang utöver bilar. Exempelvis skulle man kunna använda samma klass i andra sammanhang där motorer används.

## Saab95, Volvo240, Scania och CarTransportTruck
#### Ansvar
- Skapa objekt av just dessa fordonsmodeller på ett lätt och användarvänligt sätt
- Separera de mer abstrakta klasserna från användaren
- Följa OCP genonm delegering och komposition av Car för Volvo240 och Saab95 samt Truck för Scania och CarTransportTruck
- Klasserna Scania och CartTransportTruck har dessutom komposition till varsitt släp
#### Förändring
- Vi ser för tillfället ingen anledning till förändring för Saab95 och Volvo240 då vi tycker att vi följt designprinciperna, speciellt OCP genom composition over inheritence
- Att Scania och CarTransportTruck har en association till ett och samma flak följer däremot ej OCP. 
- Relationen mellan lastbilarna och deras flak bör abstraheras, exempelvis genom ett förhållande där vardera del skapas var för sig, och kopplas ihop genom ett nytt form av objekt som bådadera har en komposition av.
#### Dekomposition
- Vi ser ingen anledning till att Volvo240 och Saab95 behöver någon form av dekomposition då de enbart består av delegerade metoder
- CarTransportTruck och Scania har däremot en del delegerade metoder med extra logik. Denna logik hade kunnat delas upp i hjälpmetoder för att ytterliggare följa SRP.

## Trailer - CarTransport, Flatbed
#### Användningsområden:
Användningen av dessa klasserna används i programmet genom komposition för att ge Truckar möjligheten att ha olika typer av flak. Båda dessa klasser har metoder för att höja/sänka flaket respektive rampen. Båda dessa har logiska begränsningar som också definieras i dessa klasser

#### Förändringar
Vi ser inga tydliga förändringar i dessa klasser kopplat till SoC/SRP

#### Dekomposition
Hurvida metoderna kan skrivas om internt upplever vi att det finns förbättringsmöjligheter. Exempelvis skulle metoderna:
```py
    public void liftFlatbed() {
        flatbedAngle += 10;
        if (flatbedAngle > 70) {
            flatbedAngle = 70;
        }
    }

    public void lowerFlatbed() {
        flatbedAngle -= 10;
        if (flatbedAngle < 0) {
            flatbedAngle = 0;
        }
    }
```
båda kunna innehålla en delmetod likt:
`isMovingOutOfBounds()` eller motsvarande. Detta hade förbättrat läsbarheten.

## Automobile
#### Ansvarsområde 
Automobile ansvarar för att lägga mallen för att kunna skapa Car-klassen och Truck-Klassen. Metoderna som finns i Automobile är allmän för båda klasserna och fås genom kompossission istället för inheritance.

#### Förändring
Man kan resonera för att det blir logiska tvetydigheter när vi använder kompossisson istället för inheritance eftersom det innebär att car "has an" Automible iställer för "is an" Automobil.

Just den här klassen följer SoC och SRP väl eftersom metoderna i denna klass är specifika för alla fordon och om man exempelvis vill skapa en truck kan man använda metoderna från automobil samt lägga till specifika metoder just för den klassen.

#### Dekomposition
I Automobile finns det absolut förbättringmöjligheter kopplat till funktionell dekomposition. Exempelvis metoden:
```py
    public void incrementSpeed(double amount){
        if (currentSpeed != 0) {
            currentSpeed = getCurrentSpeed() + engine.speedFactor() * amount;
            if (currentSpeed < 0.1) {
                currentSpeed = 0.1;
            }
            else if (currentSpeed > engine.getEnginePower()){
                currentSpeed = engine.getEnginePower();
            }
        }
    }
```
har stor förbättringspotential kopplat till läsbarhet. Vi anser att uppdelning i delmetoder skulle öka förståelsen för respektive logisk begränsning desto mer.

## CarController
#### Ansvar
- Ansvarar över att lyssna på CarView och reagera genom ändring av interna objekt samt dess representation i CarView
- Tillhandahåller information om alla interna objekt som representeras i programmet
- Tillhandahåller metoder för hantering logik mellan grafisk representation och icke-visuella objekt
#### Förändring
- Denna klass måste brytas ned i mindre delar då den varken har ett specifikt ansvarsområde eller är tydlig i projektstrukturen (följer varken SoC eller SRP)
- Klassen represneterar alla bilar, lastbilar och miscs enskilt vilket skapar repetetiv logik
    - Detta måste ändras och generaliseras eftersom det inte följer OCP.
- Kollisiondetektionen behöver abstraheras då en tag i form av en sträng avgör om exempelvis en Volvo kan köra in i en Volvo-verkstad 
#### Dekomposition
- Först och främst bör klassen delas upp i
    - Lyssning av CarView
    - Reaktion till Carview
    - Hantering av logik för interna objekt
    - Hantering av logik för visuella objekt
        - En koppling mellan dessa är vässentligt
    - Eventuellt separering av logik för de olika typerna av fordon kan vara
- Klassen behöver dekomposition i nästan alla metoder (kollisionsdetektion är relativt uppdelad)
- Alla metoder innehåller logik som kan separeras enligt SRP. I denna klassen hade det gjort en tydlig skillnad i förståelse av logik

## MechanicShop
#### Ansvar
- Klass för att representera en bilverkstad
- Amvänder parameteriserad polymorfism för att avgöra till vilken fordonsmodell verkstaden är till för
#### Förändringar
- Vi har insett att den typen av polymorfism som används gör det mycket komplicerat att detektera kollision mellan specifika bilar och specifika bilverkstäder. Därmed finns det anledning att dela upp klassen med hjälp av komposition, likt bilklasserna
- Enligt SoC och SRP kan klassen ses som lite väl bred. att därmed dela upp den enligt ovan hade ökat tydlighet i projektet och möjlighet till utökning (OCP)
#### Dekomposition
- Klassen bör möjligtvis delas upp ytterliggare klasser för att följa SRP, OCP och SoC
- När vi byggde klassen hade vi inte en tanke på dekomposition vilket betyder att många av metoderna kan delas upp i hjälpmetoder. Detta hade gjort läsbarheten i klassen mycket bättre samtidigt som det hade följt designprinciperna

## CarData, TruckData, MiscData
#### Ansvarsområde
Samtliga klasser ansvarar för att respektive fordon, dess bild och dess koordinater kopplas till samma objekt. De hanterar alltså den data som är kopplad till varje enskilt fordon eller verkstad.

#### Förbättringar
Man skulle kunna slå ihop TruckData och CarData till en gemensam klass. De fungerar på i princip samma sätt. Den enda skillnaden är att den ena hanterar lastbilar och den andra bilar. Detta tyder på att man skulle kunna använda arv eller generiska typer för att minska kodduplicering.

Single Responsibility Principle (SRP):
Dessa klasser följer SRP eftersom deras enda ansvar är att hålla reda på data för respektive fordon och verkstäder och enbart datahantering.

Separation of Concerns (SoC):
Samtliga klasser följer även SoC, eftersom de enbart ansvarar för datahantering och inte blandar in annan onödig logik. Detta gör systemet mer modulärt och lättare att underhålla.

# Uppgift 4
## Refaktoriseringsplan
1. Skapa en ny gemensam klass `VehicleData` som kan hantera både objekt av `Cars` och `Trucks`. Denna ska ha två olika konstruktorer. Med denna klassen - generalisera redundant kod i bl.a *CarController*
2. Skapa en ny klass `VisualUpdate` vars enda ansvar är att kalla på bildförändringar i form av förflyttning av bilder mm.
3. Flytta fordonslist-hanteringen till en ny klass `VehicleAndMiscHandling`, detta innefattar att skapa Arraylistsen samt lägga till fordon och miscs med tillhörande *Image och Point*. För att sedan kopplas med CarController via en komposition.
4. Förbättra funktionell dekomposition av logiken som nämns under **Dekomposition** delkapitlena i *Uppgift 3*
5. Tillämpa Factory-designmetoder för att abstrahera användarklasserna.

## Varför är detta förbättringar?
- Det följer Single Responsible Principle att dela upp CarController-klassen i deluppgifter. Den nya strukturen möjliggör enklare testning av delar av koden, samt förminskar **coupling**. 
- Vi följer Open-Closed-Principle för att vi möjliggör uttökning med hjälp av abstraktioner, utan att modifiera programmet.
- Iomed den nya strukturen följer vi Separation of Concern Principle. Detta på grund av att varje del har sin egna specifika uppgift.

## Finns det några delar av planen som går att utföra parallellt?

Ja, planen är strukturerad på ett sätt att flera oberoende klasser kan arbetas på. Utöver det är funktionell dekomposition en stor del av refaktoriseringsplanen, vilket också kan arbetas med allsidigt. 



