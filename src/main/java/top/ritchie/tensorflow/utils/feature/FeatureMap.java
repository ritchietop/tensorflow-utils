package top.ritchie.tensorflow.utils.feature;

import org.tensorflow.example.Feature;
import org.tensorflow.example.Features;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ritchie.top
 */

public class FeatureMap {

    private Map<String, Feature> map;

    public FeatureMap(int volume) {
        this.map = new HashMap<>(volume);
    }

    public void put(String key, Feature value) {
        if (key != null && value != null) {
            this.map.put(key, value);
        }
    }

    public Features features() {
        return Features.newBuilder().putAllFeature(this.map).build();
    }

}
