package org.swmaestro.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.swmaestro.demo.model.Notice;
import org.swmaestro.demo.repository.NoticeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService extends BaseService {

    private final NoticeRepository noticeRepository;

    // 공지사항 등록
    public Notice create(Notice notice) { return noticeRepository.save(notice); }

    // 특정 ID의 공지사항 조회
    public Notice read(String id) { return noticeRepository.findById(id).orElse(null); }

    // 모든 공지사항 조회
    public List<Notice> list() { return noticeRepository.findAll(); }

    // 공지사항 수정
    public Notice update(Notice notice) { return noticeRepository.save(notice); }

    // 공지사항 삭제
    public void delete(String id) { noticeRepository.deleteById(id); }

}
