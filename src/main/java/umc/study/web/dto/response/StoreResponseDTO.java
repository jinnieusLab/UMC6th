package umc.study.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CreateStoreResultDTO {
        private Long storeId;
        private LocalDateTime createdAt;
    }



}
