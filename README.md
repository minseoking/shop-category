# 온라인 카테고리 CRUD API


## 리눅스 실행 방법

### 1. Linux Docker 설치
```
sudo yum install docker (centos기준)
```

### 2. Docker 실행 및 상태 확인
초록색 글씨의 active(running) 보이면 정상
```
sudo systemctl start docker # docker 실행
sudo systemctl status docker # docker 상태 확인
```

### 3. Docker 이미지 Pull
```
sudo docker pull minseoklee98/shop-mission
```
### 4. Docker 실행
```
sudo docker run -p 8080:8080 minseoklee98/shop-mission
```
### 5. api 실행 확인
```
http://(실행IP 또는 localhost):8080/swagger-ui/index.html
```

