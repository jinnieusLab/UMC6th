package umc.study.service.impl.member;

import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.request.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberMission addMemberMission(Long missionId);
}
