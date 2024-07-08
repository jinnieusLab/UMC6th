package umc.study.service.store;

import umc.study.domain.Store;
import umc.study.web.dto.request.StoreRequestDTO;

public interface StoreService {
    Store createStore(StoreRequestDTO.CreateStoreDTO createStoreDTO);
}

