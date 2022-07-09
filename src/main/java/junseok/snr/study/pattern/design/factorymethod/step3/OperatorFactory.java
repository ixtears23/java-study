package junseok.snr.study.pattern.design.factorymethod.step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorFactory {
    static Map<Operator, Operation> operationMap = new HashMap<>();
    static {
        operationMap.put(Operator.ADD, new Addition());
        operationMap.put(Operator.DIVIDE, new Divide());
    }

    public static Optional<Operation> getOperation(Operator operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }
}
