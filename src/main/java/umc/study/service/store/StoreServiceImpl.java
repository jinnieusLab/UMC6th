package umc.study.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.request.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    public Store createStore(StoreRequestDTO.CreateStoreDTO createStoreDTO) {
        Store store = StoreConverter.toStore(createStoreDTO);
        return storeRepository.save(store);
    }
}
