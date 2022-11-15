package agh.ics.oop;

/*
 * Task 3
 * - Zbiory dla osi OX oraz OY są obiektami klasy TreeMap. Dlaczego nie TreeSet?
 *   Gdy na danej pozycji np. x jest więcej niż jeden obiekt, możemy zapisać sobie liczbę
 *   obiektów w danym punkcie. Gdy usuwamy obiekt z danej pozycji, odejmujemy liczbę obiektów
 *   jednocześnie nie usuwając pozycji z uporządkowanego zbioru.
 *   Gdybyśmy chcieli przechowywać obiekty typu Animal, to niestety gdyby użyta została metoda .move()
 *   to hash TreeMap/TreeSet nie zostałby zmieniony i zapamiętany byłby stan zwierzęcia sprzed użycia metody.
 *   Dobrym rozwiązaniem jest użycie Vector2d, tak jak w HashMapach dla obiektów klas Grass oraz Animal.
 * */


/*
 * Uwaga: teraz przy dodawaniu zwierzaka na pole gdzie znajduje się trawa jest niemożliwe.
 *        Możliwe jest, że program może wyrzucić wyjątek, lecz ponowne uruchomienie powinno
 *        naprawić problem. Aby zmienić zachowanie należy odkomentować linię w metodzie place
 *        w klasie AbstractWorldMap. (poprawka: już błąd powinien być naprawiony)
 *
 * Uwaga 2: w App linie mapy są napisane jako styl w css (dla poznania javafx) oraz wielkość sceny jest
 *          obliczania dynamicznie.
 * */

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);

//            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new GrassField(10);
//            // IWorldMap map = new RectangularMap(10, 5);
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//            //  Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
//            // f b r l f f r r f f f f f f f f
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//            // SimulationEngine engine = new SimulationEngine(directions, map, positions);
//            // engine.runAnimation();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
