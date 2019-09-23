package top.ritchie.tensorflow.utils.feature;

import org.tensorflow.example.Feature;
import org.tensorflow.example.Features;

import javax.annotation.Nonnull;
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

    public void put(@Nonnull String key, @Nonnull Feature value) {
        this.map.put(key, value);
    }

    public Features features() {
        return Features.newBuilder().putAllFeature(this.map).build();
    }

}
