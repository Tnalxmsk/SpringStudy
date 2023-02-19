package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository {

    // save 할 때 저장할 것
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;   // 0, 1, 2 key 값 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence);           // 고객 id 세팅
        store.put(member.getId(), member);  // 고객 id store 에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // 결과가 없다면 null 이 반환될 가능성이 있기에 Optional 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))  // geeName 과 매게변수로 가져온 name 이 같은지 확인
                .findAny();                                       // 찾으면 반환, 없으면 null 이 포함돼서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());   // store 에 member 들이 반환
    }

    public void clearStore() {
        store.clear();
    }
}
