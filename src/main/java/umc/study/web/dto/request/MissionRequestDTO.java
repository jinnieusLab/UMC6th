package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionDTO {
        @NotNull
        private Long reward;

        @NotNull
        private LocalDateTime deadline;

        @NotBlank
        private String missionSpec;
    }
}
