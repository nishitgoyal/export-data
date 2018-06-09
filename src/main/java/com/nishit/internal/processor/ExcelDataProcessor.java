package com.nishit.internal.processor;

import com.nishit.external.Annotations.ColumnHeader;
import com.nishit.external.Annotations.ColumnOrder;
import com.nishit.internal.Model.OrderFieldModel;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ExcelDataProcessor {

    public static PriorityQueue<OrderFieldModel> getHeaders(Object object) {
        PriorityQueue<OrderFieldModel> pq = null;
        try {
            Class<?> objectClass = object.getClass();
            pq = new
                    PriorityQueue<OrderFieldModel>(objectClass.getDeclaredFields().length, new OrderOfFieldsComparator());

            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ColumnHeader.class)) {
                    ColumnHeader header = field.getAnnotation(ColumnHeader.class);
                    String headerValue = header.value();
                    if (field.isAnnotationPresent(ColumnOrder.class)) {
                        ColumnOrder order = field.getAnnotation(ColumnOrder.class);
                        int orderValue = Integer.parseInt(order.value());
                        OrderFieldModel ordFObj = new OrderFieldModel();
                        ordFObj.setOrder(orderValue);
                        ordFObj.setObject(headerValue);
                        pq.add(ordFObj);
                    } else {
                        OrderFieldModel ordFObj = new OrderFieldModel();
                        ordFObj.setOrder(9999);
                        ordFObj.setObject(headerValue);
                        pq.add(ordFObj);
                    }
                }
            }

        } catch (Exception e) {

        }
        return pq;
    }
}



