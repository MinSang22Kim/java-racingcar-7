package racingcar.model;

import java.util.List;
import racingcar.message.ErrorMessage;
import racingcar.exception.CarNameException;
import racingcar.util.MoveStrategy;

public class RacingCars implements Cars {
    private final MoveStrategy moveStrategy;
    private final List<Car> cars;

    public RacingCars(List<Car> cars, MoveStrategy moveStrategy) {
        validateEmpty(cars);
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void moveCars() {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.moveForward();
            }
        }
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    private void validateEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new CarNameException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
