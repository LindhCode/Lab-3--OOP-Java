# Laboration 4 diskussioner

## Uppgift 2: Model-View-Controller
### Brister från utsprungliga användargränssnittet(Början av lab3)

Huvudsak: 
- Vi ser att CarController i huvudsak kommer att agera som en **Model**. Med det sagt så finns det uppenbara brister som följer nedan. 
- Vi identifierar CarView som huvudsak en **Controller**
- Samt DrawPanel som **view**

Problematik:
- CarController innehåller ett objekt av CarView, detta gör "Modellen" beroende av Controllern, vilket motstrider modellprinciperna.
- CarController använder metoden moveit(), vilket skapar ett beroende mellan **Modellen** och **Vyn**. 
- Att bilobjekten hanteras i samma Datasamling som bilderna och bildernas *Points* bryter mot MVC, eftersom bilarna ska kunna användas av olika grafiska gränssnitt - vilket inte är möjligt i nuläget pga att de binds till den grafiska representationen - JFrame
- Vi hade ingen *Applikation* som vi körde programmet med.

### Vilka av dessa brister åtgärdade ni med er nya design från del 3? Hur då? Vilka brister åtgärdade ni inte?
Lösta brister:
- Vi bryter ut den visuella delen ur CarController, separerar den till en vy, som är beroende av modellen, men modellen är inte beroende av den grafiska represenationen - vilket uppfyller MVC-principerna.
- En Applikationsklass har skapats `Main.java`, detta möjliggör applikationsspecifik kod om behovet för det finns i framtiden.
- En lösning har skapats för att hantera moveIt()s position. Denna ligger numera i VisualUpdate-klassen, som hanterar all vy (som tidigare låg i CarController)

Olösta brister:
- Just nu har vi klassen VehicleData - som gör att Modellen är beroende av Vyn. Våran föreslagna lösning är att VehicleData är något som specifikt används specifikt för Vyn, medan vi har en klass `InternalVehicle` eller motsvarande som används i modellen, för att sedan knytas ihop i vyn.

### 


