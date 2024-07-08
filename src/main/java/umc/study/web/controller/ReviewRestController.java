package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.review.ReviewQueryService;
import umc.study.service.review.ReviewService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistsStore;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewRestController {
    private final ReviewService reviewService;
    private final ReviewQueryService reviewQueryService;

    @Operation(summary = "가게 리뷰 등록 API",description = "멤버가 가게에 리뷰를 등록하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 리뷰 등록 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE4001", description = "가게를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다."),
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다.")
    })
    @PostMapping("members/{memberId}/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@PathVariable Long memberId, @ExistsStore @PathVariable(name = "storeId") Long storeId, @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO createReviewDTO) {
        Review review = reviewService.createReview(memberId, storeId, createReviewDTO);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }

    @Operation(summary = "내가 작성한 리뷰 등록 API",description = "본인이 작성한 리뷰를 조회하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 리뷰 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "REVIEW4001", description = "리뷰를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    @GetMapping("members/{memberId}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> readReviews(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Review> reviewPage = reviewQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewPage));
    }
}
