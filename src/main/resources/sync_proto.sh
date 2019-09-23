#!/usr/bin/env bash

# git clone git@github.com:tensorflow/tensorflow.git
# /path/to/tensorflow
tensorflow_path=$1

# git clone git@github.com:tensorflow/serving.git
# /path/to/serving
serving_path=$2

# /path/to/tensorflow-common
project_root_path=$3

python sync_proto.py ${tensorflow_path} ${project_root_path}
python sync_proto.py ${serving_path} ${project_root_path}

# Important Attention
# Fix BUG at tensorflow/compiler/tf2xla/host_compute_metadata.proto
# change `option java_outer_classname` from "Tf2XlaProtos" to "HostComputeMetadataProtos"
