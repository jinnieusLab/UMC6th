package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class AddMemberMissionResultDTO {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
        private String status;
    }
}
