package top.ritchie.tensorflow.utils.feature;

import org.tensorflow.example.Example;
import org.tensorflow.example.Features;


/**
 * @author ritchie.top
 */

public class ExampleUtils {

    public static Example toExample(Features... features) {
        Example.Builder example = Example.newBuilder();
        for (Features feature : features) {
            example.mergeFeatures(feature);
        }
        return example.build();
    }

}
