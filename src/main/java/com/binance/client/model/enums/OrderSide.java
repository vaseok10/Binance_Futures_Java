package com.binance.client.model.enums;

import lombok.Getter;

/**
 * buy, sell, both.
 */

@Getter
public enum OrderSide {
  BUY("BUY"),
  SELL("SELL");

  private final String code;

  OrderSide(String side) {
    this.code = side;
  }

  @Override
  public String toString() {
    return code;
  }

  public OrderSide getOppositeOrderSide() {
    switch (this) {
      case SELL: return BUY;
      case BUY: return SELL;
      default: throw new IllegalArgumentException();
    }
  }

}