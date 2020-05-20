package com.eyabc.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* Posts 클래스로 Database 를 접근하게 해줄 JpaRepository */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}

/*
* 인터페이스 생성후 extends JpaRepository<Entity Class, PK type>
* 기본적인 CRUD 메서드가 자동생성됨.
*
* Entity Class와 기본 Entity Repository는 함께 위치해야 한다.
* */