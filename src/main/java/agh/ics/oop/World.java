package agh.ics.oop;

/*
 * Task 10
 *   - Interfejs dla klasy Animal oraz Grass pozwoliłby na przechowywanie razem tych dwóch klas w jednej
 *       ArrayList oraz skróciłby implementacje metod isOccupied oraz getMapBounds dla klasy GrassField.
 *       Natomiast problem wystąpiłby w metodzie ObjectAt, gdzie lepszym rozwiązaniem jest rozdzielenie
 *       tych obiektów na dwie listy. Ponieważ mamy do czynienia z dwoma klasami, nie dodawałbym interfejsu
 *       natomiast gdybyśmy rozszerzyli elementy na mapie interfejs jest jak najbardziej elementem do rozważenia.
 * Task 11
 *   - Klasa AbstractWorldMapElement mogłaby przechowywać implmenetacje metody getPosition natomiast
 *      w mojej implementacji nie ma więcej metod, które mają ten sam kod w tych klasach. Dodatkowo
 *      nie widzę więcej cech wspólnych Grass oraz Animal oprócz pozycji na mapie więc w mojej implementacji
 *      klas nie miałoby to większego sensu w używaniu klasy abstrakcyjnej.
 * Task 12
 *  - Usuwanie trawy zostało zaimplementowane w metodzie getMapBounds. Gdybym zaimplementował usuwanie zwierzęcia dla
 *    funkcji objectAt mogłaby wystąpić sytuacja, która usuwa trawę, ale generuje ją w miejscu, gdzie mapa już jest narysowana.
 *    Zatem zdecydowałem się na podejście z gorszą złożonością, ponieważ i tak w labie 6 będziemy korzystać z observerów :)
 * */

/*
 * Ważne informacje
 * - w moim rozwiązaniu zakładam, że zwierzęcie może przejść przez trawę, co wiąże się z
 *   pominięciem sprawdzania w funkcji canMoveTo, czy na pozycji jest trawa. Patrząc pod kątem
 *   świata rzeczywistego, taka sytuacja jest jak najbardziej możliwa, nawet jeśli zwierzę musi
 *   pokonać trawę gatunku: indyjski bambus kolczasty, która może mieć wysokość nawet 37 metrów.
 * */

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
//        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        //  f b r l f f r r f f f f f f f f
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
//        SimulationEngine engine = new SimulationEngine(directions, map, positions);
//        engine.runAnimation();
    }
}