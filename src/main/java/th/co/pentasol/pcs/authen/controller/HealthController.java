package th.co.pentasol.pcs.purchase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("ALL")
@Slf4j
@RestController
public class HealthController {

    @GetMapping(value = "/health")
    public ResponseEntity<String> checkHealth(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse) {
        return ResponseEntity.status(200).body("Backend API Success");
    }
}
