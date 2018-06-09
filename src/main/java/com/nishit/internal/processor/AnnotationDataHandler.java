package com.nishit.internal.processor;

import com.nishit.external.Annotations.ColumnHeader;
import com.nishit.external.Annotations.ColumnOrder;
import com.nishit.internal.Model.OrderFieldModel;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AnnotationDataHandler {


    public static PriorityQueue<OrderFieldModel> processAnotations(Object object) {

        PriorityQueue<OrderFieldModel> pq = null;

        try {
            Class<?> objectClass = object.getClass();

            pq = new
                    PriorityQueue<OrderFieldModel>(objectClass.getDeclaredFields().length, new OrderOfFieldsComparator());

            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ColumnHeader.class)) {
                    if (field.isAnnotationPresent(ColumnOrder.class)) {
                        ColumnOrder order = field.getAnnotation(ColumnOrder.class);
                        int value=Integer.parseInt(order.value());

                        OrderFieldModel ordFObj = new OrderFieldModel();
                        ordFObj.setOrder(value);
                        ordFObj.setObject(field.get(object));
                        pq.add(ordFObj);

                    } else {
                        OrderFieldModel ordFObj = new OrderFieldModel();
                        ordFObj.setOrder(9999);
                        ordFObj.setObject(field.get(object));
                        pq.add(ordFObj);
                    }
                }
            }

        } catch (Exception e) {

        }

        return pq;

    }
}
