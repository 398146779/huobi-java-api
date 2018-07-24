package com.huobi.api.client.impl;

import com.huobi.api.client.HuobiApiRestClient;
import com.huobi.api.client.HuobiApiService;
import com.huobi.api.client.domain.*;
import com.huobi.api.client.domain.enums.*;
import com.huobi.api.client.domain.resp.RespBody;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import static com.huobi.api.client.HuobiApiServiceGenerator.createService;
import static com.huobi.api.client.HuobiApiServiceGenerator.executeSync;

/**
 * created by jacky. 2018/7/20 8:58 PM
 */
public class HuobiApiRestClientImpl implements HuobiApiRestClient {

    private HuobiApiService service;
    private String apiKey;
    private String apiSecret;

    public HuobiApiRestClientImpl(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        service = createService(HuobiApiService.class, apiKey, apiSecret);
    }


    @Override
    public Set<Candle> kline(String symbol, Resolution period, int size) {
        return executeSync(service.kline(symbol,period.getName(),size)).getData();
    }

    @Override
    public Merged merged(String symbol) {
        return executeSync(service.merged(symbol)).getData();
    }

    @Override
    public Set<Candle> tickers() {
        return executeSync(service.tickers()).getData();
    }

    @Override
    public Depth depth(String symbol, MergeLevel type) {
        return executeSync(service.depth(symbol,type.name())).getData();
    }

    @Override
    public Set<Trade> trade(String symbol) {
        return executeSync(service.trade(symbol)).getTick().getData();
    }

    @Override
    public Trade historyTrade(String symbol, int size) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Candle detail(String symbol) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Set<Symbol> symbols() {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Set<String> currencys() {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Long timestamp() {
        return executeSync(service.timestamp());
    }

    @Override
    public Set<AccountStates> accounts(String id, AccountStates state, AccountType type) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Set<Order> orders(String symbol, List<OrderType> types, String startDate, String endDate, List<OrderState> states, String from, String direct, String size) {


        StringJoiner typeJoiner = new StringJoiner(",");
        for (OrderType type : types) {
            typeJoiner.add(type.getCode());
        }
        StringJoiner stateJoiner = new StringJoiner(",");
        for (OrderState state : states) {

            stateJoiner.add(state.getCode());
        }
        return executeSync(service.orders(symbol, typeJoiner.toString(), startDate, endDate, stateJoiner.toString(), from, direct, size)).getData();
    }

    @Override
    public Set<Order> orders(String symbol, OrderState status) {
        RespBody<Set<Order>> resp = executeSync(service.orders(symbol, null, null, null, status.getCode(), null, null, null));
        return resp.getData();
    }

    @Override
    public Account balance(String accountId) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Long place(String accountId, String amount, String price, OrderSource source, String symbol, OrderType type) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Set<Order> openOrders(String accountId, String symbol, OrderSide side, int size) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Order get(String orderId) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Long cancel(String orderId) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Set<Order> matchresults(String orderId) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }

    @Override
    public Set<Order> marginBalance(String symbol) {
        throw new RuntimeException("not impl yet!"); //TODO impl.
    }



}
