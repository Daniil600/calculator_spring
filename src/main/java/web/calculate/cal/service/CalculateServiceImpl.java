package web.calculate.cal.service;

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
            throw new ValidationException();
        }
    }

    public void divisionCheckException(Integer a, Integer b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("делить на 0 нельзя");
        }
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        checkParams(a, b);
        return a + b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        checkParams(a, b);
        return a - b;
    }

    @Override
    public Integer division(Integer a, Integer b) {
        checkParams(a, b);
        divisionCheckException(a, b);
        return a / b;

    }

    @Override
    public Integer multiplication(Integer a, Integer b) {
        checkParams(a, b);
        return a * b;
    }
}
