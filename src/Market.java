import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    private List<Actor> queue;
    private List<Actor> marketActors;

    public Market() {
        this.queue = new ArrayList<>();
        this.marketActors = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        if (!queue.contains(actor)) {
            queue.add(actor);
            System.out.println(actor.getName() + " has joined the queue.");
        } else {
            System.out.println(actor.getName() + " is already in the queue.");
        }
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            if (queue.contains(actor)) {
                queue.remove(actor);
                marketActors.add(actor);
                System.out.println(actor.getName() + " has entered the market.");
            } else {
                System.out.println(actor.getName() + " is not in the queue.");
            }
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
    }

    @Override
    public void takeInQueue(Actor actor) {
        acceptToMarket(actor);
    }

    @Override
    public void takeOrders() {
        // Logic to take orders from actors in the market
        System.out.println("Taking orders from actors in the market.");
    }

    @Override
    public void giveOrders() {
        // Logic to give orders to actors in the market
        System.out.println("Giving orders to actors in the market.");
    }

    @Override
    public void releaseFromQueue() {
        if (!queue.isEmpty()) {
            Actor actor = queue.remove(0);
            System.out.println(actor.getName() + " has left the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }
}