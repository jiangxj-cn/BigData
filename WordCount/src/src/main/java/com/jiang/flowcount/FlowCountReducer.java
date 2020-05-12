package com.jiang.flowcount;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowCountReducer extends Reducer<Text,FlowBean, Text,FlowBean> {

    FlowBean v = new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long sum_upFlow =0;
        long sum_downFlow=0;

        for(FlowBean value : values){
            sum_upFlow += value.getUpFlow();
            sum_downFlow += value.getDownFlow();
        }

        v = new FlowBean(sum_upFlow,sum_downFlow);
        context.write(key,v);
    }
}
