# Laboration 4 diskussioner

## Uppgift 2: Model-View-Controller
### Brister från ursprungliga användargränssnittet(Början av lab3)

Huvudsak:
- Vi ser att Model.CarModel i huvudsak kommer att agera som en **Model**. Med det sagt så finns det uppenbara brister som följer nedan.
- Vi identifierar Controller.UserInputs som huvudsak en **Controller**
- Samt View.DrawPanel som **view**

Problematik:
- Model.CarModel innehåller ett objekt av Controller.UserInputs, detta gör "Modellen" beroende av Controllern, vilket motstrider modellprinciperna.
- Model.CarModel använder metoden moveit(), vilket skapar ett beroende mellan **Modellen** och **Vyn**.
- Att bilobjekten hanteras i samma Datasamling som bilderna och bildernas *Points* bryter mot MVC, eftersom bilarna ska kunna användas av olika grafiska gränssnitt - vilket inte är möjligt i nuläget pga att de binds till den grafiska representationen - JFrame
- Vi hade ingen *Applikation* som vi körde programmet med.

### Vilka av dessa brister åtgärdade ni med er nya design från del 3? Hur då? Vilka brister åtgärdade ni inte?
Lösta brister:
- Vi bryter ut den visuella delen ur Model.CarModel, separerar den till en vy, som är beroende av modellen, men modellen är inte beroende av den grafiska represenationen - vilket uppfyller MVC-principerna.
- En Applikationsklass har skapats `Main.java`, detta möjliggör applikationsspecifik kod om behovet för det finns i framtiden.
- En lösning har skapats för att hantera moveIt()s position. Denna ligger numera i View.VisualUpdate-klassen, som hanterar all vy (som tidigare låg i Model.CarModel)

Olösta brister:
- Just nu har vi klassen VehicleData - som gör att Modellen är beroende av Vyn. Våran föreslagna lösning är att vi delar upp den grafiska hanteringen med *BufferedImage och Points* i en klass, och håller de interna fordons(och misc)-objekten till modellen. På så sätt **speglar endast** det grafiska gränssnittet den interna logiken från modellen.

Övriga lösningar:
- Döpa om diverse klasser för att tydligare urskilja Model-View-Controller i projektet.
  - Controller.UserInputs -> Controller.UserInputs
  - Model.CarModel -> Model.CarModel
  - View.DrawPanel behåller namnet View.DrawPanel
- Lägga klasserna ovan i packages.
### UML-Diagrammet för att porträttera dessa förändringar
Finns i filträdet.

# Uppgift 3: Fler designmönster

Observer, Factory Method, State, Composite. 
För vart och ett av dessa fyra designmönster, svara på följande frågor:
- [1] Finns det något ställe i er design där ni redan använder detta pattern, avsiktligt eller oavsiktligt? Vilka designproblem löste ni genom att använda det?
- [2] Finns det något ställe där ni kan förbättra er design genom att använda detta design pattern? Vilka designproblem skulle ni lösa genom att använda det? Om inte, varför skulle er design inte förbättras av att använda det?
- [3] Uppdatera er design med de förbättringar ni identifierat.

### Observer pattern
#### [1]
Svar: Vi använder i nuläget inte observer-pattern på något ställe.

#### [2]
Svar: Vi har möjlighet att implementera Observer-pattern. Vi har en klass, View.DrawPanel, som reagerar på att bilarna flyttar på sig. Men istället för att vi explicit säger till att View.DrawPanel ska repaint() bilarna, gör vi att alla klasser som skulle kunna bry sig om att bilarnas positioner uppdateras, eller en krock sker implementerar ett interface. Exempelvis `VehicleListener`.
- 1. Vi skapar Interfacet `VehicleListener` som har en metod, exempelvis `VehicleUpdate`
- 2. Vi gör View.VisualUpdate till en **Observable** - detta innebär att View.VisualUpdate har en lista med alla observers, och när vi vet att Model.CarModel har gjort alla nödvändiga uppdateringar (i vårat fall bara flyttat bilarna och kontrollerat eventuella kollisioner.) så görs ett metodanrop `notifyListeners()` (via en loop). Detta skulle inte nödvändigtvis förkorta våran kod i nuläget, men möjliggör utökning av koden markant.
- 3. Gör så att View.DrawPanel implementerar `VehicleListener`
- 4. Justera View.DrawPanel så att `VehicleUpdate` (från Interfacet) gör det som förväntas, ex 
```java
    @Override
    public void updateVisuals() {
        this.repaint(); 
    }
```

### Factory Pattern
#### [1]
Svar: Vi använder factory methods för att skapa fordon samt miscs, avsiktligt för bådadera. Genom att använda factory i för dessa objekt följer vi DIP och OCP. 
#### [2] 
Svar: Vi upplever att vi inte behöver använda factory methods för de klasser som ej skapas avsiktligt av någon som använder programmet. Alternativet hade varit att ge en större del av programmets klasser factory methods men vi upplever ej att våra klasser är uppbyggda på ett sätt där det hade gjort en markant skillnad. Däremot borde vi se till att konstruktorerna till klasserna som använder factory methods är package private eftersom vi inte vill att de ska kunna instansieras direkt i applikationen.

### State Pattern
#### [1]
Svar: Vi använder ej state i vårat program.
#### [2]
Svar: Genom att använda states för fordon som kan åka in i mechanicshops abstraherar vi den typen av funktionalitet. Just nu skiljer vi knappt på om en bil är i en mechanicshop eller inte, den placeras endast på en viss typ av koordinat och stannar. Genom state pattern hade vi exempelvis kunnat göra så att fordon ej kan röra på¨sig om de är i en "lagrad" state. Genom att implementera dettaa följer vi SIP bättre eftersom vi då avgränsar att ett fordon kan vara "lagrad" till skillnad från programmet idag, som inte avgränsar detta. Dessutom följer detta DIP eftersom det abstraherar de stadierna en bil kan vara i genom ett interface.

### Composite Pattern
#### [1]
Nej Composite Pattern används varken avsiktligt eller oavsiktligt i nuläget.
#### [2]
Vi hittar inte något ställe där det passar i våran applikation. Detta svaret kan ändras om vi skulle få någon konkret utökning i programmet.