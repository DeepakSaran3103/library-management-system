package com.onedata.library.controler;

import com.onedata.library.dto.MemberDto;
import com.onedata.library.exceptions.InvalidException;
import com.onedata.library.service.intterface.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("add")
    public ResponseEntity<MemberDto> addmember(@RequestBody MemberDto memberDto) {
        if (String.valueOf(memberDto.getPhone_number()).length() != 10) {
            throw new InvalidException("Phone number must be exactly 10 digits");
        }
        MemberDto saved = memberService.addMember(memberDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @PostMapping("update")
    public ResponseEntity<MemberDto> update (@RequestBody MemberDto memberDto){
        if (String.valueOf(memberDto.getPhone_number()).length() != 10) {
            throw new InvalidException("Phone number must be exactly 10 digits");
        }
        MemberDto saved = memberService.updateMember(memberDto);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("member Details was Deleted");
    }
}
