package com.binance.client.model.market;

import com.binance.client.constant.BinanceApiConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
public class Candlestick {

    private Long openTime;

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal close;

    private BigDecimal volume;

    private Long closeTime;

    private BigDecimal quoteAssetVolume;

    private Integer numTrades;

    private BigDecimal takerBuyBaseAssetVolume;

    private BigDecimal takerBuyQuoteAssetVolume;

    private BigDecimal ignore;

    private LocalDateTime openLocalDateTime;

    private LocalDateTime closeLocalDateTime;

    public Candlestick(String openTime, String open, String high, String low, String close, String volume, String closeTime, String quoteAssetVolume, String numTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume, String ignore) {
        final ZoneId zone = ZoneId.of("Europe/Moscow");
        this.openLocalDateTime = Instant.ofEpochMilli(Long.parseLong(openTime)).atZone(zone).toLocalDateTime();
        this.open = new BigDecimal(open);
        this.high = new BigDecimal(high);
        this.low = new BigDecimal(low);
        this.close = new BigDecimal(close);
        this.volume = new BigDecimal(volume);
        this.closeLocalDateTime = Instant.ofEpochMilli(Long.parseLong(closeTime)).atZone(zone).toLocalDateTime();
        this.quoteAssetVolume = new BigDecimal(quoteAssetVolume);
        this.numTrades = Integer.parseInt(numTrades);
        this.takerBuyBaseAssetVolume = new BigDecimal(takerBuyBaseAssetVolume);
        this.takerBuyQuoteAssetVolume = new BigDecimal(takerBuyQuoteAssetVolume);
        this.ignore = new BigDecimal(ignore);
    }

    public void convertTime() {
        final ZoneId zone = ZoneId.of("Europe/Moscow");
        this.openLocalDateTime = Instant.ofEpochMilli(openTime).atZone(zone).toLocalDateTime();
        this.closeLocalDateTime = Instant.ofEpochMilli(closeTime).atZone(zone).toLocalDateTime();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("openTime", openTime)
                .append("open", open).append("high", high).append("low", low).append("close", close)
                .append("volume", volume).append("closeTime", closeTime).append("quoteAssetVolume", quoteAssetVolume)
                .append("numTrades", numTrades).append("takerBuyBaseAssetVolume", takerBuyBaseAssetVolume)
                .append("takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume).append("ignore", ignore).toString();
    }
}
