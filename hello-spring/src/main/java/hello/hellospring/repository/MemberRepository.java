package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);      //회원저장
    Optional<Member> findById(Long id);  //id를 찾음
    Optional<Member> findByName(String name); // name을 찾음
    List<Member> findAll();             // 모든 회원 찾음
}
