package automation.constans;

public enum EnumPrice {
    LowToHighPrice("lohi"),
    HighToLowPrice("hilo"),
    NameAz("az"),
    NameZa("za");
    private final String sort;


    EnumPrice(String sort) {
        this.sort = sort;
    }
}
