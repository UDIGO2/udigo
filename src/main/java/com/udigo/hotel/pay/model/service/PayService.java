package com.udigo.hotel.pay.model.service;

import com.udigo.hotel.pay.model.dao.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class PayService {

    @Autowired
    private PayMapper payMapper;


    // 장바구니에서 체크한 숙소만 결제할 때 조회하는 메서드
    public List<Map<String, Object>> getCheckedCartItemsForPayment(String memberCode, List<Integer> checkedAccommodationIds) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("memberCode", memberCode);
        paramMap.put("checkedAccommodationIds", checkedAccommodationIds);

        return payMapper.getCheckedCartItemsForPayment(paramMap);
    }

    // 💡 결제 미리보기 (숙소명 & 가격 가져오기)
    public List<Map<String, Object>> getPaymentPreview(String memberCode, List<Integer> checkedAccommodationIds) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("memberCode", memberCode);
        paramMap.put("checkedAccommodationIds", checkedAccommodationIds);

        return payMapper.getPaymentPreview(paramMap); // 실제 쿼리 실행하도록 함
    }

    public List<Map<String, Object>> getCheckedAccommodations(String memberCode) {
        // 장바구니에 담긴 숙소 ID 조회
        List<Map<String, Object>> cartItems = payMapper.getCartItemsByMember(memberCode);

        // 각 숙소의 가격을 조회하여 추가
        for (Map<String, Object> item : cartItems) {
            int acmId = (int) item.get("acm_id"); // 숙소 ID 가져오기
            Map<String, Object> priceInfo = payMapper.getAccommodationPrice(acmId); // 숙소 가격 조회

            if (priceInfo != null && priceInfo.containsKey("price")) {
                item.put("price", priceInfo.get("price")); // 가격 추가
            } else {
                item.put("price", 0); // 가격이 없는 경우 기본값 설정
            }
        }
        return cartItems;
    }
}