import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры актеров
        Actor john = new Human();
        john.name = "Джон";

        Actor mary = new Human();
        mary.name = "Мэри";

        // Создаем экземпляр магазина
        Market market = new Market();

        // Актеры присоединяются к очереди в магазине
        market.acceptToMarket(john);
        market.acceptToMarket(mary);

        // Магазин обновляет свое состояние
        market.update();

        // Актеры освобождаются из очереди и входят в магазин
        market.releaseFromMarket(List.of(john, mary));

        // Магазин обновляет свое состояние снова
        market.update();

        // Актер покидает магазин
        market.releaseFromQueue();
    }
}
