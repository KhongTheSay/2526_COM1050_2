#!/bin/bash

# 1. Tự động tìm file JAR (xử lý cả trường hợp có dấu cách ' copy.jar')
JAR_PATH=$(ls lib/junit-platform-console-standalone-*.jar | head -n 1)
BUILD_DIR="build"

# Kiểm tra thư viện
if [ -z "$JAR_PATH" ]; then
    echo "Lỗi: Không tìm thấy file thư viện trong thư mục lib!"
    exit 1
fi

mkdir -p "$BUILD_DIR"

echo "Đang biên dịch toàn bộ file trong src..."
# 2. Biên dịch TẤT CẢ file .java trong src để tránh sót file
javac -encoding utf8 -d "$BUILD_DIR" -cp ".;$JAR_PATH" src/*.java

if [ $? -eq 0 ]; then
    echo "Biên dịch thành công!"
    echo "------------------------------------"
    echo "Đang chạy JUnit test cho người đẹp trai..."
    
    # 3. Quét toàn bộ build để tìm và chạy test
    java -cp "$BUILD_DIR;$JAR_PATH" org.junit.platform.console.ConsoleLauncher execute --scan-class-path "$BUILD_DIR"
else
    echo "Vẫn còn lỗi biên dịch! Nhớ đổi tên 'class Test' thành 'class AccountTest' nhé!"
fi