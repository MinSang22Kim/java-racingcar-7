package racingcar.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import racingcar.message.ErrorMessage;
import racingcar.exception.CarNameException;
import racingcar.util.MoveStrategy;

public class RacingCars implements Cars {
    private final MoveStrategy moveStrategy;
    private final Collection<Car> cars;

    public RacingCars(Collection<Car> cars, MoveStrategy moveStrategy) {
        validateEmpty(cars);
        validateDuplicateNames(cars);
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
    public Collection<Car> getCars() {
        return cars;
    }

    private void validateEmpty(Collection<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new CarNameException(ErrorMessage.CAR_NAME_IS_EMPTY.getMessage());
        }
    }

    private void validateDuplicateNames(Collection<Car> cars) {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            if (!carNames.add(car.getName())) {
                throw new CarNameException(ErrorMessage.CAR_NAME_IS_DUPLICATED.getMessage());
            }
        }
    }
}
