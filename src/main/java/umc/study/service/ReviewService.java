package umc.study.service;

import umc.study.domain.Review;
import umc.study.web.dto.request.ReviewRequestDTO;

public interface ReviewService {
    public Review createReview(Long memberId, Long storeId, ReviewRequestDTO.CreateReviewDTO createReviewDTO);
}
