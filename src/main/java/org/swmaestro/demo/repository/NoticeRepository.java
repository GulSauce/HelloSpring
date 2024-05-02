package org.swmaestro.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.swmaestro.demo.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, String> {

}
