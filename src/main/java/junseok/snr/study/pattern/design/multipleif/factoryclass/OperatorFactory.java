package junseok.snr.study.pattern.design.multipleif.factoryclass;

import java.util.EnumMap;
import java.util.Optional;

public class OperatorFactory {
    private OperatorFactory() {}
    private static final EnumMap<Operator, Operation> operationMap = new EnumMap<>(Operator.class);
    static {
        operationMap.put(Operator.ADD, new Addition());
        operationMap.put(Operator.SUB, new Subtraction());
        operationMap.put(Operator.MUL, new Multiplication());
        operationMap.put(Operator.DIV, new Divide());
    }

    public static Optional<Operation> getOperation(Operator operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }
}
