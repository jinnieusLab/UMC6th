package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.request.MemberRequestDTO;
import umc.study.web.dto.response.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMissionDTO(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status("도전중")
                .build();
    }

    public static MemberMissionResponseDTO.AddMemberMissionResultDTO toAddMemberMissionDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.AddMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(1L)
                .missionId(memberMission.getMission().getId())
                .build();
    }
}
