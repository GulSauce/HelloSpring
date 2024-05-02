package org.swmaestro.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.service.MemberService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/members")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Member param) {
        log.info("create; param={}", param);

        Member member = memberService.create(param);
        log.info("member={}", member);
        if (member != null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> read(@PathVariable String id) {
        log.info("read; id={}", id);

        Member member = memberService.read(id);
        log.info("member={}", member);
        if (member != null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Member>> list() {
        log.info("list");

        List<Member> list = memberService.list();
        if (list == null)
            list = new ArrayList<>();

        log.info("list.size={}", list.size());
        log.debug("list={}", list);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Member param) {
        log.info("update; id={}, param={}", id, param);

        Member member = memberService.read(id);
        if (member == null) {
            log.warn("Fail to update. No member; id={}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        param.setId(id);
        memberService.update(param);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete; id={}", id);

        Member member = memberService.read(id);
        if (member == null) {
            log.warn("Fail to delete. No member; id={}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}