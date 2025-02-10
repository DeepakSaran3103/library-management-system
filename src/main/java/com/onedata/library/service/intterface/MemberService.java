package com.onedata.library.service.intterface;

import com.onedata.library.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    MemberDto addMember(MemberDto MemberDto);
    MemberDto updateMember(MemberDto MemberDto);
    void deleteMember(Long id);
    MemberDto findById(Long id);

}
