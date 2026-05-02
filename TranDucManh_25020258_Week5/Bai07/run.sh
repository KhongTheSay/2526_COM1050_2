#!/bin/bash

ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"

mkdir -p "$BUILD_DIR"

echo "Đang biên dịch..."
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

if [ $? -eq 0 ]; then
    echo "Biên dịch thành công!"
    
    MAIN_CLASS=$(grep -l "public static void main" "$SRC_DIR"/*.java | xargs basename -s .java)
    PACKAGE_NAME=$(grep "package" "$SRC_DIR/$MAIN_CLASS.java" | cut -d' ' -f2 | sed 's/;//')

    echo "Đang chạy: $PACKAGE_NAME.$MAIN_CLASS"
    echo "------------------------------------"
    
    java -cp "$BUILD_DIR" "$PACKAGE_NAME.$MAIN_CLASS"
else
    echo "Lỗi biên dịch rồi người đẹp trai ơi!"
fi
