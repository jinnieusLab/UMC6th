package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {
        @NotBlank
        private String body;

        @NotNull
        private Integer score;
    }
}
