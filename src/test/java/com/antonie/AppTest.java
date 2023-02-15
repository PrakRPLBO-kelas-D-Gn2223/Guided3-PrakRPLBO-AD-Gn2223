package com.antonie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    static UjiMethod oUjiMethod = new UjiMethod();
    @BeforeAll
    public static void init() {
        System.out.println("Mulai test!");
    }

    @AfterAll
    public static void destory(){
        System.out.println("AKHIRRR Sukses semua!");
    }
    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }
    /**
     * Rigourous Test :-)
     */

    @ParameterizedTest
    @ValueSource(booleans = {false})
    public void testUjiBoolean(boolean input)
    {
        assertTrue( oUjiMethod.ujiBoolean(input) );
    }

    @ParameterizedTest
    @MethodSource("inputIntegers")
    public void testUjiInteger(int input)
    {
        assertEquals(oUjiMethod.ujiInteger(input),input+15);
    }
    private static Stream<Arguments> inputIntegers(){
        return Stream.of(
                Arguments.of(10),
                Arguments.of(15),
                Arguments.of(25)
        );
    }

    @ParameterizedTest
    @MethodSource("inputDoublesDuaSetengah")
    public void testUjiDoubleBesar(double input)
    {
        assertEquals(oUjiMethod.ujiDouble(input),input+2.5);
    }
    private static Stream<Arguments> inputDoublesDuaSetengah(){
        return Stream.of(
                Arguments.of(5.1),
                Arguments.of(10.2),
                Arguments.of(7.4)
        );
    }

    @ParameterizedTest
    @MethodSource("inputDoublesKecil")
    public void testUjiDoubleKecil(double input)
    {
        assertEquals(oUjiMethod.ujiDouble(input),0.5);
    }
    private static Stream<Arguments> inputDoublesKecil(){
        return Stream.of(
                Arguments.of(1.0),
                Arguments.of(2.2),
                Arguments.of(0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputString")
    public void testUjiString(String input)
    {
        assertEquals(oUjiMethod.ujiString(input),"benar");
    }
    private static Stream<Arguments> inputString(){
        return Stream.of(
                Arguments.of("dutaWACANA"),
                Arguments.of("dUTAwacaNA"),
                Arguments.of("DUTAWACANA")
        );
    }
}
