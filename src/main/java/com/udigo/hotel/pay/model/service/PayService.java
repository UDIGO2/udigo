package com.udigo.hotel.pay.model.service;
//
//import com.udigo.hotel.pay.model.dao.PayMapper;
//import com.udigo.hotel.pay.model.dto.PayDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Map;
//

import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class PayService {
//    private final PayMapper payMapper;
//
//    // 이니시스 API 연동 전제로 작성된 결제 로직
//    public void processPayment(PayDTO payDTO) {
//        // 결제 로직 (이니시스 결제 연동)
//        // 예제용 간단한 구조:
//        payDTO.setPayStatus("결제완료");
//        payDTO.setPayProvider("INICIS");
//        payDTO.setTransactionId("INICIS123456789"); // 실제 API 연동시 값으로 교체
//
//        payMapper.insertPay(payDTO);
//    }
//
//    public List<PayDTO> getPaymentList(int memberCode) {
//        return payMapper.selectPayByMemberCode(memberCode);
//    }
//
////    public void completePayment(Map<String, String> params) {
////        PayDTO pay = new PayDTO();
////        pay.setMemberCode(Integer.parseInt(params.get("member_code")));
////        pay.setAcmId(Integer.parseInt(params.get("acm_id")));
////        pay.setPayMethod(params.get("payMethod"));
////        pay.setPayStatus("결제완료");
////        pay.setPayPrice(Integer.parseInt(params.get("price")));
////        pay.setTransactionId(params.get("tid"));
////        pay.setPayProvider("INICIS");
////        payMapper.insertPay(payDTO);
////    }
//
////    @Transactional
////    public void completePayment(Map<String, String> params) {
////        if ("00".equals(params.get("resultCode"))) {
////            PayDTO pay = new PayDTO();
////            pay.setMemberCode(Integer.parseInt(params.get("memberCode")));
////            pay.setAcmId(Integer.parseInt(params.get("acmId")));
////            pay.setPayMethod(params.get("payMethod"));
////            pay.setPayPrice(Integer.parseInt(params.get("price")));
////            pay.setTransactionId(params.get("tid"));
////            pay.setPayStatus("결제완료");
////            pay.setPayProvider("INICIS");
////
////            payMapper.insertPay(pay);
////        } else {
////            throw new RuntimeException("결제 실패: " + params.get("resultMsg"));
////        }
////    }
}
