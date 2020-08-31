package pattern.status.customize;

public enum CommodityStatus {

    /**
     * 空闲
     */
    FREE(1, "空闲"),

    /**
     * 下单
     */
    ORDER(2, "下单"),

    /**
     * 支付
     */
    PAID(3, "支付");


    private Integer value;

    private String desc;

    CommodityStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return this.value;
    }

}
