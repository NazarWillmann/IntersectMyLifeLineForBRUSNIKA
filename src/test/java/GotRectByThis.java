import org.example.RECTangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GotRectByThis {

    static Stream<Arguments> iHateRectangles() {
        return Stream.of(
                // Общие тесты
                Arguments.of(new Rectangle(0, 0, 2, 2), new Rectangle(1, 1, 2, 2), true),    // Точка внутри
                Arguments.of(new Rectangle(0, 0, 2, 2), new Rectangle(0, 0, 2, 2), true),    // Тот же прямоугольник
                Arguments.of(new Rectangle(0, 0, 2, 2), new Rectangle(2, 0, 2, 2), true),    // Касающийся
                Arguments.of(new Rectangle(0, 0, 4, 4), new Rectangle(2, 2, 4, 4), true),    // Наложение
                Arguments.of(new Rectangle(0, 0, 1, 1), new Rectangle(2, 2, 1, 1), false),   // Нет пересечения
                Arguments.of(new Rectangle(0, 0, 2, 2), new Rectangle(2, 2, 2, 2), true),    // Касание границы
                Arguments.of(new Rectangle(0, 0, 4, 4), new Rectangle(1, 1, 2, 2), true),    // Одно содержится внутри другого
                Arguments.of(new Rectangle(0, 0, 2, 2), new Rectangle(2, 0, 1, 1), true),    // Касаясь края
                // Дополнительные тесты
                Arguments.of(new Rectangle(0, 0, 5, 5), new Rectangle(1, 1, 2, 2), true),    // Other полностью внутри This
                Arguments.of(new Rectangle(0, 0, 3, 3), new Rectangle(3, 0, 1, 3), true),    // Other касается This по стороне
                Arguments.of(new Rectangle(0, 0, 2, 4), new Rectangle(1, 2, 2, 2), true),    // Частичное пересечение
                Arguments.of(new Rectangle(0, 0, 2, 2), new Rectangle(1, 1, 0, 0), true),    // Прямоугольник с нулевыми размерами внутри другого
                Arguments.of(new Rectangle(-1, -1, 2, 2), new Rectangle(1, 1, 2, 2), true),  // Пересечение с отрицательными координатами
                Arguments.of(new Rectangle(-1, -1, 1, 1), new Rectangle(1, 1, 1, 1), false), // Нет пересечения в разных квадрантах
                Arguments.of(new Rectangle(0, 0, 5, 5), new Rectangle(4, 4, 3, 3), true)     // Значительное пересечение
        );
    }

    @ParameterizedTest
    @MethodSource("iHateRectangles")
    public void testIntersects(RECTangle This, RECTangle Other, boolean expected) {
        assertEquals(expected, This.intersects(Other));
    }
}

