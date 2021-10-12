package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.model.enums.OrderSide;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

import static com.binance.client.model.enums.OrderType.*;

@Getter
@Setter
public class Order {

    private String clientOrderId;

    private BigDecimal cumQuote;

    private BigDecimal executedQty;

    private Long orderId;

    private BigDecimal origQty;

    private BigDecimal price;

    private Boolean reduceOnly;

    private String side;

    private String positionSide;

    private String status;

    private BigDecimal stopPrice;

    private String symbol;

    private String timeInForce;

    private String type;

    private Long updateTime;

    private String workingType;

    public OrderSide getOrderSideEnum() {
        if (OrderSide.SELL.getCode().equals(side)) {
            return OrderSide.SELL;
        } else if (OrderSide.BUY.getCode().equals(side)) {
            return OrderSide.BUY;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public OrderSide getOrderOppositeSideEnum() {
        if (OrderSide.SELL.getCode().equals(side)) {
            return OrderSide.BUY;
        } else if (OrderSide.BUY.getCode().equals(side)) {
            return OrderSide.SELL;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isStopMarket() {
        return STOP_MARKET.getCode().equals(type);
    }

    public boolean isLimit() {
        return LIMIT.getCode().equals(type);
    }

    public boolean isTrailingStopMarket() {
        return TRAILING_STOP_MARKET.getCode().equals(type);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("clientOrderId", clientOrderId).append("cumQuote", cumQuote).append("executedQty", executedQty)
                .append("orderId", orderId).append("origQty", origQty).append("price", price)
                .append("reduceOnly", reduceOnly).append("side", side).append("positionSide", positionSide).append("status", status)
                .append("stopPrice", stopPrice).append("symbol", symbol).append("timeInForce", timeInForce)
                .append("type", type).append("updateTime", updateTime).append("workingType", workingType).toString();
    }
}
