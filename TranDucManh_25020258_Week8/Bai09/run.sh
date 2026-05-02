#!/bin/bash

# 1. Chỉ định đích danh file JAR (có bọc trong ngoặc kép để xử lý dấu cách)
JAR_NAME="lib/junit-platform-console-standalone-1.10.0 copy.jar"
BUILD_DIR="build"
SRC_FILE="src/chap9.java"

# Tạo thư mục build nếu chưa có
mkdir -p "$BUILD_DIR"

echo "Đang biên dịch mã nguồn..."
# QUAN TRỌNG: Toàn bộ phần Classpath phải nằm trong ngoặc kép
javac -encoding utf8 -d "$BUILD_DIR" -cp ".;$JAR_NAME" "$SRC_FILE"

if [ $? -eq 0 ]; then
    echo "Biên dịch thành công!"
    echo "------------------------------------"
    echo "Đang chạy JUnit test..."
    
    # Chạy JUnit Console Launcher
    java -cp "$BUILD_DIR;$JAR_NAME" org.junit.platform.console.ConsoleLauncher execute --scan-class-path "$BUILD_DIR"
else
    echo "Vẫn lỗi biên dịch rồi người đẹp trai ơi! Hãy kiểm tra lại file .jar nhé."
fi