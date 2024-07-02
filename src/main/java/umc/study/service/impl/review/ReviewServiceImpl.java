package umc.study.service.impl.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.request.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, ReviewRequestDTO.CreateReviewDTO createReviewDTO) {
        Review review = ReviewConverter.toReview(createReviewDTO);
        // Review의 Member와 Store 연관관계
        Member member = memberRepository.findById(memberId).orElseThrow(()->{
            throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);});
        Store store = storeRepository.findById(storeId).orElseThrow(()->{
            throw new StoreHandler(ErrorStatus.STORE_NOT_FOUND);});
        review.setMember(member);
        review.setStore(store);

        return reviewRepository.save(review);
    }
}
