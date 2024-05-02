package org.swmaestro.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.swmaestro.demo.model.Notice;
import org.swmaestro.demo.service.NoticeService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/notices")
@RestController
@RequiredArgsConstructor
@Slf4j
public class NoticeRestController {

    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Notice param) {
        log.info("create; param={}", param);

        Notice notice = noticeService.create(param);
        log.info("notice={}", notice);
        if (notice != null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> read(@PathVariable String id) {
        log.info("read; id={}", id);

        Notice notice = noticeService.read(id);
        log.info("notice={}", notice);
        if (notice != null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(notice, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Notice>> list() {
        log.info("list");

        List<Notice> list = noticeService.list();
        if (list == null)
            list = new ArrayList<>();

        log.info("list.size={}", list.size());
        log.debug("list={}", list);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Notice param) {
        log.info("update; id={}, param={}", id, param);

        Notice notice = noticeService.read(id);
        if (notice == null) {
            log.warn("Fail to update. No member; id={}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        param.setId(id);
        noticeService.update(param);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete; id={}", id);

        Notice notice = noticeService.read(id);
        if (notice == null) {
            log.warn("Fail to delete. No member; id={}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        noticeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}