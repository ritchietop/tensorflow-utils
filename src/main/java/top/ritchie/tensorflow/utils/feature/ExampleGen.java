package top.ritchie.tensorflow.utils.feature;

import org.tensorflow.example.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ritchie.top
 */

public class ExampleGen {

    private Map<String, Feature> features;
    private Map<String, FeatureList> featureLists;

    public ExampleGen(int featureVolume) {
        this.features = new HashMap<>(featureVolume);
        this.featureLists = null;
    }

    public ExampleGen(int featureVolume, int sequenceFeatureVolume) {
        this.features = new HashMap<>(featureVolume);
        this.featureLists = new HashMap<>(sequenceFeatureVolume);
    }

    public ExampleGen put(String key, Feature value) {
        if (key != null && value != null) {
            this.features.put(key, value);
        }
        return this;
    }

    public ExampleGen put(String key, FeatureList value) {
        if (this.featureLists == null) {
            throw new NullPointerException("please use ExampleGen(int featureVolume, int sequenceFeatureVolume) init.");
        }
        if (key != null && value != null) {
            this.featureLists.put(key, value);
        }
        return this;
    }

    public Features genFeatures() {
        if (this.features == null || this.features.isEmpty()) {
            return Features.newBuilder().build();
        } else {
            return Features.newBuilder().putAllFeature(this.features).build();
        }
    }

    public FeatureLists genFeatureLists() {
        if (this.featureLists == null || this.featureLists.isEmpty()) {
            return FeatureLists.newBuilder().build();
        } else {
            return FeatureLists.newBuilder().putAllFeatureList(this.featureLists).build();
        }
    }

    public static Example toExample(Features... features) {
        Example.Builder example = Example.newBuilder();
        for (Features feature : features) {
            example.mergeFeatures(feature);
        }
        return example.build();
    }

    public static SequenceExample toSequenceExample(FeatureLists... featureLists) {
        SequenceExample.Builder sequenceExample = SequenceExample.newBuilder();
        for (FeatureLists featureList : featureLists) {
            sequenceExample.mergeFeatureLists(featureList);
        }
        return sequenceExample.build();
    }

}
