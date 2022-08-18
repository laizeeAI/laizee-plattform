package de.laizee.model;

/**
 * This object class represents an extension of {@link GenericPair} and stores an expected
 * {@link Result} and actual {@link Result}.
 */
public class ResultPair extends GenericPair<Result, Result> {

    /**
     * Constructor.
     *
     * @param resultExpected given expected result
     * @param resultActual   given actual result
     */
    public ResultPair(Result resultExpected, Result resultActual) {
        super(resultExpected, resultActual);
    }
}
