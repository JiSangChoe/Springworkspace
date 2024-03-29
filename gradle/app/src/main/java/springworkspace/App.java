/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package springworkspace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @NoArgsConstructor // 빈 생성자
@AllArgsConstructor
@RequiredArgsConstructor // final 변수를 값을 넣어줘야함
@Builder
class Person{
    private final String name;
    private int age;
}

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Person person = new Person("홍길동", 20); //인스턴스 생성
        person = new Person("고길동");
        person = Person.builder().name("홍길동").age(20).build();
        
    }
}
