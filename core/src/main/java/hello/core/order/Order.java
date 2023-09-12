package hello.core.order;

public class Order {
    private Long memberId;
    private String name;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String name, int itemPrice,int discountPrice) {
        this.memberId = memberId;
        this.name = name;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemPrice - discountPrice;
    }
    public Long getmemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getitemPrice() {
        return itemPrice;
    }

    public void setmemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void etName(String name) {
        this.name = name;
    }

    public void setitemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
