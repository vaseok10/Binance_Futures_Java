package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.model.enums.OrderSide;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

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

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public BigDecimal getLeverage() {
        return leverage;
    }

    public void setLeverage(BigDecimal leverage) {
        this.leverage = leverage;
    }

    public Double getMaxNotionalValue() {
        return maxNotionalValue;
    }

    public void setMaxNotionalValue(Double maxNotionalValue) {
        this.maxNotionalValue = maxNotionalValue;
    }

    public BigDecimal getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(BigDecimal liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public BigDecimal getPositionAmt() {
        return positionAmt;
    }

    public void setPositionAmt(BigDecimal positionAmt) {
        this.positionAmt = positionAmt;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(BigDecimal unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public BigDecimal getIsolatedMargin() {
        return isolatedMargin;
    }

    public void setIsolatedMargin(BigDecimal isolatedMargin) {
        this.isolatedMargin = isolatedMargin;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public String getMarginType() {
        return marginType;
    }

    public void setMarginType(String marginType) {
        this.marginType = marginType;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("entryPrice", entryPrice)
                .append("leverage", leverage).append("maxNotionalValue", maxNotionalValue)
                .append("liquidationPrice", liquidationPrice).append("markPrice", markPrice)
                .append("positionAmt", positionAmt).append("symbol", symbol)
                .append("unrealizedProfit", unrealizedProfit).append("isolatedMargin", isolatedMargin)
                .append("positionSide", positionSide).append("marginType", marginType).toString();
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
