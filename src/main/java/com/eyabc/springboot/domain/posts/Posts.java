package com.eyabc.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

/*
* 서비스 초기 구축단계에서 테이블 설계(Entity 설계)가 빈번하게 변경된다.
* 롬복의 어노테이션들은 코드 변경량을 최소화 시켜 준다.
*
* Setter 메소드가 없다. getter/setter를 무작정 생성하면 해당 클래스의 인스턴스 값들이 언제 어디에서
* 변해야 하는지 코드상으로 명확하게 구분할 수가 없어. 복잡해지므로
* Entity 클래스에는 절대 setter 메소드를 만들지 않는다.
* 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야 한다.
*
* setter 의 잘못된 사용 예
* public class Order {
*   public void setStatus(boolean status) {
*       this.status = status;
*   }
* }
* public void 주문서비스의_취소이벤트() {
*   order.setStatus(false)
* }
*
* 올바른 사용예
* public class Order {
*   public void cancelOrder() {
*       this.status = false;
*   }
* }
* public void 주문서비스의_취소이벤트() {
*   order.cancelOrder();
* }
*
* Setter가 없을 때 DB에 값을 삽입하는 방법
* 기본적으로 생성자를 통해 최종값을 채운 후 DB에 삽입한다.
* 값 변경시 해당 이벤트에 맞는 public 메서드를 호출하여 변경한다.
* @Builder의 빌더 클래스 사용은 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있다.
* public Example (String a, String b) {
*   this.a = a;
*   this.b = b;
* } to
* Example.builder().a(a).b(b).build();
*
* 주요 어노테이션을 클래스에 가깝게 둔 이유
* @Entity 는 JPA의 어노테이션
* @Getter @NoArgsConstructor 은 lombok의 어노테이션. 코드를 단순화 시켜주지만 필수는 아니다.
* 새 언어의 전환으로 롬복이 더이상 필요없을 경우 쉽게 삭제할 수 있는 장점.
*
* Posts 클래스는 DB 테이블과 매칭될 클래스이다. 보통 Entity 클래스 라고도 한다.
*
* @Entity
* 테이블과 링크될 클래스임을 나타낸다.
* 기본값으로 CamelCase 이름을 undersore(_) 네이밍으로 테이블을 매칭한다.
* SalesManager.java -> sales_manager table
*
* @Id
* 해당 테이블의 PK 필드를 나타냄
*
* @GeneratedValue
* PK의 생성 규칙을 나타낸다.
* 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야먄 auth_increment 가 된다.
*
* @Column
* 테이블의 칼럼을 나타내며 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
* 기본값 외에 추가로 변경이 필요한 옵션이 있을 때 사용한다.
* 문자열의 기본값: VARCHER(255)
*
* @NoArgsConstructor
* 기본 생성자 자동 추가
* public Posts() {} 와 같은 효과
*
* @Getter
* 클래스 내 모든 필드의 Getter 메소드를 자동 생성
*
* @Builder
* 해당 클래스의 빌더 패턴 클래스를 생성
* 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
*
* */

/*
* PK 의 추천 옵션: long type, auto_increment, mysql 기준 bight type
* 예: 주민번호, 비즈니스상 유니크키, 복합키로 PK 를 할 때
* (1) PK를 맺을 떄 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야 하는 상황이 발생한다.
* (2) 인덱스에 좋은 영향을 끼치지 못한다.
* (3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일이 발생하기 때문에 주민번호나 복합키 등은 유니크 키로 별도로 추가하자.
* */