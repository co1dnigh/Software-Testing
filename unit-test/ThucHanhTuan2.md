
# Student Analyzer – Unit Test Practice

## 1. Giới thiệu

Dự án này xây dựng chương trình Java dùng để phân tích dữ liệu điểm số học sinh.
Chương trình cung cấp các chức năng:

* Đếm số học sinh đạt loại **Giỏi (≥ 8.0)**
* Tính điểm trung bình của các điểm **hợp lệ (0 → 10)**

Dự án đồng thời minh họa cách viết **Unit Test tự động bằng JUnit + Maven** theo quy trình phát triển phần mềm chuyên nghiệp.

---

## 2. Cấu trúc thư mục

```
unit-test/
 ├── src/
 │    └── StudentAnalyzer.java
 ├── test/
 │    └── StudentAnalyzerTest.java
 ├── pom.xml

```

---

## 3. Quy tắc xử lý dữ liệu

Chương trình xử lý điểm theo các quy tắc:

* Điểm hợp lệ: từ **0 đến 10**
* Điểm <0 hoặc >10 → bỏ qua
* Phần tử null → bỏ qua
* Danh sách rỗng → trả về 0

---

## 4. Chức năng chính

### 4.1 countExcellentStudents(List<Double> scores)

Trả về số học sinh có điểm ≥ 8.0

---

### 4.2 calculateValidAverage(List<Double> scores)

Trả về điểm trung bình của các điểm hợp lệ.

Nếu không có điểm hợp lệ → trả về 0.

---

## 5. Kiểm thử đơn vị

Project sử dụng **JUnit** để kiểm thử tự động.

Các nhóm test bao gồm:

### Trường hợp bình thường

* danh sách chứa cả điểm hợp lệ và không hợp lệ
* danh sách toàn điểm hợp lệ

### Trường hợp biên

* danh sách rỗng
* điểm = 0 hoặc 10

### Trường hợp lỗi dữ liệu

* điểm âm
* điểm > 10
* phần tử null

---

## 6. Cách chạy chương trình

### Chạy test bằng Maven

```
mvn test
```

Sau khi chạy thành công sẽ hiển thị:

```
BUILD SUCCESS
```

---

## 7. Công nghệ sử dụng

* Java
* Maven
* JUnit

---

## 8. Quy trình phát triển (Workflow)

Dự án được thực hiện theo quy trình:

1. Tạo Issue cho từng chức năng
2. Code từng chức năng
3. Commit kèm liên kết Issue
4. Viết Unit Test
5. Cập nhật tài liệu README

Ví dụ commit message:

```
feat: implement countExcellentStudents closes #1
test: add unit tests closes #3
docs: update README closes #4
```

---

## 9. Mục tiêu học tập đạt được

* Viết Unit Test với JUnit
* Áp dụng Git workflow chuẩn
* Kiểm thử dữ liệu đầu vào
* Xử lý edge cases
* Tổ chức code theo cấu trúc chuẩn




