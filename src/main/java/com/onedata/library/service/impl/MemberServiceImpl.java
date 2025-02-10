package com.onedata.library.service.impl;

import com.onedata.library.entities.MemberEntities;
import com.onedata.library.mapper.Mapper;
import com.onedata.library.dto.MemberDto;
import com.onedata.library.repository.MemberRepository;
import com.onedata.library.service.intterface.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberDto addMember(MemberDto memberDto){
        MemberEntities memberEntities= Mapper.mapMember(memberDto);
        MemberEntities MemberEntities1= memberRepository.save(memberEntities);
        return Mapper.mapMemberDto(MemberEntities1);
    }

    @Override
    public MemberDto updateMember(MemberDto memberDto) {
        MemberDto MemberDto1=findById(memberDto.getMember_id());
        return addMember(memberDto);
    }

    @Override
    public void deleteMember(Long id) {
        MemberDto MemberDto=findById(id);
        memberRepository.deleteById(id);
    }

    @Override
    public MemberDto findById(Long id) {
        Optional<MemberEntities> MemberEntities= memberRepository.findById(id);
        MemberEntities MemberEntities1=MemberEntities.get();
        return Mapper.mapMemberDto(MemberEntities1);
    }
}
