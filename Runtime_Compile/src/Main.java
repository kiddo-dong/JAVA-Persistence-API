public class Main {

    // Code 실행 시 내부 동작 순서
    // Compile -> run(main)
    // .java -> .class
    // 자연어 소스코드(.java 작성) -> 컴파일(Compiler) javac  -> 바이트 코드(.class 로 변환) -> JVM(Interprint + JIT compile)로 기계어로 변환
    public static void main(String[] args) {
        // Runtime
        String a = null;

        // NullPointerException 발생
        // Runtime 시점에서 발생
        System.out.println(a.length());

        // Compile-time
        // IDE가 잡아줄 수도 있지만
        // 문법 오류 검사이기 때문에 Compile-time에서 발생
        // String b = 10;

        // Kotlin
        // Kotlin도 Kotlinc(코틀린 컴파일러)로 .Ko(자연어 소스 코드)를 .class(ByteCode)로 변환이 가능ㅎ
        // .class 는 JVM으로 실행가능해서
        // JAVA와 Kotlin 두 자연어로 JVM이 Runtime이 가능
        /*
        fun main(){
            println();
        }
        */

        // MapStruct - Compile-time
        // MapStruct Interface에 @Mapper를 붙이면
        // 해당 인터페이스를 기반으로 만들어지는 구현체를
        // Compile 시점에서 생성됨

        // MapStruct가 Compile시점에서 생성되는 이유 -> MapStruct Library는 순수 자바코드로 이루어짐
    }
}
