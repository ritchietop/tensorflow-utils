package top.ritchie.tensorflow.utils.feature;

import com.google.protobuf.ByteString;
import org.tensorflow.example.BytesList;
import org.tensorflow.example.Feature;
import org.tensorflow.example.FloatList;
import org.tensorflow.example.Int64List;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ritchie.top
 */

public class FeatureUtils {

    public static Feature int64ListFeature(@Nonnull long... values) {
        Long[] longValues = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
            longValues[i] = values[i];
        }
        Iterable<Long> intIter = Arrays.asList(longValues);
        Int64List int64List = Int64List.newBuilder().addAllValue(intIter).build();
        return Feature.newBuilder().setInt64List(int64List).build();
    }

    public static Feature int64ListFeature(@Nonnull Iterable<Long> values) {
        Int64List int64List = Int64List.newBuilder().addAllValue(values).build();
        return Feature.newBuilder().setInt64List(int64List).build();
    }

    public static Feature floatListFeature(@Nonnull float... values) {
        Float[] floatValues = new Float[values.length];
        for (int i = 0; i < values.length; i++) {
            floatValues[i] = values[i];
        }
        Iterable<Float> floatIter = Arrays.asList(floatValues);
        FloatList floatList = FloatList.newBuilder().addAllValue(floatIter).build();
        return Feature.newBuilder().setFloatList(floatList).build();
    }

    public static Feature floatListFeature(@Nonnull double... values) {
        float[] floatValues = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            floatValues[i] = (float) values[i];
        }
        return floatListFeature(floatValues);
    }

    public static Feature floatListFeature(@Nonnull Iterable<Float> values) {
        FloatList floatList = FloatList.newBuilder().addAllValue(values).build();
        return Feature.newBuilder().setFloatList(floatList).build();
    }

    public static Feature byteStringFeature(@Nonnull String... values) {
        List<ByteString> strIter = new ArrayList<>();
        for (String value : values) {
            strIter.add(ByteString.copyFromUtf8(value));
        }
        BytesList bytesList = BytesList.newBuilder().addAllValue(strIter).build();
        return Feature.newBuilder().setBytesList(bytesList).build();
    }

    public static Feature byteStringFeature2(@Nonnull Iterable<String> values) {
        List<ByteString> strIter = new ArrayList<>();
        for (String value : values) {
            strIter.add(ByteString.copyFromUtf8(value));
        }
        BytesList bytesList = BytesList.newBuilder().addAllValue(strIter).build();
        return Feature.newBuilder().setBytesList(bytesList).build();
    }

}
