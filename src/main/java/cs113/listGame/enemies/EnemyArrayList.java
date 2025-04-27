package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import cs113.listGame.resources.ResourceObject;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Random;

public class EnemyArrayList extends EnemyObject {
    // Use an ArrayList to store behaviors instead of an array
    ArrayList<Behavior> behaviors = new ArrayList<>();
    Random random = new Random();

    public EnemyArrayList(ImageView imageView) {
        super(imageView);
    }

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(random.nextDouble() * 500, random.nextDouble() * 400);

        // Adding behaviors to the ArrayList
        behaviors.add(new Waiting(this, 3000));
        behaviors.add(new MoveToPoint(this, 4000, dest));
    }

    @Override
    public Behavior getNextBehavior() {
        if (behaviors.isEmpty()) return null;

        int index = random.nextInt(behaviors.size());
        Behavior behavior = behaviors.get(index);

        // Remove the behavior from the list after it is chosen
        behaviors.remove(index);

        return behavior;
    }
}