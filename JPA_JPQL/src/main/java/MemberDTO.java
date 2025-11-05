public class MemberDTO {

    private String username;
    private int age;
    private String team;

    public MemberDTO(String username, int age, String team) {
        this.username = username;
        this.age = age;
        this.team = team;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
