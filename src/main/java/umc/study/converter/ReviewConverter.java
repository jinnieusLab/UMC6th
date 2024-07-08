package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO createReviewDTO) {
        return Review.builder()
                .body(createReviewDTO.getBody())
                .score(createReviewDTO.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .body(review.getBody())
                .score(review.getScore())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .name(review.getMember().getName())
                .createdAt(review.getCreatedAt())
                .score(review.getScore())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewPage) {
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewPage.stream()
                .map(ReviewConverter::toReviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewPreviewDTOList(reviewPreviewDTOList)
                .build();
    }
}
