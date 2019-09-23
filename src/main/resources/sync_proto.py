#
# keep code no modified, execute command according to sync_proto.sh
#

import os
import shutil
import sys

try:
    fromDir = sys.argv[1]
    toDir = sys.argv[2]
except IndexError:
    print("%s <fromDir> <toDir>" % sys.argv[0])
    print("Example:")
    print("  %s /path/to/tensorflow_project path/to/tensorflow_proto" % sys.argv[0])
    print("  %s /path/to/tensorflow_serving_project path/to/tensorflow_serving_proto" %
          sys.argv[0])
    sys.exit(1)


def sync_dir(frompath, topath, subpath):
    if os.path.isdir(frompath):
        for subfile in os.listdir(frompath):
            sync_dir(frompath + '/' + subfile, topath, subpath + '/' + subfile)
    else:
        if frompath.endswith(".proto"):
            target = topath + "/" + subpath
            target_dir = os.path.dirname(target)
            if not os.path.exists(target_dir):
                os.makedirs(target_dir)
            print("copy %s to %s" % (frompath, target))
            shutil.copyfile(frompath, target)


sync_dir(fromDir, toDir, 'src/main/proto')
