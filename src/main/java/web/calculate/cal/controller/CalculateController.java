package web.calculate.cal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.calculate.cal.service.CalculateService;

@RestController
@RequestMapping("/calculator")
public class CalculateController {
    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }


    @GetMapping
    public String calculatorHello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/sum")
    public String sumAnswer(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {

        return calculateService.sum(a, b);
    }

    @GetMapping(path = "/minus")
    public String minusAnswer(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return calculateService.minus(a, b);
    }

    @GetMapping(path = "/division")
    public ResponseEntity<String> divisionAnswer(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {

        try {
            return ResponseEntity.ok(calculateService.division(a,b));
        }catch (ArithmeticException e){
            return ResponseEntity.badRequest().body("Делить на ноль нельзя");
        }
    }

    @GetMapping(path = "/multiplication")
    public String multiplicationAnswer(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return String.format(calculateService.multiplication(a, b));
    }
}
