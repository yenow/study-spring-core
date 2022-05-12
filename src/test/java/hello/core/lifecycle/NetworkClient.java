package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url =" + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("Connect : " + url);
    }

    public void call(String message) {
        System.out.println("Call: " + url + "message : " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    // 프로퍼티 세팅이 끝나면 호출하는 메서드
    @PostConstruct
    public void init() throws Exception {
        System.out.println("init");
        connect();
        call("초기화 연결 메시지");

    }

    // 빈이 종료되기전 호출
    @PreDestroy
    public void close() throws Exception {
        System.out.println("close");
        disconnect();
    }
}
