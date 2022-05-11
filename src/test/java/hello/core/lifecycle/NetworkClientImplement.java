//package hello.core.lifecycle;
//
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//
//public class NetworkClient implements InitializingBean, DisposableBean {
//
//    private String url;
//
//    public NetworkClient() {
//        System.out.println("생성자 호출, url =" + url);
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    // 서비스 시작시 호출
//    public void connect() {
//        System.out.println("Connect : " + url);
//    }
//
//    public void call(String message) {
//        System.out.println("Call: " + url + "message : " + message);
//    }
//
//    // 서비스 종료시 호출
//    public void disconnect() {
//        System.out.println("close : " + url);
//    }
//
//    // 프로퍼티 세팅이 끝나면 호출하는 메서드
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//
//    }
//
//    // 빈이 종료되기전 호출
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("destroy");
//        disconnect();
//    }
//}
