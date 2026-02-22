# JMeter Performance Test Report

## 1. Giới thiệu

Bài kiểm thử này sử dụng **Apache JMeter** để đo hiệu năng website **vnexpress.net** với nhiều mức tải khác nhau.
Mục tiêu là đánh giá khả năng phản hồi, độ ổn định và hiệu suất khi số lượng người dùng tăng.

---

## 2. Môi trường kiểm thử

* Tool: Apache JMeter 5.6.3
* Protocol: HTTPS
* Method: GET
* Máy chạy test: Local machine
* Network: WiFi cá nhân

---

## 3. Kịch bản kiểm thử

### Thread Group 1 — Basic Load Test

| Tham số | Giá trị   |
| ------- | --------- |
| Users   | 10        |
| Loop    | 5         |
| Request | Trang chủ |

**Kết quả**

| Metric     | Value       |
| ---------- | ----------- |
| Samples    | 50          |
| Average    | 142 ms      |
| Min        | 43 ms       |
| Max        | 427 ms      |
| Error      | 0%          |
| Throughput | 27.43 req/s |

**Nhận xét:**
Trang chủ tải nhanh và ổn định với tải nhẹ.

---

### Thread Group 2 — Heavy Load Test

| Tham số | Giá trị              |
| ------- | -------------------- |
| Users   | 50                   |
| Ramp-up | 30s                  |
| Request | Trang chủ + bài viết |

**Kết quả**

| Label     | Samples | Avg | Min | Max | Error | Throughput |
| --------- | ------- | --- | --- | --- | ----- | ---------- |
| Home Page | 50      | 124 | 79  | 253 | 0%    | 1.7/s      |
| Article   | 50      | 67  | 49  | 119 | 0%    | 1.7/s      |
| TOTAL     | 100     | 95  | 49  | 253 | 0%    | 3.4/s      |

**Nhận xét:**
Website vẫn hoạt động ổn định khi tải trung bình, không lỗi, thời gian phản hồi tốt.

---

### Thread Group 3 — Custom Load Test

| Tham số  | Giá trị                   |
| -------- | ------------------------- |
| Users    | 20                        |
| Duration | 60s                       |
| Request  | Trang category + bài viết |

**Kết quả**

| Label    | Samples | Avg | Min | Max   | Error | Throughput |
| -------- | ------- | --- | --- | ----- | ----- | ---------- |
| Category | 1279    | 509 | 46  | 19248 | 0.16% | 16.3/s     |
| Article  | 1271    | 456 | 48  | 19236 | 0.24% | 16.2/s     |
| TOTAL    | 2550    | 482 | 46  | 19248 | 0.20% | 32.4/s     |

**Nhận xét:**

* Khi tải cao liên tục, response time tăng rõ rệt.
* Có lỗi nhỏ (<0.5%) cho thấy server bắt đầu chịu áp lực.
* Max response time rất cao → dấu hiệu quá tải tạm thời.

---

## 4. So sánh kết quả

| Scenario | Avg Response | Error | Nhận xét        |
| -------- | ------------ | ----- | --------------- |
| Basic    | 142 ms       | 0%    | Rất ổn định     |
| Heavy    | 95 ms        | 0%    | Vẫn ổn          |
| Custom   | 482 ms       | 0.2%  | Bắt đầu quá tải |

---

## 5. Kết luận

* Website xử lý tốt tải nhẹ và trung bình.
* Khi tải cao liên tục, thời gian phản hồi tăng và xuất hiện lỗi nhỏ.
* Hệ thống backend có thể cần tối ưu nếu lượng truy cập lớn kéo dài.

---

## 6. File đính kèm

Thư mục `jmeter/` gồm:

```
jmeter/
 ├── test-plan.jmx
 ├── results-thread1.csv
 ├── results-thread2.csv
 ├── results-thread3.csv
 ├── screenshots/
 └── README.md
```

---

## 7. Tổng kết kiến thức đạt được

Qua bài này đã học được:

* Cách tạo Test Plan trong JMeter
* Cách thiết kế kịch bản tải khác nhau
* Cách đọc chỉ số performance
* Cách phân tích bottleneck hệ thống

---

**Kết luận cuối:**
JMeter là công cụ mạnh để kiểm thử hiệu năng và mô phỏng hành vi người dùng thực tế.
