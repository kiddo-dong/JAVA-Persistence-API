import Testing.User;

public class Main {
    public static void main(String[] args) {
        // Data Access Layer
        // Persistence Test

        // Object _init_
        MemberRepository memberRepository = new MemberRepository();

        User user = new User("최동현", "24");

        // 저장 확인
        memberRepository.save(user);




    }
}
