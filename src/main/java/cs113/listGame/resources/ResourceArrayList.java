package cs113.listGame.resources;
import java.util.ArrayList;

import cs113.listGame.gamecore.GameObject;


public class ResourceArrayList implements ResourceList {

    ArrayList<ResourceObject> resources = new ArrayList(4);

    @Override

    public void add(ResourceObject resource) {
        if (contains(resource)) {
            return;
        } // gotcha moment, don't add it twice!

        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) == null) {
                resources.set(i, resource);
                return;
            }
        }
    }

    private boolean contains(ResourceObject resource) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) == resource) return true;
        }
        return false;
    }

    @Override
    public void remove(ResourceObject resource) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) == resource) {
                resources.set(i, null);
            }
        }


    }
    @Override
    public void truncate(ResourceObject resource){
        boolean found = false;
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) == resource) {
                found = true;
            }
            if (found) {
                resources.set(i, null);
            }
        }

    }

    @Override
    public void follow (GameObject leader){
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null) {
                resources.get(i).moveTowards(leader.getEchoCenter());
                leader = resources.get(i);
            }
        }
    }
}
