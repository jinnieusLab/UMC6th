package umc.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.service.TempQueryService;

@Service
@RequiredArgsConstructor
public class TempCommandQueryImpl implements TempQueryService {

    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
