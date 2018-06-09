package com.nishit.internal.processor;

import com.nishit.internal.Model.OrderFieldModel;

import java.util.Comparator;

public class OrderOfFieldsComparator implements Comparator<OrderFieldModel> {

    // Overriding compare()method of Comparator

    public int compare(OrderFieldModel o1, OrderFieldModel o2) {
        if (o1.getOrder() > o2.getOrder())
            return 1;
        return -1;
    }
}