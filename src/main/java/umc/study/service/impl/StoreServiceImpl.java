package umc.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.service.StoreService;
import umc.study.web.dto.request.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    public Store createStore(StoreRequestDTO.CreateStoreDTO createStoreDTO) {
        return null;
    }
}
