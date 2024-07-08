package umc.study.web.dto.response;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

public class ReviewResponseDTO {

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class CreateReviewResultDTO {
        private Long reviewId;
        private String body;
        private Integer score;
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO {
        private String name;
        private Integer score;
        private String body;
        private LocalTime createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListDTO {
        List<ReviewPreviewDTO> reviewPreviewDTOList;
    }
}
