package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import umc.study.domain.Mission;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionResultDTO {
        private Long missionId;
        private Long storeId;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDTO {
        private Long missionId;
        private Long storeId;
        private Long reward;
        private LocalDateTime deadline;
        private String missionSpec;
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListDTO {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList;
    }
}
