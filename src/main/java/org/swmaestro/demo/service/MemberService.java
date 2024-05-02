package org.swmaestro.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService extends BaseService {

    private final MemberRepository memberRepository;

    // 공지사항 등록
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    // 특정 ID의 공지사항 조회
    public Member read(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    // 모든 공지사항 조회
    public List<Member> list() {
        return memberRepository.findAll();
    }

    // 공지사항 수정
    public Member update(Member member) {
        return memberRepository.save(member);
    }

    // 공지사항 삭제
    public void delete(String id) {
        memberRepository.deleteById(id);
    }
}
