package siru.spring.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자는 외부에서 생성하지 못하도록 막는다. -> 다른 프로그래머들에게 외부에서 생성하면 안된다는 것을 명시할 수 있다.
    private SingletonService() {}

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
