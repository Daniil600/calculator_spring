package web.calculate.cal.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Service
public class CalculateServiceImpl implements CalculateService {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Ошибка валидации")
    public class ValidationException extends RuntimeException {
    }

    public void checkParams(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new RuntimeException("Нет одного из параметров");
        }
    }


    @Override
    public String sum(Integer a, Integer b) {
        checkParams(a, b);
        return String.format(String.valueOf(a + b));
    }

    @Override
    public String minus(Integer a, Integer b) {
        checkParams(a, b);
        return String.format(String.valueOf(a - b));
    }

    @Override
    public String division(Integer a, Integer b) {

        return String.format(String.valueOf(a / b));

    }

    @Override
    public String multiplication(Integer a, Integer b) {
        checkParams(a, b);
        return String.format(String.valueOf(a * b));
    }
}
