//package umc.study.service.impl.mission;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import umc.study.domain.Mission;
//import umc.study.domain.Store;
//import umc.study.repository.MissionRepository;
//import umc.study.repository.StoreRepository;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class MissionQueryServiceImpl implements MissionQueryService {
//    private final StoreRepository storeRepository;
//
//    private final MissionRepository missionRepository;
//
//    @Override
//    public Optional<Store> findStore(Long id) {
//        return storeRepository.findById(id);
//    }
//
////    @Override
////    public Page<Mission> getMissionList(Long storeId, Integer page) {
////        Store store = storeRepository.findById(storeId).get();
////
////        Page<Mission> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
////        return StorePage;
////    }
//}
