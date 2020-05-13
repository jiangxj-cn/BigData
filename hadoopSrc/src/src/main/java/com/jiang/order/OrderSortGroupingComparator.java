package com.jiang.order;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class OrderSortGroupingComparator extends WritableComparator {

    public OrderSortGroupingComparator() {
        super(OrderBean.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderBean aBean = (OrderBean) a;
        OrderBean bBean = (OrderBean) b;
        int result;
        if (aBean.getOrderID() > bBean.getOrderID()) {
            result = 1;
        } else if (aBean.getOrderID() < bBean.getOrderID()) {
            result = -1;
        } else {
            result = 0;
        }
        return result;
    }
}
