package top.ritchie.tensorflow.utils.feature;

import org.tensorflow.example.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ritchie.top
 */

public class TFRecordGen {

    private Map<String, Feature> features;
    private Map<String, FeatureList> featureLists;

    public TFRecordGen(int featureVolume) {
        this.features = new HashMap<>(featureVolume);
        this.featureLists = null;
    }

    public TFRecordGen(int featureVolume, int sequenceFeatureVolume) {
        this.features = new HashMap<>(featureVolume);
        this.featureLists = new HashMap<>(sequenceFeatureVolume);
    }

    public TFRecordGen put(String key, Feature value) {
        if (key != null && value != null) {
            this.features.put(key, value);
        }
        return this;
    }

    public TFRecordGen put(String key, FeatureList value) {
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

    public Example genExample() {
        Example.Builder exampleBuilder = Example.newBuilder();
        if (!this.features.isEmpty()) {
            exampleBuilder.setFeatures(this.genFeatures());
        }
        return exampleBuilder.build();
    }

    public SequenceExample genSequenceExample() {
        SequenceExample.Builder sequenceExampleBuilder = SequenceExample.newBuilder();
        if (!this.features.isEmpty()) {
            sequenceExampleBuilder.setContext(this.genFeatures());
        }
        if (!this.featureLists.isEmpty()) {
            sequenceExampleBuilder.setFeatureLists(this.genFeatureLists());
        }
        return sequenceExampleBuilder.build();
    }

    public static Example toExample(Features... features) {
        Example.Builder exampleBuilder = Example.newBuilder();
        for (Features feature : features) {
            exampleBuilder.mergeFeatures(feature);
        }
        return exampleBuilder.build();
    }

    public static Example toExample(Iterable<Features> featuresIterable) {
        Example.Builder exampleBuilder = Example.newBuilder();
        for (Features feature : featuresIterable) {
            exampleBuilder.mergeFeatures(feature);
        }
        return exampleBuilder.build();
    }

    public static SequenceExample toSequenceExample(FeatureLists... featureLists) {
        SequenceExample.Builder sequenceExampleBuilder = SequenceExample.newBuilder();
        for (FeatureLists featureList : featureLists) {
            sequenceExampleBuilder.mergeFeatureLists(featureList);
        }
        return sequenceExampleBuilder.build();
    }

    public static SequenceExample toSequenceExample(Iterable<FeatureLists> featureListsIterable) {
        SequenceExample.Builder sequenceExampleBuilder = SequenceExample.newBuilder();
        for (FeatureLists featureList : featureListsIterable) {
            sequenceExampleBuilder.mergeFeatureLists(featureList);
        }
        return sequenceExampleBuilder.build();
    }

    public static SequenceExample toSequenceExample(Iterable<Features> featuresIterable,
                                                    Iterable<FeatureLists> featureListsIterable) {
        SequenceExample.Builder sequenceExampleBuilder = SequenceExample.newBuilder();
        for (Features features : featuresIterable) {
            sequenceExampleBuilder.mergeContext(features);
        }
        for (FeatureLists featureList : featureListsIterable) {
            sequenceExampleBuilder.mergeFeatureLists(featureList);
        }
        return sequenceExampleBuilder.build();
    }

}
