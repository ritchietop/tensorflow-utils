package top.ritchie.tensorflow.utils.feature;

import com.google.protobuf.ByteString;
import org.tensorflow.example.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ritchie.top
 */

public class FeatureUtils {

    public static Feature int64ListFeature(long... values) {
        if (values == null || values.length == 0) {
            return null;
        } else {
            List<Long> longValues = new ArrayList<>();
            for (long value : values) {
                longValues.add(value);
            }
            return int64ListFeature(longValues);
        }
    }

    public static Feature int64ListFeature(Iterable<Long> values) {
        if (values == null) {
            return null;
        } else {
            Int64List int64List = Int64List.newBuilder().addAllValue(values).build();
            return Feature.newBuilder().setInt64List(int64List).build();
        }
    }

    public static Feature floatListFeature(float... values) {
        if (values == null || values.length == 0) {
            return null;
        } else {
            List<Float> floatValues = new ArrayList<>();
            for (float value : values) {
                floatValues.add(value);
            }
            return floatListFeature(floatValues);
        }
    }

    public static Feature floatListFeature(double... values) {
        if (values == null || values.length == 0) {
            return null;
        } else {
            List<Float> floatValues = new ArrayList<>();
            for (double value : values) {
                floatValues.add((float) value);
            }
            return floatListFeature(floatValues);
        }
    }

    public static Feature floatListFeature(Iterable<Float> values) {
        if (values == null) {
            return null;
        } else {
            FloatList floatList = FloatList.newBuilder().addAllValue(values).build();
            return Feature.newBuilder().setFloatList(floatList).build();
        }
    }

    public static Feature byteStringFeature(String... values) {
        if (values == null || values.length == 0) {
            return null;
        } else {
            List<ByteString> bytesStringList = new ArrayList<>();
            for (String value : values) {
                if (value != null) {
                    bytesStringList.add(ByteString.copyFromUtf8(value));
                }
            }
            if (bytesStringList.size() == 0) {
                return null;
            } else {
                BytesList bytesList = BytesList.newBuilder().addAllValue(bytesStringList).build();
                return Feature.newBuilder().setBytesList(bytesList).build();
            }
        }
    }

    public static Feature byteStringFeature(Iterable<String> values) {
        if (values == null) {
            return null;
        }
        List<ByteString> bytesStringList = new ArrayList<>();
        for (String value : values) {
            if (value != null) {
                bytesStringList.add(ByteString.copyFromUtf8(value));
            }
        }
        if (bytesStringList.size() == 0) {
            return null;
        } else {
            BytesList bytesList = BytesList.newBuilder().addAllValue(bytesStringList).build();
            return Feature.newBuilder().setBytesList(bytesList).build();
        }
    }

    public static FeatureList toFeatureList(Feature... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        List<Feature> features = new ArrayList<>();
        for (Feature value : values) {
            if (value != null) {
                features.add(value);
            }
        }
        if (features.size() == 0) {
            return null;
        } else {
            return FeatureList.newBuilder().addAllFeature(features).build();
        }
    }

}
