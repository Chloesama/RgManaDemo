package mana.pojo;

public class Hello {
    private String str ;

    public Hello(){
        System.out.println("Hello 被创建了!");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
