package umc.study.service.store;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    boolean isExist(Long id);
}
