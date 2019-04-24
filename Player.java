public class Player {
    private String name;
    private String sign;

    public Player () {
        this(null,null);
    }

    public Player (String name, String sign) {
        this.name = name;
        this.sign = sign;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName () {
        return name;
    }

    public String getSign () {
        return sign;
    }
}