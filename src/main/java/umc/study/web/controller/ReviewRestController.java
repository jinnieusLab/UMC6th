package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewRestController {
    private final ReviewService reviewService;

    @PostMapping("members/{memberId}/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@PathVariable Long memberId, @PathVariable Long storeId, @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO createReviewDTO) {
        Review review = reviewService.createReview(memberId, storeId, createReviewDTO);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

}
