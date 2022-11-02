# 온라인 쇼핑몰 카테고리 CRUD API


## 리눅스에서 Docker를 이용한 실행 방법

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
sudo docker pull minseoklee98/shop-mission:0.0.1
```
### 4. Docker 실행
```
sudo docker run -d -p 8080:8080 minseoklee98/shop-mission:0.0.1
```
### 5. api 실행 확인
```
http://(실행IP 또는 localhost):8080/swagger-ui/index.html
```

## 리눅스에서 코드 기반 빌드&실행 방법
### 1. 소스코드 클론
```
git clone https://github.com/minseoking/shop-category.git
```

### 2. 자바 설치
```
sudo apt install openjdk-8-jdk-headless
```

### 3. gralde 빌드
클론 받은 경로에 진입
```
./gradlew build
```
### 빌드된 파일 실행
build 디렉토리 진입
```
cd build/lib
java -jar discovery-0.0.1-SNAPSHOT.jar
```
### 5. api 실행 확인
```
http://(실행IP 또는 localhost):8080/swagger-ui/index.html
```