Pipeline không có bước actions/checkout, nên GitHub Actions không tải mã nguồn về runner. Vì vậy Maven không tìm thấy file pom.xml để build.


Version 9.9.9 của thư viện logback-classic không tồn tại trên Maven Central, nên Maven không thể tải dependency → build thất bại.


Phiên bản maven-surefire-plugin 2.12.4 quá cũ, không hỗ trợ JUnit 5 (JUnit Jupiter). Do đó Maven không nhận diện được các test và bỏ qua toàn bộ, khiến test không được thực thi.