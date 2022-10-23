package agh.ics.oop;

/*
Odpowiednie testy integracyjne znajdują się w plikach AnimalTest oraz OptionsParserTest w folderze test.

Task 10
Odpowiedz na pytanie: jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu.

Przykładowo, możemy dodać do klasy Animal statyczną i finalną (static final) HashMapę, gdzie kluczem będzie krotka ze współrzędnymi.
Krotka może być np. w formacie stringa lub też możemy zaimplementować własną klasę imitującą krotkę. Następnie, gdy zwierze
będzie korzystało z funkcji .move() najpierw będzie trzeba sprawdzić, czy nowe pole nie jest zajęte przez inne zwierzę.
Gdy nie, to z HashMapy usuwany jest klucz ze starym polem i tworzony jest nowy wpis z nową pozycją, że jest zajęta.

Drugą możliwością, ze względu na małą planszę, jest zastąpienie HashMapy tablicą 5x5 typu boolean, gdzie wartość true
będzie oznaczać, że znajduje się tam zwierzę, a false, że pole jest puste.

*/

public class World {
    public static void main(String[] args) {
        // Task 3
        Animal testAnimal = new Animal();
        System.out.println(testAnimal.toString());

        // Task 5
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        System.out.println(testAnimal.toString());

        // Task 7
        OptionsParser parser = new OptionsParser();
        MoveDirection[] directions = parser.parse(args);

        // Task 8
        testAnimal = new Animal();
        System.out.println(testAnimal.toString());

        for (MoveDirection direction : directions) {
            testAnimal.move(direction);
            System.out.println(testAnimal.toString());
        }

    }
}
