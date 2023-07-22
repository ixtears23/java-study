### jar 파일로 실행 방법

1. fat jar 파일 생성  
> precondition  
JAVA_HOME 환경 변수 경로를 JAVA 20 으로 설정(본 프로젝트는 JAVA20)  
> gradle은 JAVA_HOME 환경변수를 찾아서 해당 Java를 실행하기 때문에
```shell
./gradlew clean shadowJar
```

2. java 실행
```shell
java -jar ./build/libs/java-study-1.0.0-RELEASE.jar junseok.snr.thread.ThreadPoolSize
```
