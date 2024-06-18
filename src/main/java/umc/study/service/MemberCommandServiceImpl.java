package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.request.MemberRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member member = MemberConverter.toMember(request);

        return null;
    }
}
