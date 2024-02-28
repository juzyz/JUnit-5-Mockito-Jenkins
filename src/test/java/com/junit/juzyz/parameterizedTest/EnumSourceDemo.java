package com.junit.juzyz.parameterizedTest;

import com.junit.juzyz.example.StringHelper;
import com.junit.juzyz.parameterizedTest.sourceEnum.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnumSourceDemo {

    @ParameterizedTest
    @EnumSource(value = Animal.class)
    public void enumSourceTest(Animal animal) {
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class, names ={"DOG", "CAT"})
    public void enumSourceWithNamesTest(Animal animal) {
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class, mode = EnumSource.Mode.EXCLUDE, names = {"DOG", "CAT"})
    public void enumSourceWithExcludeModeTest(Animal animal) {
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class, mode = EnumSource.Mode.MATCH_ALL, names = "^(C|L).+$") // cat or lion
    public void enumSourceWithMatchAllModeTest(Animal animal) {
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class, mode = EnumSource.Mode.MATCH_NONE, names = "^(C|L).+$") // not cat or lion
    public void enumSourceWithMatchNoneModeTest(Animal animal) {
        assertNotNull(animal);
    }
}
