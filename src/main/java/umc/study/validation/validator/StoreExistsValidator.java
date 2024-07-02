package umc.study.validation.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.StoreRepository;
import umc.study.validation.annotation.ExistsStore;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<ExistsStore, Long> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistsStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        boolean isValid = storeRepository.existsById(storeId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
