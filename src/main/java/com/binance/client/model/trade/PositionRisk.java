package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.model.enums.OrderSide;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

@Getter
@Setter
public class PositionRisk {

    private BigDecimal entryPrice;

    private BigDecimal leverage;

    private Double maxNotionalValue;

    private BigDecimal liquidationPrice;

    private BigDecimal markPrice;

    private BigDecimal positionAmt;

    private String symbol;

    private BigDecimal isolatedMargin;

    private String positionSide;

    private String marginType;

    private BigDecimal unrealizedProfit;

    private OrderSide orderSide;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("entryPrice", entryPrice)
                .append("leverage", leverage).append("maxNotionalValue", maxNotionalValue)
                .append("liquidationPrice", liquidationPrice).append("markPrice", markPrice)
                .append("positionAmt", positionAmt).append("symbol", symbol)
                .append("unrealizedProfit", unrealizedProfit).append("isolatedMargin", isolatedMargin)
                .append("positionSide", positionSide).append("marginType", marginType).toString();
    }

    public PositionRisk setOrderTypeAndReturn(OrderSide orderSide) {
        this.orderSide = orderSide;
        return this;
    }

    public OrderSide getOppositeOrderSide() {
        switch (orderSide) {
            case BUY:
                return OrderSide.SELL;
            case SELL:
                return OrderSide.BUY;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean isLiquidationPossible(BigDecimal reduceOnlyPrice) {
        switch (orderSide) {
            case BUY: return getLiquidationPrice().compareTo(reduceOnlyPrice) > 0;
            case SELL: return getLiquidationPrice().compareTo(reduceOnlyPrice) < 0;
            default: throw new IllegalArgumentException();
        }
    }
}
