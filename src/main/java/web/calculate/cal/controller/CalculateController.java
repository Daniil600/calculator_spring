package web.calculate.cal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Integer sumAnswer(@RequestParam Integer a, @RequestParam Integer b) {

        return calculateService.sum(a, b);
    }

    @GetMapping(path = "/minus")
    public Integer minusAnswer(@RequestParam Integer a, @RequestParam Integer b) {
        return calculateService.minus(a, b);
    }

    @GetMapping(path = "/division")
    public Integer divisionAnswer(@RequestParam Integer a, @RequestParam Integer b) {
        return calculateService.division(a, b);
    }

    @GetMapping(path = "/multiplication")
    public Integer multiplicationAnswer(@RequestParam Integer a, @RequestParam Integer b) {
        return calculateService.multiplication(a, b);
    }
}
