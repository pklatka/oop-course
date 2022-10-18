package agh.ics.oop;

/*
Odpowiednie testy integracyjne znajdują się w plikach AnimalTest oraz OptionsParserTest w folderze test.

Task 10
Odpowiedz na pytanie: jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu.

Przykładowo możemy zaimplementować/użyć strukturę HashMap, gdzie kluczem będzie krotka ze współrzędnymi. Obiekt krotki
możemy zaimplementować sami, pamiętając o zmodyfikowaniu funkcji hashCode() aby klucz został poprawnie zhashowany.
Następnie gdy dane zwierzę osiągnie dany punkt, będziemy tworzyć nowy wpis, składający się z klucza krotki nowego pola,
pamiętając o usunięciu wpisu z kluczem pozycji, na której zwierzę wcześniej się znajdowało. Za każdym razem, gdy
będziemy wywoływać funkcję .move() będzie trzeba sprawdzić, czy istnieje w HashMap-ie klucz o nowej pozycji.

Drugą możliwością, ze względu na małą planszę, jest stworzenie tablicy 5x5 typu boolean, gdzie wartość true będzie
oznaczać, że znajduje się tam zwierzę, a false, że pole jest puste. Gdy będziemy wywoływać .move() będzie trzeba
sprawdzić, czy nowa pozycja nie ma przypadkiem wartości true. Jeżeli nie to usuwamy wartość true ze starego pola i
ustawiamy wartość true na nowe pole.
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
