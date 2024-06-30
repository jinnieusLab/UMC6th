package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionResultDTO {
        private Long missionId;
        private Long reward;
        private LocalDateTime deadline;
        private String missionSpec;
    }
}
