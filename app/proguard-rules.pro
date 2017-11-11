# Optimizations:
# The following flags turn off various optimizations known to have issues, but
# the list may not be complete or up to date. Make sure you test thoroughly if
# you go this route.
-optimizations code/simplification/*,!field/*,!class/merging/*,class/marking/final,class/unboxing/enum,method/marking/*,method/removal/parameter,method/propagation/*,method/inlining/*,code/removal/*,code/merging,code/allocation/variable
-optimizationpasses 4
-allowaccessmodification
-dontpreverify
