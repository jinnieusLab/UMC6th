package umc.study.web.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        @NotBlank
        String name;

        @NotBlank
        String telNum;

        @NotBlank
        String address;

        @NotNull
        Float score;

//        List<Long> reviewList;

    }
}
