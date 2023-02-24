package web.calculate.cal;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService{
    @Override
    public String sum(int a, int b) {
        return String.valueOf(a) + "+" + String.valueOf(b) +" = " + String.valueOf(a+b);
    }

    @Override
    public String minus(int a, int b) {
        return "d";
    }

    @Override
    public String division(int a, int b) {
            if(a == 0 || b == 0){
                return "Деление на 0 невозможно";
            }else {
                return String.valueOf(a) + "/" + String.valueOf(b) +" = " + String.valueOf(a/b);
            }
        }

    @Override
    public String multiplication(int a, int b) {
        return String.valueOf(a) + "*" + String.valueOf(b) +" = " + String.valueOf(a*b);
    }
}
