package umc.study.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {
        @NotBlank
        private String body;

        @NotBlank
        private Integer score;
    }
}
