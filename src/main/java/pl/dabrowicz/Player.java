package pl.dabrowicz;

public class Player {
    private String name;
    private ElementType element;

    public Player(){
    }

    public Player (String name, ElementType element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementType getElement() {
        return element;
    }

    public void setElement(ElementType element) {
        this.element = element;
    }

    public String displayPlayer() {
        return name + ", " + element;
    }

    @Override
    public String toString() {
        return String.format(name, element);
    }
}
