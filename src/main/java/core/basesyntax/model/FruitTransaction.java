package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitType;
    private int amount;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Operation getOperationType(String operation) {
        if (operation.equals("b")) {
            return Operation.BALANCE;
        } else if (operation.equals("s")) {
            return Operation.SUPPLY;
        } else if (operation.equals("p")) {
            return Operation.PURCHASE;
        } else if (operation.equals("r")) {
            return Operation.RETURN;
        } else {
            throw new RuntimeException("Invalid operation " + operation);
        }
    }

    public enum Operation {
      BALANCE("b"),
      SUPPLY("s"),
      PURCHASE("p"),
      RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (this != null) {
            result += 31 * (operation == null ? 0 : operation.hashCode());
            result += 31 * (fruitType == null ? 0 : fruitType.hashCode());
            result += 31 * amount;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            FruitTransaction currentTransaction = (FruitTransaction) obj;
            return (currentTransaction.operation == this.operation
                    || (currentTransaction.operation != null
                    && currentTransaction.operation.equals(this.operation))
                    && (currentTransaction.fruitType == this.fruitType
                    || currentTransaction.fruitType != null
                    && currentTransaction.fruitType.equals(this.fruitType))
                    && (this.amount == currentTransaction.amount));
        }
        return false;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
              + "operation=" + operation
              + ", fruitType='" + fruitType + '\''
              + ", amount=" + amount
              + '}';
    }
}
