package web.calculate.cal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculateController {
    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }
@GetMapping
    public String calculatorHello(){
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/sum")
    public String sumAnswer(@RequestParam int a, @RequestParam int b){
        return calculateService.sum(a,b);
    }

    @GetMapping(path = "/minus")
    public String minusAnswer(@RequestParam int a, @RequestParam int b){
        return calculateService.minus(a,b);
    }

    @GetMapping(path = "/division")
    public String divisionAnswer(@RequestParam int a, @RequestParam int b){
        return calculateService.division(a,b);
    }

    @GetMapping(path = "/multiplication")
    public String multiplicationAnswer(@RequestParam int a, @RequestParam int b){
        return calculateService.multiplication(a,b);
    }
}
