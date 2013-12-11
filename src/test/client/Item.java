package test.client;

public class Item {
	private String name;

    public Item() {
        setName("");
    }
    
    public Item(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
