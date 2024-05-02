package org.swmaestro.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.swmaestro.demo.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
    // 추가적인 커스텀 쿼리 메서드를 정의할 수 있습니다.
}