package io.hyman.spring.waiterservice.model;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 18:19
 * @version： 1.0.0
 */
public enum OrderState {

    INIT(0),
    PAID(1),
    BREWING(2),
    BREWED(3),
    TAKEN(4),
    CANCELLED(5);

    private int type;

    private OrderState(int type) {
        this.type = type;
    }

    public static OrderState int2State(int type) {
        OrderState[] states = OrderState.values();
        for (OrderState state : states) {
            if (state.getType() == type) {
                return state;
            }
        }
        return INIT;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }}
