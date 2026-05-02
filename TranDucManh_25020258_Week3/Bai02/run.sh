#!/bin/bash

# Lấy thư mục hiện tại
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"

# Tạo thư mục build nếu chưa có
mkdir -p "$BUILD_DIR"

# 1. Biên dịch tất cả file Java trong src vào thư mục build
echo "Đang biên dịch..."
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

if [ $? -eq 0 ]; then
    echo "Biên dịch thành công!"
    
    # 2. Tự động tìm package và class chính (giả sử file chứa main là chap10.java)
    # Nếu bạn đổi tên file thành chap4.java, nó vẫn sẽ tự nhận diện được.
    MAIN_CLASS=$(grep -l "public static void main" "$SRC_DIR"/*.java | xargs basename -s .java)
    PACKAGE_NAME=$(grep "package" "$SRC_DIR/$MAIN_CLASS.java" | cut -d' ' -f2 | sed 's/;//')

    echo "Đang chạy: $PACKAGE_NAME.$MAIN_CLASS"
    echo "------------------------------------"
    
    # 3. Chạy chương trình với tên đầy đủ (Full Qualified Name)
    java -cp "$BUILD_DIR" "$PACKAGE_NAME.$MAIN_CLASS"
else
    echo "Lỗi biên dịch rồi người đẹp trai ơi!"
fi