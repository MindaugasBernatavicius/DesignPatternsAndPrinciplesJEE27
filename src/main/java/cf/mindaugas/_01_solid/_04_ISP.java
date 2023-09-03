package cf.mindaugas._01_solid;

public class _04_ISP {
}

interface Collection {
    void init();
    void get();
    void add();
    void addSeveral();
    void remove();
    void removeAll();
}

interface ReadOnlyCollection {
    void init();
    void get();
}

interface MutableCollection {
    void add();
    void addSeveral();
    void remove();
    void removeAll();
}

class ImmutableList implements ReadOnlyCollection {

    @Override
    public void init() {

    }

    @Override
    public void get() {

    }
}
class List implements ReadOnlyCollection, MutableCollection {
    @Override
    public void init() {

    }

    @Override
    public void get() {

    }

    @Override
    public void add() {

    }

    @Override
    public void addSeveral() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void removeAll() {

    }
}