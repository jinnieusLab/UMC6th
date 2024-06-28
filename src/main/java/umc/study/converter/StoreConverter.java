package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.request.StoreRequestDTO;
import umc.study.web.dto.response.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.CreateStoreDTO createStoreDTO) {
        return  Store.builder()
                .name(createStoreDTO.getName())
                .telNum(createStoreDTO.getTelNum())
                .address(createStoreDTO.getAddress())
                .score(createStoreDTO.getScore())
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO (Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
