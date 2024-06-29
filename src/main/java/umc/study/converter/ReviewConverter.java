package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.CreateReviewDTO createReviewDTO) {
        return Review.builder()
                .body(createReviewDTO.getBody())
                .score(createReviewDTO.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .body(review.getBody())
                .score(review.getScore())
                .build();
    }
}
