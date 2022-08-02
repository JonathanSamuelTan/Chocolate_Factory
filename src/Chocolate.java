class Chocolate {
    private String name;
    private String type;
    private int price;
    private String id;

    Chocolate(String Name, String Type, int Price, String Id) {
        name = Name;
        type = Type;
        price = Price;
        id = Id;
    }

    public void setId(String Id) {
        this.id = Id;
    }
    
    public void setPrice(int Price) {
        this.price = Price;
    }
    
    public void setType(String Type) {
        this.type = Type;
    }
    
    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public String getId() {
        return this.id;
    }
}
