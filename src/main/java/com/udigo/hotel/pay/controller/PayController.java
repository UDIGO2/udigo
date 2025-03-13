package com.udigo.hotel.pay.controller;

import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.pay.model.dto.PayDTO;
import com.udigo.hotel.pay.model.service.PayService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pay")

public class PayController {
    private final PayService payService;

    @PostMapping("/start")
    public String payStart(@RequestParam("acmIds") List<Integer> acmIds,
                           @RequestParam int totalPrice,
                           HttpSession session,
                           Model model) {

        MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
        if(member == null) {
            return "redirect:/member/login";
        }

//        model.addAttribute("memberCode", member.getMemberCode());
        model.addAttribute("acmIds", acmIds);
        model.addAttribute("totalPrice", totalPrice);

        // 이니시스 요청 관련 필요한 정보 (mid, oid, signature 등) 추가
        // 여기서는 생략된 것으로 실제 요청 시 API 키 등으로 채워야 함.

        return "pay/payStart";
    }

//     결제 완료 후 돌아오는 URL
//    @PostMapping("/complete")
//    public String payComplete(@RequestParam Map<String, String> params, Model model) {
//        payService.completePayment(params);
//        model.addAttribute("message", "결제가 완료되었습니다.");
//        return "pay/paySuccess";
//    }
    @PostMapping("/doPayment")
    public String doPayment(@ModelAttribute PayDTO payDTO, HttpSession session) {
        MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
//        payDTO.setMemberCode(member.getMemberCode());

        payService.processPayment(payDTO);
        return "redirect:/pay/success";
    }

    @GetMapping("/success")
    public String paymentSuccess() {
        return "pay/success";
    }

//    @GetMapping("/pay/start")
//    public String payStart(Model model) {
//        // 이니시스 결제요청 페이지 이동
//        model.addAttribute("mid", "INIpayTest"); // 실제 발급받은 MID 입력
//        model.addAttribute("price", 100000); // 실제 결제금액을 전달
//        return "pay/payStart";
//    }

//    @PostMapping("/pay/return")
//      public String payReturn(@RequestParam Map<String, String> params, Model model) {
//        // PG사 응답 값 확인 및 저장
//        payService.completePayment(params);
//        return "paySuccess";
//    }


    @Value("${inicis.mid}")
    private String mid;

    @Value("${inicis.signKey}")
    private String signKey;

    @Value("${inicis.returnUrl}")
    private String returnUrl;

    @GetMapping("/pay/start")
    public String payStart(Model model) {
        model.addAttribute("mid", mid);
        model.addAttribute("price", "1000"); // 결제 금액 설정
        model.addAttribute("orderId", UUID.randomUUID().toString());
        model.addAttribute("buyerName", "구매자 이름");
        model.addAttribute("returnUrl", returnUrl);

        // 해시 데이터 생성 (필수)
        String timestamp = String.valueOf(System.currentTimeMillis());
        String mKey = signKey;
        String oid = UUID.randomUUID().toString();
        String price = "1000";

        String hashData = makeHashData(mid, oid, price, timestamp, mKey);

        model.addAttribute("timestamp", timestamp);
        model.addAttribute("oid", oid);
        model.addAttribute("hashData", hashData);

        return "pay/payStart"; // 결제 호출 페이지
    }

    private String makeHashData(String mid, String oid, String price, String timestamp, String mKey) {
        String data = "oid=" + oid + "&price=" + price + "&timestamp=" + timestamp;
        String hashData = "";
        try {
            SecretKeySpec key = new SecretKeySpec(mKey.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(key);
            byte[] bytes = mac.doFinal(data.getBytes());
            hashData = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashData;
    }

    @PostMapping("/pay/return")
    public String payReturn(@RequestParam Map<String, String> params, Model model) {
        // 결제 결과 처리
        model.addAttribute("params", params);
        return "pay/paySuccess";
    }

}
