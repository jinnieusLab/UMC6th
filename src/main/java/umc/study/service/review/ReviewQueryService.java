package umc.study.service.review;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long memberId, Integer page);
}
